import { CommonModule, DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Reserva } from '../../entities/reserva';

@Component({
  selector: 'app-consultar-reserva',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './consultar-reserva.component.html',
  styleUrl: './consultar-reserva.component.css'
})
export class ConsultarReservaComponent implements OnInit {

  muestra: Reserva[]
  hora_colocar = new Date()
  ngOnInit(): void {
    this.hora_colocar.setHours(10);
    
    this.muestra = [{
      "destino":"medellin",
      fecha: new Date(2024, 10, 10),
      hora_reserva: this.hora_colocar,
      valor:2000
    }]
  }

  AbrirFomulario(){
    const modal = document.getElementById("consultar")
    if (modal!= null) 
    modal.style.display="block";
  }
  cerrarFormulario(){
    const modal = document.getElementById("consultar")
    if (modal!= null) 
    modal.style.display="none";
  }
  
  confirmarEliminarReserva(){
    const modal = document.getElementById("confirmar")
    if (modal!= null) 
    modal.style.display="block";
  }
  cerrarConfirmacion(){
    const modal = document.getElementById("confirmar")
    if (modal!= null) 
    modal.style.display="none";
  }

}
