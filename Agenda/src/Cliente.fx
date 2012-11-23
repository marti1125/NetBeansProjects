/**
 * @author Willy Aguirre
 */

public class Cliente{
    public var nombre:String;
    public var apellido:String;
    public var telefono:String;
    //crea una variable de tipo Direccion
    public var direccion:Direccion;

    public function printNombre(){
        println("Nombre Compleado: {nombre} {apellido}");
    }

    public function printTelefono(){
        println("Telefono: {telefono}");
    }

    public function printDireccion(){
        println("Calle: {direccion.calle}");
        println("Ciudad: {direccion.ciudad}");
        println("Estado: {direccion.estado}");
        println("Codigo Postal: {direccion.codigo}");
    }
}

