package org.IIITD;

import java.util.ArrayList;

class Library{
    static ArrayList<String> member_list = new ArrayList<>();
    static ArrayList<String> book_list = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static int no_of_members;
    static int no_of_books;

    protected static void displayMinfo(){
        if (!members.isEmpty()){
            System.out.println("The members registered in the library are:-");
            for (Member member : members) {
                Member.calculateFine(member);
                if (member.fine!=0) {
                    if (member.b1.getName() == null && member.b2.getName() == null) {
                        System.out.println("Member ID: " + member.getMem_id() + ", Name: " + member.getName() + ", Age: " + member.getAge() +
                                ", Phone No.: " + member.getPhone_no() + ", Book 1: Not issued, Book 2: Not issued, Fine: " + member.fine + "/-");
                    } else if (member.b1.getName() != null && member.b2.getName() == null) {
                        System.out.println("Member ID: " + member.getMem_id() + ", Name: " + member.getName() + ", Age: " + member.getAge() +
                                ", Phone No.: " + member.getPhone_no() + ", Book 1: " + member.b1.getName() + ", Book 2: Not issued, " +
                                "Fine: " + member.fine + "/-");
                    } else if (member.b1.getName() == null) {
                        System.out.println("Member ID: " + member.getMem_id() + ", Name: " + member.getName() + ", Age: " + member.getAge() +
                                ", Phone No.: " + member.getPhone_no() + ", Book 1: Not issued, Book 2: " + member.b2.getName() +
                                ", Fine: " + member.fine + "/-");
                    } else {
                        System.out.println("Member ID: " + member.getMem_id() + ", Name: " + member.getName() + ", Age: " + member.getAge() +
                                ", Phone No.: " + member.getPhone_no() + ", Book 1: "+member.b1.getName()+", Book 2: " + member.b2.getName() +
                                ", Fine: " + member.fine + "/-");
                    }
                }
                else {
                    if (member.b1.getName() == null && member.b2.getName() == null) {
                        System.out.println("Member ID: " + member.getMem_id() + ", Name: " + member.getName() + ", Age: " + member.getAge() +
                                ", Phone No.: " + member.getPhone_no() + ", Book 1: Not issued, Book 2: Not issued, Fine: No dues");
                    } else if (member.b1.getName() != null && member.b2.getName() == null) {
                        System.out.println("Member ID: " + member.getMem_id() + ", Name: " + member.getName() + ", Age: " + member.getAge() +
                                ", Phone No.: " + member.getPhone_no() + ", Book 1: " + member.b1.getName() + ", Book 2: Not issued, Fine: No dues");
                    } else if (member.b1.getName() == null) {
                        System.out.println("Member ID: " + member.getMem_id() + ", Name: " + member.getName() + ", Age: " + member.getAge() +
                                ", Phone No.: " + member.getPhone_no() + ", Book 1: Not issued, Book 2: " + member.b2.getName() + ", Fine: No dues");
                    } else {
                        System.out.println("Member ID: " + member.getMem_id() + ", Name: " + member.getName() + ", Age: " + member.getAge() +
                                ", Phone No.: " + member.getPhone_no() + ", Book 1: "+member.b1.getName()+", Book 2: " + member.b2.getName() + ", Fine: No dues");
                    }
                }
            }
        }
        else{
            System.out.println("There are no members registered in the library");
            System.out.println("You can register a member using Librarian mode (Select 1 as Librarian)");
        }
    }

    protected static void displayMinfo(Member m){                   //method overloading
        Member.calculateFine(m);
        if (m.nobookissued==1 && m.b1.getName()!=null){
            System.out.println("Your issued books are:-");
            System.out.println("Book 1 -> Book ID: " + m.b1.getBook_id() + ", Book Name: " + m.b1.getName() +
                    ", No of days since issued: "+m.b1.noofday);
            System.out.println("Book 2 -> not issued (select option 3 to issue a book)");
        }
        else if (m.nobookissued==1 && m.b2.getName()!=null){
            System.out.println("Your issued books are:-");
            System.out.println("Book 1 -> not issued (select option 3 to issue a book)");
            System.out.println("Book 2 -> Book ID: " + m.b2.getBook_id() + ", Book Name: " + m.b2.getName()+
                    ", No of days since issued: "+m.b2.noofday);
        }
        else if (m.nobookissued==2 && m.b1.getName()!=null && m.b2.getName()!=null){
            System.out.println("Your issued books are:-");
            System.out.println("Book 1 -> Book ID: " + m.b1.getBook_id() + ", Book Name: " + m.b1.getName() +
                    ", No of days since issued: "+m.b1.noofday);
            System.out.println("Book 2 -> Book ID: " + m.b2.getBook_id() + ", Book Name: " + m.b2.getName()+
                    ", No of days since issued: "+m.b2.noofday);
        }
        else if (m.nobookissued==0 || m.nobookissued>2){
            System.out.println("You have not issued any book");
            System.out.println("Select option 3 to issue a book");
        }
    }

    protected static void displayBinfo() {
        if (!books.isEmpty()) {
            System.out.println("The books available in the library are:-");
            for (Book book : books) {
                if (!book.isBorrowed) {
                    System.out.println("Book ID: " + book.getBook_id() + ", Name: " + book.getName() +
                            ", Author: " + book.getAuthor() + ", Status: Available");
                } else {
                    System.out.println("Book ID: " + book.getBook_id() + ", Name: " + book.getName() +
                            ", Author: " + book.getAuthor() + ", Status: Already Issued");
                }
            }
        }
        else{
            System.out.println("There are no books in the library");
            System.out.println("You can add a book using Librarian mode (Select 3 as Librarian)");
        }
    }
}

