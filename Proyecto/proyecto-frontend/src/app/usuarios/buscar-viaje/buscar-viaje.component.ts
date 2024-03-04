import { Component, Input } from '@angular/core';
import { ViajesComponent } from '../../viajes/viajes.component';
import { FormularioUsuariosComponent } from '../../viajes/formulario-usuarios/formulario-usuarios.component';
import { FormsModule } from '@angular/forms';
import { DatosService } from '../../servicios/datos.service';

@Component({
  selector: 'app-buscar-viaje',
  standalone: true,
  imports: [ViajesComponent,FormularioUsuariosComponent, FormsModule],
  templateUrl: './buscar-viaje.component.html',
  styleUrl: './buscar-viaje.component.css'
})
export class BuscarViajeComponent {

  destino: String;
  constructor(private datosServicio: DatosService){}

  Busqueda(){
    console.log("se preciono");
    this.datosServicio.setDatoDestino(this.destino);
  }

  AbrirFomulario(){
    const modal = document.getElementById("buscar_viaje")
    if (modal!= null) 
    modal.style.display="block";
  }
  cerrarFormulario(){
    const modal = document.getElementById("buscar_viaje")
    if (modal!= null) 
    modal.style.display="none";
  }
}
