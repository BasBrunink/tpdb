import {provideTranslateHttpLoader} from '@ngx-translate/http-loader';
import {provideTranslateService} from '@ngx-translate/core';


export const provideTranslationExt = () =>
  provideTranslateService({
    lang: 'en',
    fallbackLang: 'en',
    loader: provideTranslateHttpLoader({
      prefix: '/i18n/',
      suffix: '.json'
    })
  });
