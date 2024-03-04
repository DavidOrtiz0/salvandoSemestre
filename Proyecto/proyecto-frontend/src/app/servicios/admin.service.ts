import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Administrador } from '../entities/administrador';


@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private AdmSesionURL = "http://localhost:8080/adm/inicioSesion";
  constructor(private http:HttpClient) { }

  IniciarSesion(credenciales:Administrador): Observable<boolean>{
    return this.http.post<boolean>(this.AdmSesionURL, credenciales);
  }
}
