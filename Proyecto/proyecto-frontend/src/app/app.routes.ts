import { Routes } from '@angular/router';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { AdministradorComponent } from './administrador/administrador.component';

export const routes: Routes = [
{path:"usuarios",component: UsuariosComponent},
{path: "administrador", component: AdministradorComponent}
];