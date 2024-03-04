import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../entities/cliente';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(private http: HttpClient) {}

  private bdGuardarCliente = "http://localhost:8080/ver/cliente/GuardarInfoCliente"

  GuardarCliente(cliente: Cliente): Observable<Cliente>{
    return this.http.post<Cliente>(this.bdGuardarCliente, cliente);
  }
}
