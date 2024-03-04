import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavComponent } from './nav/nav.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { AdministradorComponent } from './administrador/administrador.component';
import { BuscarViajeComponent } from './usuarios/buscar-viaje/buscar-viaje.component';
import { ConsultarReservaComponent } from './usuarios/consultar-reserva/consultar-reserva.component';
import { ViajesComponent } from './viajes/viajes.component';
import { FormularioUsuariosComponent } from './viajes/formulario-usuarios/formulario-usuarios.component';
import { ListaPorDiaComponent } from './administrador/lista-por-dia/lista-por-dia.component';
import { ListaPorBusComponent } from './administrador/lista-por-bus/lista-por-bus.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, 
    NavComponent, 
    UsuariosComponent, 
    AdministradorComponent,
    BuscarViajeComponent,
    ConsultarReservaComponent,
    FormularioUsuariosComponent,
    ListaPorDiaComponent,
    ListaPorBusComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Viajes Mi Cacharrito';
}
