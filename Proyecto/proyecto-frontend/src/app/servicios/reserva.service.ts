import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../entities/cliente';
import { Objres } from '../entities/objres';
import { Reserva } from '../entities/reserva';
import { Viaje } from '../entities/viaje';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {

  constructor(private http: HttpClient) { }

  CrearReservaUrl = "http://localhost:8080/ver/cliente/GuardarReserva";

  CrearReserva(cliente: Cliente, viaje: Viaje): Observable<Reserva>{
    const dato: Objres = ({cliente, viaje});
    return this.http.post<Reserva>(this.CrearReservaUrl, dato);
  }
}
