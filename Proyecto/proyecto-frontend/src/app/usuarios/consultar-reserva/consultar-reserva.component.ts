import { CommonModule, DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Reserva } from '../../entities/reserva';
import { ReservaService } from '../../servicios/reserva.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-consultar-reserva',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './consultar-reserva.component.html',
  styleUrl: './consultar-reserva.component.css'
})
export class ConsultarReservaComponent implements OnInit {

  reserva: Reserva[]
  cedula: number;
  hora_colocar = new Date()
  ngOnInit(): void {
    this.hora_colocar.setHours(10);
    
  }
  constructor(private reservaservicio : ReservaService){

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
  consultarReserva(cedula: number) {
    this.reservaservicio.ConsultarReservaporCed(cedula)
      .subscribe(
        (dato: Reserva[]) => {
          if (dato && dato.length > 0) {
            this.reserva = dato;
            console.log(dato);
          } else { 
            alert("No se encontraron reservas.");
          }
        },
        error => {
          console.error("Error al consultar la reserva:", error);
        }
      ); 
  }
 
}
