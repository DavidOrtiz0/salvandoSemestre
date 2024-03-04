import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Cliente } from '../entities/cliente';

@Injectable({
  providedIn: 'root'
})
export class DatosService {

  constructor() { }


  private destino = new BehaviorSubject<String>('');

  setDatoDestino(dato: String){
    this.destino.next(dato);
    
  }

  getDatoDestino(){
    return this.destino.asObservable();
  }

}
