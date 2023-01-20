import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class PurchaseService {

  private baseUrl = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) { }

  getPurchaseList(): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'purchases-list');
  }

  createPurchase(purchase: object): Observable<object> {
    return this.http.post(`${this.baseUrl}` + 'save-purchase', purchase);
  }

  deletePurchase(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete-purchase/${id}`, { responseType: 'text' });
  }

  getPurchase(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/purchase/${id}`);
  }

  updatePurchase(id: number, value: any): Observable<Object> {
    return this.http.post(`${this.baseUrl}/update-purchase/${id}`, value);
  }

}
