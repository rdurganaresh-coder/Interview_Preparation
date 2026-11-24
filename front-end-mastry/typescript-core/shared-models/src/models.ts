export interface TopicItem {
  id: number;
  title: string;
  category: 'Core Java' | 'Spring Boot' | 'Microservices' | 'AWS' | 'Frontend';
  completed: boolean;
}

export interface OrderSummary {
  orderId: string;
  item: string;
  amount: number;
  status: 'PENDING' | 'PAID' | 'SHIPPED';
}

export interface ApiResponse<T> {
  timestamp: string;
  sourcePort: number;
  data: T;
}
