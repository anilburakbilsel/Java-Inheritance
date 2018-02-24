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

### Tools

 You can use any text editors for this project (I would recommend you to use an IDE). I am using IntelliJ which is a
 product of Jet Brains. You can use its community edition for almost all of your personal projects. It is a great tool
 to work on Java projects. Other than that, Visual Studio Code is also a very good text editor (it's my favorite text
 editor) which you can work in any languages.