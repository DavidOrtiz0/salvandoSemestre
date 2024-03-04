import { Cliente } from "./cliente";
import { Viaje } from "./viaje";

export class Reserva {
    id_reserva : number;
    cc_cliente: Cliente;
    id_viaje: Viaje;
    puesto_asignado: number;
    estado_de_pago:boolean;
    fecha_de_reserva: Date;
}
