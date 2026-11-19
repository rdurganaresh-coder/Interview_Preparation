import { Component, Input } from '@angular/core';

@Component({
  selector: 'lib-banner',
  standalone: true,
  template: `<div class="banner">{{ title }}</div>`
})
export class BannerComponent {
  @Input() title = 'Java Backend Mastery';
}
