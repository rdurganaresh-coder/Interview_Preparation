import { Component, signal } from '@angular/core';
import { TopicItem } from '@front-end-mastry/shared-models';

@Component({
  selector: 'app-root',
  standalone: true,
  template: `
    <div style="font-family: system-ui; padding: 2rem;">
      <h1>Angular Basics (Port 4201)</h1>
      <p>Consuming <code>&#64;front-end-mastry/shared-models</code> with Angular Signals</p>
      <ul>
        @for (topic of topics(); track topic.id) {
          <li (click)="toggle(topic.id)" style="cursor: pointer; margin-bottom: 0.5rem;">
            [{{ topic.completed ? 'x' : ' ' }}] <strong>{{ topic.title }}</strong> ({{ topic.category }})
          </li>
        }
      </ul>
    </div>
  `
})
export class AppComponent {
  topics = signal<TopicItem[]>([
    { id: 1, title: 'Angular 18 Standalone Components', category: 'Frontend', completed: true },
    { id: 2, title: 'Angular Signals State Management', category: 'Frontend', completed: false }
  ]);

  toggle(id: number) {
    this.topics.update(list => list.map(t => (t.id === id ? { ...t, completed: !t.completed } : t)));
  }
}
