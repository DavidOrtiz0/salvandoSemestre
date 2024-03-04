import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { Bus } from '../entities/bus';
import { Viaje } from '../entities/viaje';
import { DatosService } from '../servicios/datos.service';
import { ViajeService } from '../servicios/viaje.service';
import { FormularioUsuariosComponent } from './formulario-usuarios/formulario-usuarios.component';

@Component({
  selector: 'app-viajes',
  standalone: true,
  imports: [CommonModule, FormularioUsuariosComponent],
  templateUrl: './viajes.component.html',
  styleUrl: './viajes.component.css'
})
export class ViajesComponent{

  viajes: Viaje[];
  viajeSeleccionado: any;

  constructor(private viajeServicio: ViajeService, private datosServicio: DatosService){}

  MostrarViajes(){
    this.datosServicio.getDatoDestino().subscribe(data =>{
      console.log("el dato es: " + data);
      const destino: String = String(data);
      this.Ejecutar(destino);
    });

  }

  Ejecutar(destino: String){
    this.viajeServicio.BuscarDestino(destino).subscribe({
      next:(DatoViaje) =>{
        console.log("el dato que recibe es: " + DatoViaje);
        this.viajes = DatoViaje;
      },
      error: (ErrorViaje) =>{
        console.error("El error es: " + ErrorViaje);
      },
      complete: ()=>{
        console.info("accion de mostrar viaje completada");
      }
    });
  }

  MostrarFormulario(viaje: Viaje){
    this.viajeSeleccionado = viaje;
  }
}
