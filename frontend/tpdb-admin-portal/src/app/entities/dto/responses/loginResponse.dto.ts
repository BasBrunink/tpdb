
export interface LoginResponseDto {
  accessToken: string;
  user: LoginUserDto;
}

interface LoginUserDto {
  username: string;
  email: string;
}
