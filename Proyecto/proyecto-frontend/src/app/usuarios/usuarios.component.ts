import { Component } from '@angular/core';

import { RouterOutlet } from '@angular/router';
import { BuscarViajeComponent } from './buscar-viaje/buscar-viaje.component';
import { ConsultarReservaComponent } from './consultar-reserva/consultar-reserva.component';
import { ViajesComponent } from '../viajes/viajes.component';
import { FormularioUsuariosComponent } from '../viajes/formulario-usuarios/formulario-usuarios.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-usuarios',
  standalone: true,
  imports: [RouterOutlet,
    BuscarViajeComponent,
    ConsultarReservaComponent,
    ViajesComponent,
    FormularioUsuariosComponent, 
    CommonModule],
  templateUrl: './usuarios.component.html',
  styleUrl: './usuarios.component.css'
})
export class UsuariosComponent {

}
