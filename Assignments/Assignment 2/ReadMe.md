AP Assignment 2 (Section A) - Zoo Management System - Object-Oriented Programming (OOPs) Implementation

Name - Shobhit Raj (shobhit22482@iiitd.ac.in) <br>
Roll No. - 2022482

Assignment Description ->
This Java application represents a Zoo Management System that leverages OOP principles to model and manage the functionalities of a library.
The code is organized into classes that encapsulate distinct entities and functionalities, fostering a clear and maintainable structure.

Object-Oriented Principles Applied ->

1. Interfaces -
   In my code, The "Zoo" interface serves as a common interface for different components of the zoo, such as attractions, animals, deals, and
   discounts. By providing a shared set of data & methods, it enforces consistency in how these components are managed.

   Zoo Interface: I have declared it as interface to provide flexibility and extensibility - as the zoo management system evolves, we can add
   new classes that implement the "Zoo" interface to introduce new functionalities or components. The interface acts as a blueprint for extending
   the system without disrupting existing code.

2. Abstract Classes -
   Abstract classes allows us to define common functionality while leaving specific implementation details to derived classes.<br>
   In my code, I have implemented abstract classes :-

   Visitor Abstract Class: I have created an abstract class called "Visitors" to serve as a common base for different types of visitors in the zoo management system.
   This abstract class contains member variables and methods that are common to all types of visitors (e.g., name, age, balance, etc.).

   Animal Abstract Class: The Animal class is used as an abstract class to provide a blueprint for all animal-related entities in the Zoo Management System.
   As an abstract class, it cannot be instantiated directly but serves as a base class for more specific animal types such as mammals, amphibians, and reptiles.
   Other Abstract classes used are Discounts & Deals that gives the blueprint for the discounts and deals respectively.

3. Polymorphism -
   Polymorphism allows different objects to be treated as instances of a common superclass (or interface), enabling us to write more flexible and extensible
   code. Here's how polymorphism is demonstrated in my code :-

   Runtime Polymorphism (Dynamic Method Dispatch) / Method Overriding :
   I have created an object of a subclass and assign it to a reference variable of the superclass,<br>
   "Animal animal = new Mammal();" -> In this case, Animal is the superclass, and Mammal is a subclass that extends Animal. <br>The Mammal class overrides (provides its implementation of) methods
   defined in the Animal class. The overridden methods of the Mammal class will be called at runtime. For example, if the Animal class has a method makeNoise(), and Mammal overrides this method, calling
   animal.makeNoise() will execute the makeNoise() method of the Mammal class.
   Method Overriding is also demonstrated when using Object's class methods toString(Object o), Comparator's compare(Object o1, Object o2) method & several other methods in the code.

   Method Overloading :
   In my code, Method Overloading is demonstrated when multiple parametric constructors with different parameters are defined in classes like Deals & Discount.

4. Inheritance -
   The Zoo Interface serves as the superclass or base class, and it contains common attributes and methods that are shared among other classes. It
   facilitates the functionalities of subclasses like Admin & Visitor.
   Inheritance is also used in case of Abstract Class Animal & extending its implementation to specific type of animals, namely Mammal, Amphibian & Reptile while reusing common properties from the parent class.
   These parent classes serves as the foundation for different types of objects/subclasses.

5. Relationships Between Classes -
   The program demonstrates the composition of objects, such as visitors holding attraction tickets and objects like deals and discounts being used in various parts of the program.
   The Zoo Interface has an ArrayList of various Class' objects type like visitors, animals, attractions, deals, and discounts.

6. Object Class -
   The "Object" class provides fundamental methods like "toString," "equals," and "hashCode." In my code, I override the "toString" method to provide a
   custom string representation for objects of the classes, making it easier to display information about deals, discounts, animals, and attractions.
   The "equals" method in my code is used to check object equality which overrides the method in Object class & typecasts it accordingly. Eg. - It is used to compare
   visitor objects based on their email and password.
   I have also implemented Comparator Interface of the classes Attraction & Deals to compare based on specific attributes and sort the deals accordingly based on decreasing number of combined tickets.
   The "int compare (Object o1, Object o2)" method of Comparator Interface is overridden, typecast (at runtime through erasure) to appropriate Class type & then compared based on the attributes.

7. Encapsulation and Data Hiding -
   The code uses private instance variables at appropriate places and getter and setter methods to encapsulate data and hide it from direct access.

* The program follows all the good programming practices mentioned in the assignment document.

How to Use (User Guide to Execute) -><br>
(pom.xml file & Source Code has been attached in the zip file)<br>
Source Code (Main class & other classes) is present inside the src folder inside the main folder <br>
Pre-Requisites --> <br>
[IntelliJ IDEA](https://www.jetbrains.com/idea/) installed on your machine. (or any Java IDE) <br>
[Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) installed. <br>
Adjust the package line at the top of each Java file to match your IntelliJ directory structure. <br>
If you face any difficulty in running the files after following the above steps, create a new project using your own IntelliJ, create the same java files and copy my code in those files. <br>
Type these 3 commands to run Java file <br>
mvn clean <br>
mvn compile <br>
mvn package <br>
jar file is created -> to run the jar file, you use command: <br>
java -jar "\<path of jar file\>.jar" <br>
java -jar "\<path of jar file\>.jar" org.IIITD.Main <br>

Assumptions made for the assignment ->
1. Some attractions, animals, deals, discounts & visitors have been hard coded at the starting of the program to make it easier for testing.
   (They are not just typed & hardcoded in the list, they are created as Objects using their respective classes, so OOPS principles is incorporated) &
   Admin can further add, modify & remove each one of them using the manage() option. <br>
2. When both deal & discount are applicable when buying the tickets, they both are combined & applied on the final cost
   i.e. Total Discount % = (Deal % + Discount Code %)<br>
3. The Discount Code MINOR10 is replaced by STUDENT10 (Just the category name has changed to Student) - the criteria (age<18) & functionality is same.<br>
4. You have to enter "None" if you don't want to apply any discount code.<br>
5. Visitors are distinguished by their unique email & password. Other details can be same for d/f visitors.<br>
6. The most popular attraction shows both the "Most visited Attraction" & "Attraction with most tickets bought" to avoid confusion.
   (When all the attractions have same no. of visits, it displays the first attraction in the list)<br>
7. If the animal is already added in the zoo & the admin adds it again using addAnimal(), it's count is increased.<br>
8. 6 animals (2 of each type) is added (hard coded) in the beginning, the admin must ensure that there are atleast 2 animals of each type in
   the zoo (as mentioned in the assignment document) so they can't remove animal of specific type when there are only 2 left, they can add more animals of that type & then remove easily.<br>
9. No of Visitors (Stats) displays both "No of visitor registered" and "No of visitors who have actually visited any animal/attraction". Both the data are showed to avoid the confusion what is meant by the term "Visitor"<br>
10. 2 categories of Discount (Student & Senior) mentioned in the assignment are included in the program, in addition, the admin can add new discounts that are applicable to all visitors like FESTIVAL30 (30% off on Category Festival), etc.<br>
11. Note that valid input should be provided like when entering names of the attractions, animals, Discount Codes, Discount percentage (between 0-100) etc.
    (All the inputs are CASE SENSITIVE, so enter accordingly).

Upon launching the application, you will see the main menu with the following options:<br>
Enter as an admin (1)<br>
Enter as a visitor (2)<br>
View Special Deals (3) -> View the existing special deals and their details.<br>
Exit (4)<br>
Select the option & proceed :-

To Log in as Admin<br>
Username: admin<br>
Password: admin123<br>

Admin Mode - Admin Functionalities -><br>
-Manage Attractions (Option 1): View attractions, Add new attractions with descriptions and ticket prices, modify (edit) their details or remove.<br>
-Manage Animals (Option 2): View animals, Add new animals with details like species, description, and the sound they make, modify their info or remove any animal.<br>
-Schedule Attraction (Option 3): Specify the opening status of each attraction.<br>
-Manage Discounts (Option 4): View discounts, Create discount categories (e.g., Student, Senior) with a discount percentage and a unique discount code, modify or remove any discount.<br>
-Manage Special Deals (Option 5): View deals, Define special deals that offer discounts based on the number of tickets purchased together, modify or remove any deal.<br>
-View Visitor Stats (Option 6): View the number of registered visitors and their details, Most popular attraction & the revenue of the zoo.<br>
-View Feedback (Option 7): View feedback provided by visitors.<br>
-Exit Admin mode (Option 8): Choose option 8 to return to the main menu.<br>

Visitors can perform the following actions:<br>
Register - Provide personal information to create a visitor account.
(Verification is done such that the provided email and password are unique)
Login - Log in with a registered email and password.<br>
(Some visitor have been registered & hard coded to make it easier for testing) - You can register more visitors using "Register" option<br>
Visitor 1 (Student category) - Email: ta1@iiitd ; Password: ta1<br>
Visitor 2 (Senior category) - Email: ta2@iiitd ; Password: ta2<br>
Visitor 3 (No category) - Email: ta3@iiitd ; Password: ta3<br>

Visitor Mode - Visitor Functionalities -><br>
-Explore the Zoo (Option 1): Choose between viewing attractions and animals. Get details about attractions and animals. Choose specific attractions/animal to learn more about.<br>
-Buy Membership (Option 2): Purchase basic or premium memberships. Apply discount codes for further savings (if available & eligible).<br>
-Buy Tickets (Option 3): Purchase tickets for attractions (For Basic Members). Apply discount codes and special deals (applied automatically on the basis of number of tickets bought) for savings.<br>
(Both the buy options check's visitor's balance before purchasing)<br>
-View Discounts (Option 4): View the available discount categories and their associated codes and discount percentages.<br>
-View Special Deals (Option 5): View the existing special deals and their details.<br>
-Visit Animals (Option 6): Interact with animals. Choose to feed an animal or read more about it.<br>
-Visit Attractions (Option 7): Explore attractions, keeping in mind membership requirements and ticket purchases. (if the attraction is "OPEN")<br>
-Leave Feedback (Option 8): Provide feedback about your experience.<br>
-Recharge Balance (Option 9): Add funds to your visitor account for purchasing memberships and tickets.<br>
-Log Out (Option 10): Log out from your visitor account. Returns to the main menu.<br>

Exiting the Application: To exit the application, choose option 4 from the main menu<br>

->Follow the steps outlined above to interact with the system effectively.<br>
->Please note that the provided code includes some initial data, such as attractions, animals, discounts, and deals, hard-coded for testing and demonstration purposes.<br>
You can modify this data as required for your specific use case.<br>

Conclusion ->
This Zoo Management System demonstrates the effective use of OOP principles, including interfaces, abstract classes, polymorphism, inheritance, object class & encapsulation to create
a structured and maintainable codebase. It separates concerns into distinct classes, each responsible for specific functionalities, resulting in a well-organized and easy-to-maintain system.
