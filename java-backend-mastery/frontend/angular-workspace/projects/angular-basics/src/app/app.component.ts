import { Component } from '@angular/core';
import { BannerComponent } from '../../../shared-lib/src/lib/banner.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [BannerComponent],
  template: `<lib-banner title="angular-basics (Port 4201)"></lib-banner>`
})
export class AppComponent {}
