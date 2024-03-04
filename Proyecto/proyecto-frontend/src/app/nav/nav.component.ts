import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UsuariosComponent } from "../usuarios/usuarios.component";
import { AdministradorComponent } from '../administrador/administrador.component';

@Component({
    selector: 'app-nav',
    standalone: true,
    templateUrl: './nav.component.html',
    styleUrl: './nav.component.css',
    imports: [RouterOutlet, UsuariosComponent,AdministradorComponent ]
})
export class NavComponent {

}
