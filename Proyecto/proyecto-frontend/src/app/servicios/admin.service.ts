import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Administrador } from '../entities/administrador';
import { Reserva } from '../entities/reserva';


@Injectable({
  providedIn: 'root'
})
export class AdminService {

 
  constructor(private http:HttpClient) { }

  private AdmSesionURL = "http://localhost:8080/adm/inicioSesion";
  IniciarSesion(credenciales:Administrador): Observable<boolean>{
    return this.http.post<boolean>(this.AdmSesionURL, credenciales);
  }

  private ListaReservaPorDia ="http://localhost:8080/adm/ListarPorDia";
  listarPorDia(): Observable<Reserva[]> {
    return this.http.get<Reserva[]>(`${this.listarPorDia}`);
  }
}
