AP Assignment 1 (Section A) - Library Management System - Object-Oriented Programming (OOP) Implementation

Name - Shobhit Raj (shobhit22482@iiitd.ac.in)
Roll No. - 2022482

Assignment Description ->
This Java application represents a Library Management System that leverages OOP principles to model and manage the functionalities of a library.
The code is organized into classes that encapsulate distinct entities and functionalities, fostering a clear and maintainable structure.

Object-Oriented Principles Applied ->

1. Encapsulation -
In my code, encapsulation is effectively utilized to bundle data (attributes) and the methods (functions) that operate on that data within classes.
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

How to Use (User Guide to Execute) ->

(pom.xml file & Source Code has been attached in the zip file)

Source Code (Main class & other classes) is present inside the src folder inside the main folder <br>
Type these 3 commands to run Java file <br>
mvn clean <br>
mvn compile <br>
mvn package <br>
jar file is created -> to run the jar file, you use command: <br>
java -jar "<path of jar file>.jar" <br>

Upon launching the application, you will see the main menu with the following options:
Enter as a librarian (1)
Enter as a member (2)
Exit (3)
Select the option & proceed :-

Librarian Mode - Librarian Functions
-Register a Member (Option 1):
Choose option 1 to register a new library member.
Enter the member's details, including name, age, and phone number (valid input should be provided).
A unique Member ID will be assigned to the member.
-Remove a Member (Option 2):
Choose option 2 to remove a registered member.
Enter the Member ID of the member to be removed.
Members with borrowed books or fines cannot be removed (edge case handled).
-Add a Book (Option 3):
Choose option 3 to add a new book to the library.
Enter the book's details, including name, author, and the number of copies to add (valid input should be provided).
-Remove a Book (Option 4):
Choose option 4 to remove a book from the library.
Enter the Book ID of the book to be removed.
Books that are currently borrowed cannot be removed.
-View Member and Book Information (Options 5 and 6):
Choose options 5 or 6 to view information about registered members (along with their books & fine at that time) and available books, respectively.
-Exit Librarian Mode (Option 7):
Choose option 7 to return to the main menu.

Member Mode - Member Functions
-List Available Books (Option 1):
Choose option 1 to view a list of available books in the library.
-List My Books (Option 2):
Choose option 2 to view the books you have borrowed, if any.
-Issue a Book (Option 3):
Choose option 3 to borrow a book.
Follow the prompts to enter the Book ID of the book you want to borrow.
-Return a Book (Option 4):
Choose option 4 to return a book you have borrowed.
Enter the Book ID of the book you wish to return.
-Pay Fine (Option 5):
Choose option 5 to pay any fines you may have incurred.
Fine is calculated if book is not returned within 10 days.
System.currentTimeMillis() is used to calculate the period for which the book was being hold & 4 seconds is taken as 1 day in the program.
You can only pay the total fine after you have returned the book.

-Exit Member Mode (Option 6):
Choose option 6 to return to the main menu.

Exiting the Application
To exit the application, choose option 3 from the main menu

->Follow the steps outlined above to interact with the system effectively.

Conclusion ->
This Library Management System demonstrates the effective use of OOP principles, including encapsulation, to create a structured and maintainable
codebase. It separates concerns into distinct classes, each responsible for specific functionalities, resulting in a well-organized and easy-to-maintain
system.
