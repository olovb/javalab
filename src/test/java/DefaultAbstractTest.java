
// Inheriting from interfaces: the 'default-default' and 
// 'default-abstract' rules means an inheriting type sometimes
// has to reimplement or redeclare an inherited method.

/*----------------------------=o=------------------------------*/

// Interfaces all having some declaration of an override-
// equivalent method.

interface IHello1 {
    default String hello() { return "Hello from IHello1."; } 
}

interface IHello2 {
    default String hello() { return "Hello from IHello2."; } 
}

interface IHello3 {
    abstract String hello();
}

/*----------------------------=o=------------------------------*/

// Another override-equivalent declaration of the metod found
// in the above interfaces.

abstract class Hello1 {
    abstract String hello();   
}

/*----------------------------=o=------------------------------*/

// Interfaces inheriting multiple unrelated default methods or 
// a combination of abstract and default methods that are
// override equivalent must reimplement or redeclare the methods
// in question. The hello() method below may not be omitted.

interface IHello11 extends IHello1, IHello2 {
    default String hello() { return "Hello from IHello2."; } 
}

interface IHello12 extends IHello1, IHello2 {
    abstract String hello();
}

interface IHello21 extends IHello2, IHello3 {
    default String hello() { return "Hello from IHello2."; } 
}

interface IHello22 extends IHello2, IHello3 {
    abstract String hello();
}

/*----------------------------=o=------------------------------*/

// Classes inheriting multiple unrelated default methods or 
// a combination of abstract and default methods that are
// override equivalent must reimplement or redeclare the methods
// in question unless the class extends another class that
// declares as abstract or implements said methods.
// 
// The hello() method below may not be omitted unless inherited
// from a superclass.

abstract class Hello11 implements IHello1, IHello2 {
    abstract public String hello();
} 

abstract class Hello12 implements IHello1, IHello2 {
    public String hello() { return "Hello from Hello12."; }
}

abstract class Hello13 extends Hello1 
                       implements IHello1, IHello2 {}

abstract class Hello21 implements IHello2, IHello3 {
    abstract public String hello();
}

abstract class Hello22 implements IHello2, IHello3 {
    public String hello() { return "Hello from Hello22."; }
}

abstract class Hello23 extends Hello1 
                       implements IHello2, IHello3 {}

