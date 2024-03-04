import { CommonModule } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { equal } from 'assert';
import { Cliente } from '../../entities/cliente';
import { Viaje } from '../../entities/viaje';
import { DatosService } from '../../servicios/datos.service';
import { ReservaService } from '../../servicios/reserva.service';
import { UsuariosService } from '../../servicios/usuarios.service';
import { ViajesComponent } from '../viajes.component';

@Component({
  selector: 'app-formulario-usuarios',
  standalone: true,
  imports: [CommonModule, ViajesComponent, FormsModule],
  templateUrl: './formulario-usuarios.component.html',
  styleUrl: './formulario-usuarios.component.css'
})
export class FormularioUsuariosComponent implements OnInit{

  cedula: number;
  nombre: string;
  apellido: string;
  telefono: number;
  fecha_de_nacimiento: Date;
  cliente: Cliente;
  ClienteRespuesta: Cliente;
  @Input() viaje: Viaje;


  constructor(private datoServicio: DatosService, private usuarioServicio: UsuariosService, private reservaServicio: ReservaService){}
  ngOnInit(): void {
    //throw new Error('Method not implemented.');
  }

  CrearCliente(){
     this.cliente = ({
      cedula: this.cedula,
      nombre: this.nombre,
      apellido: this.apellido,
      telefono: this.telefono,
      fecha_nacimiento: this.fecha_de_nacimiento = new Date()
    })

    this.usuarioServicio.GuardarCliente(this.cliente).subscribe({
      next: (DatoCliente) =>{
        if(DatoCliente.cedula == this.cliente.cedula){
          this.CrearReserva(this.cliente, this.viaje);
          this.cerrarFormulario();
        }
      },
      error: (DatoError)=>{
        console.error("el error es: ",DatoError);
      },
      complete:()=>{
        console.info("crear cliente ha sido ejecutado");
      }
    });
    

  }

  CrearReserva(cliente: Cliente, viaje: Viaje){
    this.reservaServicio.CrearReserva(cliente, viaje);
  }

  AbrirFomulario(){
    const modal = document.getElementById("formulario-clientes")
    if (modal!= null){modal.style.display="block";} 
  }
  
  cerrarFormulario(){
    const modal = document.getElementById("formulario-clientes")
    if (modal!= null) 
    modal.style.display="none";
  }

}
