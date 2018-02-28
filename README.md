## Inheritance in Java

This project is going to be an example to show you how to use Inheritance in Java (actually it is same for almost all
the Object Oriented Programming Languages).

Use abstract superclass if there is a clear class hierarchy. Abstract class can contain partial implementation (such as
instance variables and methods). Interface cannot contain any implementation, but merely defines the behaviors.


## What is Inheritance ?

In OOP, we often organize classes in hierarchy to avoid duplication and reduce redundancy. The classes in the lower
hierarchy inherit all the variables (static attributes) and methods (dynamic behaviors) from the higher hierarchies. A
class in the lower hierarchy is called a subclass (or derived, child, extended class). A class in the upper hierarchy is
called a superclass (or base, parent class). By pulling out all the common variables and methods into the superclasses,
and leave the specialized variables and methods in the subclasses, redundancy can be greatly reduced or eliminated as
these common variables and methods do not need to be repeated in all the subclasses.

A subclass inherits all the variables and methods from its superclasses, including its immediate parent as well as all
the ancestors. It is important to note that a subclass is not a "subset" of a superclass. In contrast, subclass is a
"superset" of a superclass. It is because a subclass inherits all the variables and methods of the superclass; in
addition, it extends the superclass by providing more variables and methods.

In Java, you define a subclass using the keyword "extends", e.g.,
```Java
class Goalkeeper extends SoccerPlayer {......}
class MyApplet extends java.applet.Applet {.....}
class Cylinder extends Circle {......}
```

Reusability is one of the most important properties of OOP.

## Method Overriding & Variable Hiding

A subclass inherits all the member variables and methods from its superclasses (the immediate parent and all its ancestors).
It can use the inherited methods and variables as they are. It may also override an inherited method by providing its own
version, or hide an inherited variable by defining a variable of the same name.



### @Override Annotaion

The "@Override" is known as annotation (introduced in JDK 1.5), which asks compiler to check whether there is such a method
in the superclass to be overridden. This helps greatly if you misspell the name of the method to be overridden. For example,
suppose that you wish to override method toString() in a subclass. If @Override is not used and toString() is misspelled as
TOString(), it will be treated as a new method in the subclass, instead of overriding the superclass. If @Override is used,
the compiler will signal an error. @Override annotation is optional, but certainly nice to have. Annotations are not programming
constructs. They have no effect on the program output. It is only used by the compiler, discarded after compilation, and not
used by the runtime.


### super Keyword
Recall that inside a class definition, you can use the keyword this to refer to this instance. Similarly, the keyword super
refers to the superclass, which could be the immediate parent or its ancestor. The keyword super allows the subclass to
access superclass' methods and variables within the subclass' definition. For example, super() and super(argumentList)
can be used invoke the superclass’ constructor. If the subclass overrides a method inherited from its superclass, says
getArea(), you can use super.getArea() to invoke the superclass' version within the subclass definition. Similarly, if your
subclass hides one of the superclass' variable, you can use super.variableName to refer to the hidden variable within the
subclass definition.


### More on Constructors
Recall that the subclass inherits all the variables and methods from its superclasses. Nonetheless, the subclass does not
inherit the constructors of its superclasses. Each class in Java defines its own constructors. In the body of a constructor,
you can use super(args) to invoke a constructor of its immediate superclass. Note that super(args), if it is used, must
be the first statement in the subclass' constructor. If it is not used in the constructor, Java compiler automatically
insert a super() statement to invoke the no-arg constructor of its immediate superclass. This follows the fact that the
parent must be born before the child can be born. You need to properly construct the superclasses before you can construct
the subclass.

All in all, we have to remember that each class in Java should define its own constructor(s).


### Default no-arg Constructor
If no constructor is defined in a class, Java compiler automatically create a no-argument (no-arg) constructor, that simply
issues a super() call, as follows:
```Java
// If no constructor is defined in a class, compiler inserts this no-arg constructor
public ClassName () {
   super();   // call the superclass' no-arg constructor
}
```
Take note that:

-The default no-arg constructor will not be automatically generated, if one (or more) constructor was defined. In other words,
you need to define no-arg constructor explicitly if other constructors were defined.

-If the immediate superclass does not have the default constructor (it defines some constructors but does not define a no-arg
constructor), you will get a compilation error in doing a super() call. Note that Java compiler inserts a super() as the
first statement in a constructor if there is no super(args).



Java does not support multiple inheritance (C++ does). Multiple inheritance permits a subclass to have more than one
direct superclasses. This has a serious drawback if the superclasses have conflicting implementation for the same method.
In Java, each subclass can have one and only one direct superclass, i.e., single inheritance. On the other hand, a
superclass can have many subclasses.

### Common Root Class


Java adopts a so-called common-root approach. All Java classes are derived from a common root class called java.lang.Object.
This Object class defines and implements the common behaviors that are required of all the Java objects running under the JRE.
These common behaviors enable the implementation of features such as multi-threading and garbage collector.


### Important Notes About Inheritance and Composition:

Java does not support multiple inheritance. All the classes can have only one super class.

Use composition if possible, before considering inheritance. Use inheritance only if there is a clear hierarchical
relationship between classes.

Inheritance between two classes, where one class extends another class establishes "IS A" relationship. Composition on
the other end contains an instance of another class in your class establishes "Has A" relationship


### Polymorphism

The word "polymorphism" means "many forms". It comes from Greek word "poly" (means many) and "morphos" (means form).
For examples, in chemistry, carbon exhibits polymorphism because it can be found in more than one form: graphite and diamond.
But, each of the form has it own distinct properties (and price).

Substitutability:

A subclass possesses all the attributes and operations of its superclass (because a subclass inherited all attributes
and operations from its superclass). This means that a subclass object can do whatever its superclass can do. As a result,
we can substitute a subclass instance when a superclass instance is expected, and everything shall work fine. This is called
substitutability.

Here is an important point (Circle is the superclass of Cylinder):
```Java
Circle c1 = new Cylinder(1.1, 2.2);    // here, c1 is an instance of Cylinder, however it's also a reference to Circle
```
in the above code c1 is an instance of type Cylinder. However, it references to Circle. We can invoke all the methods defined
in the Circle class for the reference c1, (which is actually holding a Cylinder object). This is because a subclass instance
possesses all the properties of its superclass. However, we CANNOT invoke methods defined in the Cylinder class for the
reference c1!!!!! This is because c1 is a reference to the Circle class, which does not know about methods defined in the subclass Cylinder.

c1 is a reference to the Circle class, but holds an object of its subclass Cylinder. The reference c1, however, retains
its internal identity. In our example, the subclass Cylinder overrides methods getArea() and toString(). c1.getArea() or c1.toString()
invokes the overridden version defined in the subclass Cylinder, instead of the version defined in Circle. This is because
c1 is in fact holding a Cylinder object internally.


### Summary

- A subclass instance can be assigned (substituted) to a superclass' reference.

- Once substituted, we can invoke methods defined in the superclass; we cannot invoke methods defined in the subclass.

- However, if the subclass overrides inherited methods from the superclass, the subclass (overridden) versions will be invoked!!!


### Upcasting and Downcasting

##### Upcasting a Subclass Instance to a Superclass Reference:

Substituting a subclass instance for its superclass is called "upcasting". This is because, in a UML class diagram,
subclass is often drawn below its superclass. Upcasting is always safe because a subclass instance possesses all the
properties of its superclass and can do whatever its superclass can do. The compiler checks for valid upcasting and
issues error "incompatible types" otherwise. For example,
```Java
Circle c1 = new Cylinder(1.1, 2.2);  // Compiler checks to ensure that R-value is a subclass of L-value.
Circle c2 = new String();            // Compilation error: incompatible types
```

##### Downcasting a Substituted Reference to Its Original Class

You can revert a substituted instance back to a subclass reference. This is called "downcasting". For example,
```Java
Circle c1 = new Cylinder(1.1, 2.2);  // upcast is safe
Cylinder cy1 = (Cylinder) c1;        // downcast needs the casting operator
```
Downcasting requires explicit type casting operator in the form of prefix operator (new-type). Downcasting is not always
safe, and throws a runtime ClassCastException if the instance to be downcasted does not belong to the correct subclass.
A subclass object can be substituted for its superclass, but the reverse is not true.


there is an operator called instanceof.
```Java
Circle c1 = new Circle();
System.out.println(c1 instanceof Circle);  // true
```
you can use that operator when needed. it is similar to JavaScript typeof operator.

An instance of subclass is also an instance of its superclass. For example,
```Java
Circle c1 = new Circle(1.1);
Cylinder cy1 = new Cylinder(2.2, 3.3);
System.out.println(c1 instanceof Circle);    // true
System.out.println(c1 instanceof Cylinder);  // false
System.out.println(cy1 instanceof Cylinder); // true
System.out.println(cy1 instanceof Circle);   // true

Circle c2 = new Cylinder(4.4, 5.5);
System.out.println(c2 instanceof Circle);    // true
System.out.println(c2 instanceof Cylinder);  // true
```


### Summary of Polymorphism

- A subclass instance processes all the attributes operations of its superclass. When a superclass instance is expected,
it can be substituted by a subclass instance. In other words, a reference to a class may hold an instance of that class
or an instance of one of its subclasses - it is called substitutability.

- If a subclass instance is assign to a superclass reference, you can invoke the methods defined in the superclass only.
You cannot invoke methods defined in the subclass.

- However, the substituted instance retains its own identity in terms of overridden methods and hiding variables. If the
subclass overrides methods in the superclass, the subclass's version will be executed, instead of the superclass's version.

### Abstract Classes

```Java
abstract public class Shape {
   ......
   ......
   abstract public double getArea();
   abstract public double getPerimeter();
   abstract public void draw();
}
```
These abstract methods cannot be invoked because they have no implementation.

A class containing one or more abstract methods is called an abstract class. An abstract class must be declared with a
class-modifier abstract. An abstract class CANNOT be instantiated, as its definition is not complete.


An abstract class is incomplete in its definition, since the implementation of its abstract methods is missing. Therefore,
an abstract class cannot be instantiated. In other words, you cannot create instances from an abstract class (otherwise,
you will have an incomplete instance with missing method's body).

To use an abstract class, you have to derive a subclass from the abstract class. In the derived subclass, you have to
override the abstract methods and provide implementation to all the abstract methods. The subclass derived is now complete,
and can be instantiated. (If a subclass does not provide implementation to all the abstract methods of the superclass,
the subclass remains abstract.)


In summary, an abstract class provides a template for further development. The purpose of an abstract class is to provide
a common interface (or protocol, or contract, or understanding, or naming convention) to all its subclasses. For example,
in the abstract class Shape, you can define abstract methods such as getArea() and draw(). No implementation is possible
because the actual shape is not known. However, by specifying the signature of the abstract methods, all the subclasses
are forced to use these methods' signature. The subclasses could provide the proper implementations.

Coupled with polymorphism, you can upcast subclass instances to Shape, and program at the Shape level, i,e., program at
the interface. The separation of interface and implementation enables better software design, and ease in expansion. For
example, Shape defines a method called getArea(), which all the subclasses must provide the correct implementation. You
can ask for a getArea() from any subclasses of Shape, the correct area will be computed. Furthermore, you application
can be extended easily to accommodate new shapes (such as Circle or Square) by deriving more subclasses.

Rule of Thumb: Program at the interface, not at the implementation. (That is, make references at the superclass;
substitute with subclass instances; and invoke methods defined in the superclass only.)

Notes:

An abstract method cannot be declared final, as final method cannot be overridden. An abstract method, on the other hand,
must be overridden in a descendant before it can be used.

An abstract method cannot be private (which generates a compilation error). This is because private method are not visible
to the subclass and thu
s cannot be overridden.

A Java interface is a 100% abstract superclass which define a set of methods its subclasses must support. An interface
contains only public abstract methods (methods with signature and no implementation) and possibly constants (public static
final variables). You have to use the keyword "interface" to define an interface (instead of keyword "class" for normal
classes). The keyword public and abstract are not needed for its abstract methods as they are mandatory.

An interface is a contract for what the classes can do. It, however, does not specify how the classes should do it!!!


An interface is a contract (or a protocol, or a common understanding) of what the classes can do. When a class implements
a certain interface, it promises to provide implementation to all the abstract methods declared in the interface. Interface
defines a set of common behaviors. The classes implement the interface agree to these behaviors and provide their own
implementation to the behaviors. This allows you to program at the interface, instead of the actual implementation. One
of the main usage of interface is provide a communication contract between two objects. If you know a class implements
an interface, then you know that class contains concrete implementations of the methods declared in that interface, and
you are guaranteed to be able to invoke these methods safely. In other words, two objects can communicate based on the
contract defined in the interface, instead of their specific implementation.

Interface can hold constants but is not recommended. If a subclass implements two interfaces with conflicting constants, the compiler will flag out a compilation erro


### Encapsulation

Encapsulation refers to keeping the data and method inside a class such users do not access the data directly but via
the public  methods. Tight encapsulation is desired, which can be achieved by declaring all the variable private, and
providing public getter and setter to the variables. The benefit is you have complete control on how the data is to be
read (e.g., in how format) and how to the data is to be changed (e.g., validation).

Information Hiding: Another key benefit of tight encapsulation is information hiding, which means that the users are
not aware (and do not need to be aware) of how the data is stored internally.



### Tools

You can use any text editors for this project (I would recommend you to use an IDE). I am using IntelliJ which is a
product of Jet Brains. You can use its community edition for almost all of your personal projects. It is a great tool
to work on Java projects. Other than that, Visual Studio Code is also a very good text editor (it's my favorite text
editor) which you can work in any languages.

### Further Information:

[a link](https://www.ntu.edu.sg/home/ehchua/programming/java/J3b_OOPInheritancePolymorphism.html)