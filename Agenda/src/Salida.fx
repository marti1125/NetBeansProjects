/**
 * @author Willy Aguirre
 */

var Cliente = Cliente{
    nombre: "Willy";
    apellido: "Aguirre";
    telefono: "2877803";
    direccion:Direccion{
        calle: "AV. Vallejos 3456";
        ciudad: "Villa El Salvador";
        estado: "Lima";
        codigo: "51";
    }
}
//imprimo los metodos
Cliente.printNombre();
Cliente.printTelefono();
Cliente.printDireccion();

