/**
 * @author Willy Aguirre
 */
//Tema Variables
//String, Number y Integer, Boolean, Duration, Void, Null, Function Type
//String
println("--------------------------------");
println("Ejemplo con String");
println("--------------------------------");
var s1 = 'hello';
var s2 = "hello";

//embed String
def name = 'Willy';
var s = "Hello {name}"; // s = "Hello Willy"

def respuesta = true;
var a = "La respuesta es: {if(respuesta) "SI" else "NO"}"; //La respues es SI

def uno = "Este Ejemplo";
def dos = "se une dos String";
def tres = "{uno} {dos}";

//imprimiento los Strings
println("{s1}");
println("{s2}");
println("{s}");
println("{a}");
println("{tres}");

//Number y Integer
println("--------------------------------");
println("Ejemplo con Number y Integer");
println("--------------------------------");

def n1 = 1.0; //el compilador infiere que es Number
def n2 = 1; //el compilador infiere que es Integer

//sin embargo tambien se puede declarar el tipo de varible
//Number: Byte, Short, Number, Integer, Long, Float, Double, y Character
def nn1:Number = 1.0;
def nn2:Integer = 1;

println("{n2}");
println("{nn1}");

//Boolean
println("--------------------------------");
println("Ejemplo con Boolean");
println("--------------------------------");

var isAslepp = true;

if(isAslepp){
    println("Despiertate!!!");
}

//Duration
println("--------------------------------");
println("Ejemplo con Duration");
println("--------------------------------");

5ms; //5 milisegundo
10s; //10 segundos
30m; //30 minutos
1h; //1 hora

//Void
println("--------------------------------");
println("Ejemplo con void");
println("--------------------------------");

function aca():Void{
    println("no retorna nada!!");
}

//equivalencia
function acas(){
    println("no retorna nada!!");
}

//Null
println("--------------------------------");
println("Ejemplo con Null");
println("--------------------------------");

function verificar(edad:String){
    if(edad == null){
        println("Argumento null");
    }else{
        println("El argumento tiene valor");
    }
}

//Function Type
println("--------------------------------");
println("Ejemplo con Function Type");
println("--------------------------------");

var myFunc : function(:Object,:Integer):String;
myFunc = function(obj : Object, k : Integer) { "Here is the Object: {obj}, and the Integer: {k}" }
println( myFunc(4s, 777) );
println( myFunc(null, 1234) );

