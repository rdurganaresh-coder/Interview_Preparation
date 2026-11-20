import { HttpClient } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { Observable } from "rxjs";

export interface OrderDto {
  id: string;
  item: string;
  amount: number;
}

@Injectable({ providedIn: "root" })
export class OrderService {
  private readonly http = inject(HttpClient);

  getOrders(): Observable<OrderDto[]> {
    return this.http.get<OrderDto[]>("/api/v1/orders");
  }
}
