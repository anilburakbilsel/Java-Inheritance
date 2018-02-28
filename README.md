## Inheritance in Java

This project is going to be an example to show you how to use Inheritance in Java (actually it is same for almost all
the Object Oriented Programming Languages).


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
If no constructor is defined in a class, Java compiler automatically create a no-argument (no-arg) constructor, that simply issues a super() call, as follows:
```Java
// If no constructor is defined in a class, compiler inserts this no-arg constructor
public ClassName () {
   super();   // call the superclass' no-arg constructor
}
```
Take note that:

-The default no-arg constructor will not be automatically generated, if one (or more) constructor was defined. In other words, you need to define no-arg constructor explicitly if other constructors were defined.

-If the immediate superclass does not have the default constructor (it defines some constructors but does not define a no-arg constructor), you will get a compilation error in doing a super() call. Note that Java compiler inserts a super() as the first statement in a constructor if there is no super(args).

### Important Notes:

Java does not support multiple inheritance. All the classes can have only one super class. 



### Tools

 You can use any text editors for this project (I would recommend you to use an IDE). I am using IntelliJ which is a
 product of Jet Brains. You can use its community edition for almost all of your personal projects. It is a great tool
 to work on Java projects. Other than that, Visual Studio Code is also a very good text editor (it's my favorite text
 editor) which you can work in any languages.