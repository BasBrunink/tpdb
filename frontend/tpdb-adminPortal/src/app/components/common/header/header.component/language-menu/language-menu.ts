import {Component, Signal, signal, WritableSignal} from '@angular/core';
import {LANGUAGES} from '../../../../../config/constants/Language';
import {TranslateService} from '@ngx-translate/core';

@Component({
  selector: 'app-language-menu',
  imports: [],
  styles: [`
    .lang-menu {
      display: flex;
      gap: 0.5rem;
      justify-content: center;
      align-items: center;
      padding: 0.5rem;
      border-radius: 999px;
      background-color: #f3f4f6;
      box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }
    .lang-btn {
      font-size: 1.5rem;
      background: none;
      border: none;
      cursor: pointer;
      transition: transform 0.2s ease;
    }
    .lang-btn.active {
      transform: scale(1.2);
    }
  `],
  template: `
    <div class="lang-menu">

      @for(lang of languages; track $index) {
        <button
          class="lang-btn"
          [class.active]="lang.code === currentLang()"
          (click)="switchLang(lang.code)"
          [title]="lang.label"
        >
          {{ lang.flag }}
        </button>
      }

    </div>
  `
})
export class LanguageMenu {

  languages = LANGUAGES;
  currentLang!: WritableSignal<string>;

  constructor(private translate: TranslateService) {
    // Determine the initial language


    // Initialize the signal after translate is set
    this.currentLang = signal(this.translate.currentLang);

    // Keep the signal updated
    this.translate.onLangChange.subscribe(e => this.currentLang.set(e.lang));
  }

  switchLang(lang: string) {
    this.translate.use(lang);
    this.currentLang.set(lang);
  }
}
