package datos;

import com.PruebaTecnica.vtv.modelo.entidades.Automovil;
import com.PruebaTecnica.vtv.modelo.entidades.Inspector;
import com.PruebaTecnica.vtv.modelo.entidades.Propietario;
import com.PruebaTecnica.vtv.modelo.numeradores.EstadoApartado;

public class DatosDummy {
    //Automoviles
    public static Automovil auto1 = new Automovil(null, EstadoApartado.ACEPTABLE, EstadoApartado.INTERMEDIO, "unico", "toyota","corola");
    public static Automovil auto2 = new Automovil(null, EstadoApartado.ACEPTABLE, EstadoApartado.ACEPTABLE, "unico", "ford","ka");
    public static Automovil auto3 = new Automovil(null, EstadoApartado.INACEPTABLE, EstadoApartado.INTERMEDIO, "unico", "renault","12");
    public static Automovil auto4 = new Automovil(null, EstadoApartado.INTERMEDIO, EstadoApartado.INTERMEDIO, "unico", "peugeot","206");
    public static Automovil auto5 = new Automovil(null, EstadoApartado.ACEPTABLE, EstadoApartado.ACEPTABLE, "unico", "ford","fiesta");

    //Propietarios
    public static Propietario propietario1 = new Propietario(null, "Jorge", "excento");
    public static Propietario propietario2 = new Propietario(null, "john", "excento");
    public static Propietario propietario3 = new Propietario(null, "Miguel", "comun");
    public static Propietario propietario4 = new Propietario(null, "Diego", "excento");

    //Inspectores
    public static Inspector inspector1 = new Inspector("Miguel");
    public static Inspector inspector2 = new Inspector("Andres");
    public static Inspector inspector3 = new Inspector("Sebastian");






}
