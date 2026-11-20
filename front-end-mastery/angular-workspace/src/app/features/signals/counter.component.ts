import { Component, computed, signal } from "@angular/core";

@Component({
  selector: "app-counter",
  standalone: true,
  template: `
    <section>
      <h2>Signals</h2>
      <button (click)="increment()">Count: {{ count() }}</button>
      <p>Doubled: {{ doubled() }}</p>
    </section>
  `,
})
export class CounterComponent {
  readonly count = signal(0);
  readonly doubled = computed(() => this.count() * 2);

  increment(): void {
    this.count.update((c) => c + 1);
  }
}
