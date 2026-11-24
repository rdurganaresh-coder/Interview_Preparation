import { useState } from 'react';
import { TopicItem } from '@front-end-mastry/shared-models';

export default function App() {
  const [topics, setTopics] = useState<TopicItem[]>([
    { id: 1, title: 'React Hooks & State', category: 'Frontend', completed: true },
    { id: 2, title: 'Shared Workspace Models', category: 'Frontend', completed: false }
  ]);

  const toggleTopic = (id: number) => {
    setTopics(prev => prev.map(t => (t.id === id ? { ...t, completed: !t.completed } : t)));
  };

  return (
    <div style={{ fontFamily: 'system-ui', padding: '2rem' }}>
      <h1>React Basics (Port 3003)</h1>
      <p>Using <code>@front-end-mastry/shared-models</code></p>
      <ul>
        {topics.map(t => (
          <li key={t.id} onClick={() => toggleTopic(t.id)} style={{ cursor: 'pointer', marginBottom: '0.5rem' }}>
            [{t.completed ? 'x' : ' '}] <strong>{t.title}</strong> ({t.category})
          </li>
        ))}
      </ul>
    </div>
  );
}
