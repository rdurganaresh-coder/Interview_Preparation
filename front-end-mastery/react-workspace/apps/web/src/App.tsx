import { useState } from "react";
import { Button } from "@mastery/ui";
import { getOrders, type OrderDto } from "@mastery/api-client";

export function App() {
  const [orders, setOrders] = useState<OrderDto[]>([]);
  const [error, setError] = useState<string | null>(null);

  const load = async () => {
    try {
      setOrders(await getOrders());
      setError(null);
    } catch (e) {
      setError(e instanceof Error ? e.message : "Unknown error");
    }
  };

  return (
    <main style={{ fontFamily: "system-ui", padding: "2rem" }}>
      <h1>Java + React Full-Stack Mastery</h1>
      <Button onClick={load}>Load orders from Spring Boot</Button>
      {error && <p role="alert">{error}</p>}
      <ul>
        {orders.map((o) => (
          <li key={o.id}>{o.item} - {o.amount}</li>
        ))}
      </ul>
    </main>
  );
}
