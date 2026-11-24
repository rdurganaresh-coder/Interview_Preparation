import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
  template: `
    <div style="font-family: system-ui; padding: 2rem;">
      <h1>Angular Backend Dashboard (Port 4202)</h1>
      <nav style="display: flex; gap: 1rem; margin-bottom: 1.5rem; border-bottom: 1px solid #ddd; padding-bottom: 0.75rem;">
        <a routerLink="/topics" routerLinkActive="active">Topics Feature (:8102)</a>
        <a routerLink="/orders" routerLinkActive="active">Orders Feature (:8200)</a>
      </nav>
      <router-outlet></router-outlet>
    </div>
  `,
  styles: [`
    a { text-decoration: none; color: #333; font-weight: 500; }
    a.active { color: #dd0031; border-bottom: 2px solid #dd0031; }
  `]
})
export class AppComponent {}
