import { Link, Navigate, Route, Routes } from 'react-router-dom';
import { TopicsFeature } from './features/topics/TopicsFeature';
import { OrdersFeature } from './features/orders/OrdersFeature';

export default function App() {
  return (
    <div style={{ fontFamily: 'system-ui', padding: '2rem' }}>
      <h1>React Backend Dashboard (Port 3004)</h1>
      <nav style={{ display: 'flex', gap: '1rem', marginBottom: '1.5rem', borderBottom: '1px solid #ddd', paddingBottom: '0.75rem' }}>
        <Link to="/topics">Topics Feature (:8102)</Link>
        <Link to="/orders">Orders Feature (:8200)</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Navigate to="/topics" replace />} />
        <Route path="/topics" element={<TopicsFeature />} />
        <Route path="/orders" element={<OrdersFeature />} />
      </Routes>
    </div>
  );
}
