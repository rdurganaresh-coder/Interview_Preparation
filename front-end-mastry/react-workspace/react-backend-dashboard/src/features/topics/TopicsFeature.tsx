import { useEffect, useState } from 'react';
import { TopicItem } from '@front-end-mastry/shared-models';

const FALLBACK_TOPICS: TopicItem[] = [
  { id: 1, title: 'Spring Boot REST Basics', category: 'Spring Boot', completed: true },
  { id: 2, title: 'Spring Security JWT', category: 'Spring Boot', completed: false }
];

export function TopicsFeature() {
  const [topics, setTopics] = useState<TopicItem[]>(FALLBACK_TOPICS);
  const [status, setStatus] = useState('Showing local fallback data');

  useEffect(() => {
    fetch('http://localhost:8102/api/topics')
      .then(r => r.json())
      .then((data: string[]) => {
        setTopics(data.map((title, idx) => ({ id: idx + 1, title, category: 'Spring Boot', completed: true })));
        setStatus('Connected to Spring Boot (:8102)');
      })
      .catch(() => setStatus('Backend :8102 offline — using shared-models fallback'));
  }, []);

  return (
    <section>
      <h2>Spring Boot Topics Module</h2>
      <p><em>{status}</em></p>
      <ul>
        {topics.map(t => (
          <li key={t.id}><strong>{t.title}</strong> — {t.category}</li>
        ))}
      </ul>
    </section>
  );
}
