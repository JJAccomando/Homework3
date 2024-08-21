1. What is an interface?

An interface can be described as a contract that specifies a class’s behavior through abstract methods and fields. An interface can define specific methods and fields that must be implemented by a class. 
Any classes that implement a specific interface will have standardized behavior from that interface. Classes can only extend one other class, but classes can implement multiple interfaces.

2. What is static?

In Java, static is a non-access modifier used for methods and attributes. When a method or attribute is static, it belongs to the class rather than an instance of the class. 
This means it can be accessed without the need for creating an object, and it is known at compile time.

3. Can we call non-static methods from static? Vice versa?

Since static methods are accessed without the need for creating an instance of a class, non-static methods are able to access static methods. 
However, because non-static methods require the creation of an object, a static method is unable to access non-static methods since they may have not been initialized.

4. 6 differences between an abstract class and an interface?

An abstract class can contain non-final variables whereas an interface can only have final variables. Members of an interface are public by default, but an abstract class can have other access modifiers such as private. 
A subclass can only extend one abstract class, but they can implement multiple interfaces. An abstract class can also have constructors that are overridden by subclasses, whereas interfaces do not. 
Abstract classes can have methods with implementation that a subclass can choose to override or not, but interfaces are absolute abstraction. Interfaces answer the “what” but not the “How” and abstract classes can answer both.

5. What is polymorphism?

Polymorphism is the ability for objects to take on many forms. What this means is that objects can respond to the same method call in different ways. 
An example of this would be method overloading and method overriding. Method overloading involves having methods of the same name, but with different types and numbers of parameters. 
Method overriding involves having a method of the same name and parameters, but different behavior.

6. What is final?

Final is a non-access modifier that means a value cannot be changed once it is assigned the first time. This is useful in code to prevent polymorphism, and to create constants that can be used throughout the code as a standardized value, method, or class. 

7. What is functional programming?

Functional programming is a programming style that is based on the idea of pure functions with strict control flow, directly mapping input to output, and no side effects. 
It gives programers  the ability to make method implementations into objects that can be saved into variables and passed into other methods as parameters. 

8. What are the differences between OOP and functional programming?

With OOP, many methods require the use and creation of local temporary variables in order to complete a function, or several commands concatenated together to form the whole method implementation. 
These intermediary steps reserve memory in a computer as “side effects.” Functional programming is instead the composition of these intermediary steps into one function, simplifying the code readability, while also eliminating side effects. 
