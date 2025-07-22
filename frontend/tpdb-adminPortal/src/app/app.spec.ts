import { TestBed } from '@angular/core/testing';
import { App } from './app';
import {TranslateModule, TranslateService} from '@ngx-translate/core';
import {RouterTestingModule} from '@angular/router/testing';

describe('App', () => {
  let translate: TranslateService;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [App,TranslateModule.forRoot(), RouterTestingModule],

    }).compileComponents();
    translate = TestBed.inject(TranslateService);
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(App);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });
  it('should set default language to en', () => {
    const spyAddLangs = spyOn(translate, 'addLangs').and.callThrough();
    const spySetDefaultLang = spyOn(translate, 'setDefaultLang').and.callThrough();
    const spyUse = spyOn(translate, 'use').and.callThrough();

    // simulate unsupported browser language (e.g., 'fr')
    spyOn(translate, 'getBrowserLang').and.returnValue('fr');

    const fixture = TestBed.createComponent(App);

    // Manually call constructor logic if needed (if not automatically run)
    // Or call ngOnInit if logic is there instead of constructor

    expect(spyAddLangs).toHaveBeenCalledWith(['en', 'nl', 'de']);
    expect(spySetDefaultLang).toHaveBeenCalledWith('en');
    expect(spyUse).toHaveBeenCalledWith('en'); // 'fr' is unsupported, fallback to 'en'
  });

  it('should use supported browser language if available', () => {
    spyOn(translate, 'addLangs').and.callThrough();
    spyOn(translate, 'setDefaultLang').and.callThrough();
    const spyUse = spyOn(translate, 'use').and.callThrough();

    // simulate supported browser language 'de'
    spyOn(translate, 'getBrowserLang').and.returnValue('de');

    const fixture = TestBed.createComponent(App);

    expect(spyUse).toHaveBeenCalledWith('de');
  });
});
