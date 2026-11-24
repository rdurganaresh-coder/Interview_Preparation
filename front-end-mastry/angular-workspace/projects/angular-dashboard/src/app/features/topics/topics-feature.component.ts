import { Component, OnInit, inject, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TopicItem } from '@front-end-mastry/shared-models';

@Component({
  selector: 'app-topics-feature',
  standalone: true,
  template: `
    <section>
      <h2>Spring Boot Topics Feature</h2>
      <p><em>{{ status() }}</em></p>
      <ul>
        @for (t of topics(); track t.id) {
          <li><strong>{{ t.title }}</strong> — {{ t.category }}</li>
        }
      </ul>
    </section>
  `
})
export class TopicsFeatureComponent implements OnInit {
  private http = inject(HttpClient);
  status = signal('Loading topics...');
  topics = signal<TopicItem[]>([
    { id: 1, title: 'Spring Data JPA & Hibernate', category: 'Spring Boot', completed: true },
    { id: 2, title: 'Spring Batch Processing', category: 'Spring Boot', completed: false }
  ]);

  ngOnInit() {
    this.http.get<string[]>('http://localhost:8102/api/topics').subscribe({
      next: data => {
        this.topics.set(data.map((title, idx) => ({ id: idx + 1, title, category: 'Spring Boot', completed: true })));
        this.status.set('Connected to Spring Boot (:8102)');
      },
      error: () => this.status.set('Backend :8102 offline — using shared-models fallback')
    });
  }
}
