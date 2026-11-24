import { useEffect, useState } from 'react';
import { OrderSummary } from '@front-end-mastry/shared-models';

const FALLBACK_ORDERS: OrderSummary[] = [
  { orderId: 'ORD-501', item: 'AWS S3 Storage Plan', amount: 25.0, status: 'PAID' },
  { orderId: 'ORD-502', item: 'Kubernetes Cluster Node', amount: 120.0, status: 'PENDING' }
];

export function OrdersFeature() {
  const [orders, setOrders] = useState<OrderSummary[]>(FALLBACK_ORDERS);
  const [status, setStatus] = useState('Showing local fallback orders');

  useEffect(() => {
    fetch('http://localhost:8200/orders')
      .then(r => r.json())
      .then((data: OrderSummary[]) => {
        if (Array.isArray(data)) setOrders(data);
        setStatus('Connected to API Gateway (:8200)');
      })
      .catch(() => setStatus('API Gateway :8200 offline — using shared-models fallback'));
  }, []);

  return (
    <section>
      <h2>Microservices Orders Module</h2>
      <p><em>{status}</em></p>
      <table border={1} cellPadding={8} style={{ borderCollapse: 'collapse' }}>
        <thead>
          <tr><th>Order ID</th><th>Item</th><th>Amount</th><th>Status</th></tr>
        </thead>
        <tbody>
          {orders.map(o => (
            <tr key={o.orderId}>
              <td>{o.orderId}</td><td>{o.item}</td><td>${o.amount}</td><td>{o.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </section>
  );
}
