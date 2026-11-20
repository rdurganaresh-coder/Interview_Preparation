export interface ApiResponse<T> {
  status: number;
  data: T;
}

export function wrapResponse<T>(data: T, status = 200): ApiResponse<T> {
  return { status, data };
}

export function groupBy<T, K extends PropertyKey>(items: readonly T[], key: (item: T) => K): Record<K, T[]> {
  const result = {} as Record<K, T[]>;
  for (const item of items) {
    (result[key(item)] ??= []).push(item);
  }
  return result;
}
