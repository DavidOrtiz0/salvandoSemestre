import { Component, OnInit } from '@angular/core';
import { ReservaService } from '../../servicios/reserva.service';
import { Reserva } from '../../entities/reserva';
import { AdminService } from '../../servicios/admin.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-lista-por-dia',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './lista-por-dia.component.html',
  styleUrl: './lista-por-dia.component.css'
})
export class ListaPorDiaComponent implements OnInit{

 reserva: Reserva[];
  ngOnInit(): void {
    this.EstadoPredeterminado();
    
  }
  constructor(private adminservicio : AdminService){

  }

  EstadoPredeterminado(){
    if(typeof document !== undefined){
      const modal = document.getElementById("ListaRDia")
      if (modal!= null){
        modal.style.display="none";
      }
    }
  }

  abrirLista(){
      if(typeof document !== undefined){
        const modal = document.getElementById("ListaRDia")
        if (modal!= null){
          modal.style.display="block";
        }
      }
    }

    consultarReservaHoy() {
      this.adminservicio.listarPorDia()
        .subscribe(
          (dato: Reserva[]) => {
            if (dato && dato.length > 0) {
              this.reserva = dato; // Asignar las reservas a reserva
              console.log(dato);
            } else { 
              alert("No se encontraron reservas hoy");
            }
          },
  
  )}

  }




