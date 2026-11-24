import { TopicItem, OrderSummary } from '@front-end-mastry/shared-models';

const sampleTopic: TopicItem = {
  id: 1,
  title: 'TypeScript Generics & Utility Types',
  category: 'Frontend',
  completed: true
};

const sampleOrder: OrderSummary = {
  orderId: 'ORD-1001',
  item: 'Spring Microservices Course',
  amount: 49.99,
  status: 'PAID'
};

console.log('Shared Topic:', sampleTopic);
console.log('Shared Order:', sampleOrder);
