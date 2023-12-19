package org.IIITD;

import java.util.Scanner;

class Librarian extends Library {
    static void addMember(String name, int age, long phone_no) {
        for (Member m : members) {
            if (m.getName().equals(name) && m.getAge() == age && m.getPhone_no() == phone_no) {
                System.out.println("Member already registered");
                return;
            }
        }
        member_list.add(name);
        int mem_id = ++no_of_members;
        Member m = new Member(name, age, phone_no, mem_id);
        members.add(m);
        System.out.println("Member Successfully Registered with Member ID: " + mem_id);
    }

    static void removeMember(int mem_id) {
        for (Member m : members) {
            if (m.getMem_id() == mem_id) {
                if (m.nobookissued != 0 || m.fine != 0) {
                    System.out.println("Cannot remove a member who has borrowed book or has fine due");
                } else {
                    member_list.remove(m.getName());
                    members.remove(m);
                    System.out.println("Member Successfully Removed");
                }
                return;
            }
        }
        System.out.println("No Member registered with ID: " + mem_id);
    }

    static void addBook(String bookname, String bookauthor, int bookcopies) {
        for (int i = 0; i < bookcopies; i++) {
            book_list.add(bookname);
            int book_id = ++no_of_books;
            Book b = new Book(bookname, bookauthor, bookcopies, book_id);
            books.add(b);
        }
    }

    static void removeBook(int book_id) {
        for (Book b : books) {
            if (b.getBook_id() == book_id) {
                if (b.isBorrowed) {
                    System.out.println("Cannot remove a book that is borrowed.");
                } else {
                    book_list.remove(b.getName());
                    books.remove(b);
                    System.out.println("Book Successfully Removed");
                }
                return;
            }
        }
        System.out.println("No Book available with ID: " + book_id);
    }

    static void displayLInput() {
        System.out.println("------------------------------");
        System.out.println("You have entered as Librarian. Select what you want to do:-");
        System.out.println("1. Register a member");
        System.out.println("2. Remove a member");
        System.out.println("3. Add a book");
        System.out.println("4. Remove a book");
        System.out.println("5. View all members along with their books and fines to be paid");
        System.out.println("6. View all books");
        System.out.println("7. Back");
        System.out.print("Enter the option (1-7): ");
        Scanner s = new Scanner(System.in);
        int LInput = s.nextInt();
        switch (LInput) {
            case 1 -> {
                System.out.println("Enter the member's details:-");
                System.out.print("Enter Name: ");
                s.nextLine();
                String memname = s.nextLine();
                System.out.print("Enter Age: ");
                int memage = s.nextInt();
                System.out.print("Enter Phone number: ");
                long memphone_no = s.nextLong();
                addMember(memname, memage, memphone_no);
                Librarian.displayLInput();
            }
            case 2 -> {
                System.out.print("Enter Member ID of the member you want to remove: ");
                int mem_id = s.nextInt();
                removeMember(mem_id);
                Librarian.displayLInput();
            }
            case 3 -> {
                System.out.println("Enter the book's details:-");
                System.out.print("Enter Name: ");
                s.nextLine();
                String bookname = s.nextLine();
                System.out.print("Enter Author: ");
                String bookauthor = s.nextLine();
                System.out.print("Enter No. of copies: ");
                int bookcopies = s.nextInt();
                addBook(bookname, bookauthor, bookcopies);
                System.out.println("Book Successfully Added");
                Librarian.displayLInput();
            }
            case 4 -> {
                System.out.print("Enter book ID of the book you want to remove: ");
                int book_id = s.nextInt();
                removeBook(book_id);
                Librarian.displayLInput();
            }
            case 5 -> {
                Library.displayMinfo();
                Librarian.displayLInput();
            }
            case 6 -> {
                Library.displayBinfo();
                Librarian.displayLInput();
            }
            case 7 -> Main.takeInput();
            default -> {
                System.out.println("Choose and enter valid option from 1-7");
                Librarian.displayLInput();
            }
        }
        s.close();
    }
}
