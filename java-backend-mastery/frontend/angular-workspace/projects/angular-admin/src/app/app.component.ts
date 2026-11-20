import { Component } from '@angular/core';
import { BannerComponent } from '../../../shared-lib/src/lib/banner.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [BannerComponent],
  template: `<lib-banner title="angular-admin (Port 4202)"></lib-banner>`
})
export class AppComponent {}
