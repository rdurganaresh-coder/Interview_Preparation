import { Component, OnInit, inject, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrderSummary } from '@front-end-mastry/shared-models';

@Component({
  selector: 'app-orders-feature',
  standalone: true,
  template: `
    <section>
      <h2>Microservices Orders Feature</h2>
      <p><em>{{ status() }}</em></p>
      <table border="1" cellpadding="8" style="border-collapse: collapse;">
        <thead>
          <tr><th>Order ID</th><th>Item</th><th>Amount</th><th>Status</th></tr>
        </thead>
        <tbody>
          @for (o of orders(); track o.orderId) {
            <tr>
              <td>{{ o.orderId }}</td><td>{{ o.item }}</td><td>\${{ o.amount }}</td><td>{{ o.status }}</td>
            </tr>
          }
        </tbody>
      </table>
    </section>
  `
})
export class OrdersFeatureComponent implements OnInit {
  private http = inject(HttpClient);
  status = signal('Loading orders...');
  orders = signal<OrderSummary[]>([
    { orderId: 'ORD-701', item: 'DynamoDB Provisioned Table', amount: 40.0, status: 'PAID' },
    { orderId: 'ORD-702', item: 'Eureka Service Mesh', amount: 85.0, status: 'SHIPPED' }
  ]);

  ngOnInit() {
    this.http.get<OrderSummary[]>('http://localhost:8200/orders').subscribe({
      next: data => {
        if (Array.isArray(data)) this.orders.set(data);
        this.status.set('Connected to API Gateway (:8200)');
      },
      error: () => this.status.set('API Gateway :8200 offline — using shared-models fallback')
    });
  }
}
