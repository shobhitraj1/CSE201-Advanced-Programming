AP Assignment 1 (Section A) - Library Management System - Object-Oriented Programming (OOP) Implementation

Name - Shobhit Raj (shobhit22482@iiitd.ac.in)<br>
Roll No. - 2022482

Assignment Description ->
This Java application represents a Library Management System that leverages OOP principles to model and manage the functionalities of a library.<br>
The code is organized into classes that encapsulate distinct entities and functionalities, fostering a clear and maintainable structure.

Object-Oriented Principles Applied ->

1. Encapsulation -
In my code, encapsulation is effectively utilized to bundle data (attributes) and the methods (functions) that operate on that data within classes.<br>
Here's how encapsulation is applied:

Member Class: Represents library members and encapsulates member-specific data like name, age, phone number, and member ID. It also contains information
about books issued by the member, fines, and methods for actions such as calculating fines.

Book Class: Represents books available in the library. It encapsulates book-specific data, including name, author, book ID, and availability status.
Methods in this class handle book-related actions like issuing and returning books.

Librarian Class: Represents librarians who can perform administrative actions. It encapsulates methods for adding/removing members and books, as well
as displaying information about members and books.

Library Class: Acts as a container class for managing lists of members and books. It includes methods for displaying member and book information and
managing overall library functionality.

2. Inheritance -
The Library class serves as the superclass or base class, and it contains common attributes and methods that are shared among other classes. It
encapsulates functionality that applies to both librarians and members.

Relationships Between Classes -
Objects of the Member class are associated with objects of the Book class when members borrow books. This is achieved through attributes like b1 and
b2 in the Member class, which reference book objects.

Private attributes have been used at appropriate places like details of Members & Books to prevent 
misusing/changing information like unique IDs.

How to Use (User Guide to Execute) -><br>
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

Upon launching the application, you will see the main menu with the following options:<br>
Enter as a librarian (1)<br>
Enter as a member (2)<br>
Exit (3)<br>
Select the option & proceed :-<br>

Librarian Mode - Librarian Functions<br>
-Register a Member (Option 1):<br>
Choose option 1 to register a new library member.<br>
Enter the member's details, including name, age, and phone number (valid input should be provided).<br>
A unique Member ID will be assigned to the member.<br>
-Remove a Member (Option 2):<br>
Choose option 2 to remove a registered member.<br>
Enter the Member ID of the member to be removed.<br>
Members with borrowed books or fines cannot be removed (edge case handled).<br>
-Add a Book (Option 3):<br>
Choose option 3 to add a new book to the library.<br>
Enter the book's details, including name, author, and the number of copies to add (valid input should be provided).<br>
-Remove a Book (Option 4):<br>
Choose option 4 to remove a book from the library.<br>
Enter the Book ID of the book to be removed.<br>
Books that are currently borrowed cannot be removed.<br>
-View Member and Book Information (Options 5 and 6):<br>
Choose options 5 or 6 to view information about registered members (along with their books & fine at that time) and available books, respectively. <br>
-Exit Librarian Mode (Option 7):<br>
Choose option 7 to return to the main menu.<br>

Member Mode - Member Functions<br>
-List Available Books (Option 1):<br>
Choose option 1 to view a list of available books in the library.<br>
-List My Books (Option 2):<br>
Choose option 2 to view the books you have borrowed, if any.<br>
-Issue a Book (Option 3):<br>
Choose option 3 to borrow a book.<br>
Follow the prompts to enter the Book ID of the book you want to borrow.<br>
-Return a Book (Option 4):<br>
Choose option 4 to return a book you have borrowed.<br>
Enter the Book ID of the book you wish to return.<br>
-Pay Fine (Option 5):<br>
Choose option 5 to pay any fines you may have incurred.<br>
Fine is calculated if book is not returned within 10 days.<br>
System.currentTimeMillis() is used to calculate the period for which the book was being hold & 4 seconds is taken as 1 day in the program.<br>
You can only pay the total fine after you have returned the book.<br>

-Exit Member Mode (Option 6):<br>
Choose option 6 to return to the main menu.<br>

Exiting the Application<br>
To exit the application, choose option 3 from the main menu<br>

->Follow the steps outlined above to interact with the system effectively.

Conclusion ->
This Library Management System demonstrates the effective use of OOP principles, including encapsulation, to create a structured and maintainable
codebase. It separates concerns into distinct classes, each responsible for specific functionalities, resulting in a well-organized and easy-to-maintain
system.
