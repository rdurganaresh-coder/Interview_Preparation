import { Component, inject } from "@angular/core";
import { toSignal } from "@angular/core/rxjs-interop";
import { OrderService } from "./order.service";

@Component({
  selector: "app-orders",
  standalone: true,
  template: `
    <section>
      <h2>Orders (RxJS + HttpClient)</h2>
      <ul>
        @for (o of orders(); track o.id) {
          <li>{{ o.item }} - {{ o.amount }}</li>
        }
      </ul>
    </section>
  `,
})
export class OrdersComponent {
  private readonly service = inject(OrderService);
  readonly orders = toSignal(this.service.getOrders(), { initialValue: [] });
}
