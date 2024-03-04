import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Administrador } from '../entities/administrador';
import { RouterOutlet } from '@angular/router';
import { ListaPorDiaComponent } from './lista-por-dia/lista-por-dia.component';
import { ListaPorBusComponent } from './lista-por-bus/lista-por-bus.component';
import { ViajesComponent } from '../viajes/viajes.component';
import { BuscarViajeComponent } from '../usuarios/buscar-viaje/buscar-viaje.component';
import { AdminService } from '../servicios/admin.service';

@Component({
  selector: 'app-administrador',
  standalone: true,
  imports: [ FormsModule, 
    CommonModule,RouterOutlet, 
    ListaPorDiaComponent, 
    ListaPorBusComponent,
  ViajesComponent,
  BuscarViajeComponent ],
  templateUrl: './administrador.component.html',
  styleUrl: './administrador.component.css'
})

export class AdministradorComponent implements OnInit{
 administrador = new Administrador;
 validacion: boolean;
 usuario: String;
 contrasena: String;

constructor(private admService: AdminService) {}

  ngOnInit(): void {
    this.mostrarPorDefecto();
  }

  validar(){
    this.administrador = ({
      usuario: this.usuario,
      contrasena: this.contrasena
    })

    this.admService.IniciarSesion(this.administrador).subscribe({
      next: (DatosUsuario) =>{
        if(DatosUsuario == true){
          this.validacionHecha();
        }else{
          alert("datos equivocados");
        }
        console.log("el dato es: "+ DatosUsuario);
      },
      error:(DatosError) =>{
        console.error(DatosError);
      },
      complete: () =>{
        console.info("accion completada");
      }
    });
    
  }

  validacionHecha(){
    if(typeof document != undefined){

      const modal = document.getElementById("indexAdm")
      if(modal!= null){
        modal.style.display="block";
      }

      const modal2 = document.getElementById("logIn")
      if(modal2!= null){
        modal2.style.display="none";
      }
    }

  }

  mostrarPorDefecto(){
    if(typeof document != undefined){

      const modal = document.getElementById("indexAdm")
      if(modal!= null){
        modal.style.display="none";
      }

      const modal2 = document.getElementById("logIn")
      if(modal2!= null){
        modal2.style.display="block";
      }
    }
  }

}
