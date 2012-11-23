/**
 * @author Willy Aguirre
 */

//diferencias entre var y def
//def se le asigna un valor al inicio
//mientras var se la asigna un valor dentro de un metodo

//ejemplo pasando argumentos

//def n1 = 100;
//def n2 = 2;
var resultado;
var total;

suma(200,2);
resta(100,2);
multiplicacion(100,2);
divicion(100,2);
total = suma(200,2) + suma(200,2);

//metodo que retorno un Integer
//retorna :Integer
function suma(n1:Integer, n2:Integer):Integer{
    resultado =  n1 + n2;
    println("{n1} + {n2} = {resultado}");
    return resultado;
}

function resta(n1:Integer, n2:Integer):Integer{
    resultado =  n1 - n2;
    println("{n1} - {n2} = {resultado}");
    return resultado;
}

function multiplicacion(n1:Integer, n2:Integer):Integer{
    resultado =  n1 * n2;
    println("{n1} + {n2} = {resultado}");
    return resultado;
}

function divicion(n1:Integer, n2:Integer):Integer{
    resultado =  n1 / n2;
    println("{n1} / {n2} = {resultado}");
    return resultado;
}


