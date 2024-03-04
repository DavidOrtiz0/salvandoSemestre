import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Viaje } from '../entities/viaje';

@Injectable({
  providedIn: 'root'
})
export class ViajeService {

  viajeUrl = "http://localhost:8080/ver/cliente/BuscarDestino";
  constructor(private http: HttpClient) { }

  BuscarDestino(destino: String): Observable<Viaje[]>{
    return this.http.post<Viaje[]>(this.viajeUrl, destino);
  }

}
