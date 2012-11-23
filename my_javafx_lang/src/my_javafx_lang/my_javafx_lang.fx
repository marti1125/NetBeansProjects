package my_javafx_lang;

/**
 * @author willy Aguirre
 */
class Address {

    var city: String;
    var street: String;
    var streetNumber: Integer;
}

class Person {

    var name: String;
    var age: Integer;
    var address: Address;
}

var juan:Person = Person{
    name: "Juan";
    age: 20;
    address:Address{
        city: "Lima";
        street: "Av. San Juan";
        streetNumber: 466;
    }
}

var martin:Person = Person{
    name: "Martin";
    age: 21;
    address:Address{
        city: "Lima";
        street: "Av. El Sol";
        streetNumber: 648;
    }
}

var oneperson:String[];
oneperson[0] = "Juan,";
oneperson[1] = " 20,";
oneperson[2] = " Lima,";
oneperson[3] = " Av. San Juan,";
oneperson[4] = " 466";
var twopersons:String[];
twopersons[0] = "Martin,";
twopersons[1] = " 21,";
twopersons[2] = " Lima,";
twopersons[3] = " Av. El Sol,";
twopersons[4] = " 648";

people("first Person",oneperson);
people("Second Person",twopersons);

function people(description, people_sequence: String[]){
    println("---- {description}");
    for (p in people_sequence) {
        print("{p} ")
    }
    println("");
}

var seoul:String[];
seoul[0] = "Jhon,";
seoul[1] = " 22,";
seoul[2] = " Seoul,";
seoul[3] = " Gwanhun-dong,";
seoul[4] = " 196-5";

people_in_Seoul("People in Seoul",seoul);

function people_in_Seoul(description, people_in_Seoul_sequence: String[]){
    println("---- {description}");
    for (s in people_in_Seoul_sequence) {
        print("{s} ")
    }
    println("");
}



