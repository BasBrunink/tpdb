import {
  ApplicationConfig, inject,
  provideAppInitializer,
  provideBrowserGlobalErrorListeners,
  provideZoneChangeDetection
} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient, withInterceptors} from '@angular/common/http';
import {provideKeycloakExt} from './config/keycloak.config';
import {tokenInterceptor} from './auth/interceptors/token.interceptor';
import {provideTranslationExt} from './config/translation.config';
import {TranslateService} from '@ngx-translate/core';


export const appConfig: ApplicationConfig = {
  providers: [
    provideKeycloakExt(),
    provideTranslationExt(),
    provideAppInitializer(() => {
      const  translate = inject(TranslateService);
      translate.use(translate.getBrowserLang() || "en");
    }),
    provideHttpClient(withInterceptors([tokenInterceptor])),
    provideBrowserGlobalErrorListeners(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes)
  ]
};
