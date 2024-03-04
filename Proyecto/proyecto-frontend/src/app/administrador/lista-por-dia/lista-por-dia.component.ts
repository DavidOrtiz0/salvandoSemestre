import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-por-dia',
  standalone: true,
  imports: [],
  templateUrl: './lista-por-dia.component.html',
  styleUrl: './lista-por-dia.component.css'
})
export class ListaPorDiaComponent implements OnInit{

 
  ngOnInit(): void {
    this.EstadoPredeterminado();
    
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

  }




