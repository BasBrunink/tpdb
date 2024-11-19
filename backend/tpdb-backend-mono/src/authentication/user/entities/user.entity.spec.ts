import { User } from './user.entity';
import * as bcrypt from 'bcrypt';

describe('User Entity', () => {
  let user: User;

  beforeEach(() => {
    user = new User();
    user.salt = bcrypt.genSaltSync();
    user.password = bcrypt.hashSync('password123', user.salt);
  });

  it('should validate password successfully with correct password', async () => {
    const isValid = await user.validatePassword('password123');
    expect(isValid).toBe(true);
  });

  it('should fail to validate password with incorrect password', async () => {
    const isValid = await user.validatePassword('wrongPassword');
    expect(isValid).toBe(false);
  });

  it('should fail to validate password with empty password', async () => {
    const isValid = await user.validatePassword('');
    expect(isValid).toBe(false);
  });

  it('should fail to validate password with null password', async () => {
    const isValid = await user.validatePassword(null);
    expect(isValid).toBe(false);
  });

  it('should fail to validate password with undefined password', async () => {
    const isValid = await user.validatePassword(undefined);
    expect(isValid).toBe(false);
  });
});
