import { Component } from "@angular/core";
import { CounterComponent } from "./features/signals/counter.component";
import { OrdersComponent } from "./features/orders/orders.component";

@Component({
  selector: "app-root",
  standalone: true,
  imports: [CounterComponent, OrdersComponent],
  template: `
    <h1>{{ title }}</h1>
    <app-counter />
    <app-orders />
  `,
})
export class AppComponent {
  title = "Angular Mastery Workspace";
}
