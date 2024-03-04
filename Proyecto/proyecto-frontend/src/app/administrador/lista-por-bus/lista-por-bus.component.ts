import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-lista-por-bus',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './lista-por-bus.component.html',
  styleUrl: './lista-por-bus.component.css'
})
export class ListaPorBusComponent{


  AbrirConsulta(){
    if(typeof document !== undefined){
      const modal = document.getElementById("listaRBus")
      if (modal!= null){
        modal.style.display="block";
      }
    }
    
  }

  CerrarConsulta(){
    if(typeof document !== undefined){
      const modal = document.getElementById("listaRBus")
      if (modal!= null){
        modal.style.display="none";
      }
    }
  }

}
