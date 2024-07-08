import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../common/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiUrl: string="http://localhost:8088/api/v1/product";
  constructor(private http: HttpClient) { }

  getProducts():Observable<Product[]>{
    return this.http.get<Product[]>(this.apiUrl);
  }

  createProducts(formData:any):Observable<any>{
    return this.http.post<Product>(this.apiUrl,formData);
  }

  deleteProductById(id:number):Observable<any>{
    return this.http.delete(this.apiUrl+`product/${id}`);
  }

  getProductById(id:number):Observable<Product>{
    return this.http.get<Product>(this.apiUrl+`product/${id}`);
  }
}
