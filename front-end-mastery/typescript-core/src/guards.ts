export interface Order {
  id: string;
  amount: number;
}

export function isOrder(value: unknown): value is Order {
  return (
    typeof value === "object" &&
    value !== null &&
    typeof (value as Order).id === "string" &&
    typeof (value as Order).amount === "number"
  );
}
