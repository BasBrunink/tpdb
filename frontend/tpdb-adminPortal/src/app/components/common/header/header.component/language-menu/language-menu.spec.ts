import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LanguageMenu } from './language-menu';
import {LangChangeEvent, TranslateService} from '@ngx-translate/core';
import {Subject} from 'rxjs';
import {By} from '@angular/platform-browser';

const MOCK_LANGUAGES = [
  { code: 'en', label: 'English', flag: '🇬🇧' },
  { code: 'fr', label: 'Français', flag: '🇫🇷' },
  { code: 'de', label: 'Deutsch', flag: '🇩🇪' }
];

// Mock TranslateService
class MockTranslateService {
  currentLang = 'en';
  private langChangeSubject = new Subject<LangChangeEvent>();
  onLangChange = this.langChangeSubject.asObservable();

  use(lang: string) {
    this.currentLang = lang;
    this.langChangeSubject.next({ lang } as LangChangeEvent);
  }
}
describe('LanguageMenu', () => {
  let component: LanguageMenu;
  let fixture: ComponentFixture<LanguageMenu>;
  let translateService: MockTranslateService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LanguageMenu],
      providers: [
        { provide: TranslateService, useClass: MockTranslateService }
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LanguageMenu);
    component = fixture.componentInstance;
    translateService = TestBed.inject(TranslateService) as any;

    component.languages = MOCK_LANGUAGES;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render all language buttons', () => {
    const buttons = fixture.debugElement.queryAll(By.css('.lang-btn'));
    expect(buttons.length).toBe(MOCK_LANGUAGES.length);
    MOCK_LANGUAGES.forEach((lang, i) => {
      expect(buttons[i].nativeElement.textContent.trim()).toBe(lang.flag);
      expect(buttons[i].nativeElement.getAttribute('title')).toBe(lang.label);
    });
  });

  it('should highlight the current language', () => {
    const buttons = fixture.debugElement.queryAll(By.css('.lang-btn'));
    const activeButton = buttons.find(btn => btn.nativeElement.classList.contains('active'));
    expect(activeButton?.nativeElement.textContent.trim()).toBe('🇬🇧'); // en
  });

  it('should switch language when a button is clicked', () => {
    const buttons = fixture.debugElement.queryAll(By.css('.lang-btn'));

    // Simulate click on the second button (fr)
    buttons[1].nativeElement.click();
    fixture.detectChanges();

    expect(translateService.currentLang).toBe('fr');

    const activeBtn = fixture.debugElement.query(By.css('.lang-btn.active'));
    expect(activeBtn.nativeElement.textContent.trim()).toBe('🇫🇷');
  });

  it('should call TranslateService.use and update currentLang when switchLang is called', () => {
    const useSpy = spyOn(translateService, 'use').and.callThrough();

    component.switchLang('de');

    expect(useSpy).toHaveBeenCalledWith('de');
    expect(component.currentLang()).toBe('de');
  });

  // it('should switch language to de', () => {
  //   component.switchLang('de')
  //   expect(component.currentLang()).toBe('de')
  // })

});
