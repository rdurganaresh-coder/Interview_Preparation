import { Routes } from '@angular/router';

export const APP_ROUTES: Routes = [
  { path: '', redirectTo: 'topics', pathMatch: 'full' },
  {
    path: 'topics',
    loadChildren: () => import('./features/topics/topics.routes').then(m => m.TOPICS_ROUTES)
  },
  {
    path: 'orders',
    loadChildren: () => import('./features/orders/orders.routes').then(m => m.ORDERS_ROUTES)
  }
];
