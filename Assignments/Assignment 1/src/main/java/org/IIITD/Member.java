package org.IIITD;

import java.util.Scanner;

class Member extends Library {
    private String name;
    private int age;
    private long phone_no;
    private int mem_id;

    public int getMem_id() {
        return mem_id;
    }

    public void setMem_id(int mem_id) {
        this.mem_id = mem_id;
    }

    public long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(long phone_no) {
        this.phone_no = phone_no;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {  this.name= name; }

    public Member(String name, int age, long phone_no, int mem_id) {
        setName(name);
        setAge(age);
        setPhone_no(phone_no);
        setMem_id(mem_id);
    }

    Book b1 = new Book(null, null, 0);
    Book b2 = new Book(null, null, 0);
    int nobookissued = 0;
    int fine = 0;

    static void calculateFine(Member m) {
        if (!m.b2.isBorrowed || !m.b1.isBorrowed) {
            long returntime = System.currentTimeMillis();
//        System.out.println("Return time = " + returntime);
            long duration1 = 0;
            if (m.b1.issuetime != 0) {
                duration1 = returntime - m.b1.issuetime;
            }
//        System.out.println("First book issue time = " + m.b1.issuetime);
//        System.out.println("Duration 1 = " + duration1);
            long duration2 = 0;
            if (m.b2.issuetime != 0) {
                duration2 = returntime - m.b2.issuetime;
            }
//        System.out.println("Second book issue time = " + m.b2.issuetime);
//        System.out.println("Duration 2 = " + duration2);
            m.b1.noofday = (int) (duration1 / 4000); //4 sec = 1 day
            m.b2.noofday = (int) (duration2 / 4000); //4 sec = 1 day
//        System.out.println("Noofday 1 = " + m.b1.noofday);
//        System.out.println("Noofday 2 = " + m.b2.noofday);

            if (m.b1.getName() != null && m.b1.noofday > 10) {
                m.b1.fineind = ((m.b1.noofday - 10) * 3);
//            System.out.println("Fine coz of book 1 = " + m.b1.fineind);
            }
            if (m.b2.getName() != null && m.b2.noofday > 10) {
                m.b2.fineind = ((m.b2.noofday - 10) * 3);
//            System.out.println("Fine coz of book 2 = " + m.b2.fineind);
            }
            m.fine = m.b1.fineind + m.b2.fineind;
//        System.out.println("Total fine = " + m.fine);
//        System.out.println("Fine = 0 ; Congrats!!!");
        }
    }

    static void displayMInput(Member m) {
        System.out.println("------------------------------");
        System.out.println("You have entered as Member. Select what you want to do:-");
        System.out.println("1. List Available Books");
        System.out.println("2. List My Books");
        System.out.println("3. Issue book");
        System.out.println("4. Return book");
        System.out.println("5. Pay Fine");
        System.out.println("6. Back");
        System.out.print("Enter the option (1-6): ");
        Scanner s = new Scanner(System.in);
        int MInput = s.nextInt();
        switch (MInput) {
            case 1 -> {
                Library.displayBinfo();
                Member.displayMInput(m);
            }
            case 2 -> {
                Library.displayMinfo(m);
                Member.displayMInput(m);
            }
            case 3 -> {
                if (m.nobookissued >= 2) {
                    System.out.println("You have already issued 2 books!");
                    Member.displayMInput(m);
                    break;
                }
                calculateFine(m);
                if (m.fine != 0) {
                    System.out.println("You have fine due of Rupees " + m.fine + "/-\n First clear your dues.");
                    Member.displayMInput(m);
                    break;
                }
                //if nobookissued < 2 && fine == 0
                Library.displayBinfo();
                if (books.isEmpty()) {
                    Member.displayMInput(m);
                    break;
                }
                boolean bookFound = false;  // Track if the book was found and processed
                System.out.println("Enter the Book ID of the book you want to issue: ");
                int b_id = s.nextInt();
                for (Book book : books) {
                    if (book.getBook_id() == b_id && book.isBorrowed) {
                        System.out.println("Book is already issued");
                        bookFound = true;
//                        Member.displayMInput(m);
                        break;
                    } else if (book.getBook_id() == b_id) {
                        if (m.nobookissued == 0 && m.fine == 0) {
                            m.b1.setName(book.getName());
                            m.b1.setBook_id(book.getBook_id());
                            m.b1.setAuthor(book.getAuthor());
                            m.nobookissued++;
                            book.isBorrowed = true;
                            m.b1.issuetime = System.currentTimeMillis();
                            System.out.println("Your book with ID " + b_id + " has been successfully issued!");
                            System.out.println("Kindly return within 10 days of issue!");
//                            Member.displayMInput(m);
                            bookFound = true;
                            break;
                        } else if (m.nobookissued == 1 && m.b1.getName() != null && m.fine == 0) {
                            m.b2.setName(book.getName());
                            m.b2.setBook_id(book.getBook_id());
                            m.b2.setAuthor(book.getAuthor());
                            m.nobookissued++;
                            book.isBorrowed = true;
                            m.b2.issuetime = System.currentTimeMillis();
                            System.out.println("Your book with ID " + b_id + " has been successfully issued!");
                            System.out.println("Kindly return within 10 days of issue!");
//                            Member.displayMInput(m);
                            bookFound = true;
                            break;
                        } else if (m.nobookissued == 1 && m.b2.getName() != null && m.fine == 0) {
                            m.b1.setName(book.getName());
                            m.b1.setBook_id(book.getBook_id());
                            m.b1.setAuthor(book.getAuthor());
                            m.nobookissued++;
                            book.isBorrowed = true;
                            m.b1.issuetime = System.currentTimeMillis();
                            System.out.println("Your book with ID " + b_id + " has been successfully issued!");
                            System.out.println("Kindly return within 10 days of issue!");
//                            Member.displayMInput(m);
                            bookFound = true;
                            break;
                        }
                        break;
                    }
                }
                if (bookFound) {
                    Member.displayMInput(m);
                } else {
                    System.out.println("No book found with ID: " + b_id);
                    Member.displayMInput(m);
                }
            }
            case 4 -> {
                Library.displayMinfo(m);
                if (m.b1.getName() == null && m.b2.getName() == null) {
                    Member.displayMInput(m);
                    break;
                }
                System.out.println("Enter the Book ID of the book you want to return: ");
                int b_idi = s.nextInt();
                calculateFine(m);
                if (b_idi == m.b1.getBook_id()) {
                    for (Book b : books) {
                        if (b.getBook_id() == b_idi) {
                            b.isBorrowed = false;
                            m.b1.issuetime = 0;
                            m.b1.noofday = 0;
                            m.b1.setName(null);
                            m.nobookissued--;
                            System.out.println("Book Successfully returned!");
                            if (m.b1.fineind != 0) {
                                System.out.println("You have a fine on this book of Rupees " + m.b1.fineind + "/-");
                                System.out.println("Select 5 to clear your dues");
                                Member.displayMInput(m);
                                break;
                            }
                            Member.displayMInput(m);
                            break;
                        }
                    }
                } else if (b_idi == m.b2.getBook_id()) {
                    for (Book b : books) {
                        if (b.getBook_id() == b_idi) {
                            b.isBorrowed = false;
                            m.b2.issuetime = 0;
                            m.b2.noofday = 0;
                            m.b2.setName(null);
                            m.nobookissued--;
                            System.out.println("Book Successfully returned!");
                            if (m.b2.fineind != 0) {
                                System.out.println("You have a fine on this book of Rupees " + m.b2.fineind + "/-");
                                System.out.println("Select 5 to clear your dues");
                                Member.displayMInput(m);
                                break;
                            }
                            Member.displayMInput(m);
                            break;
                        }
                    }
                } else {
                    System.out.println("You don't have the book with ID: " + b_idi);
                    Member.displayMInput(m);
                }
            }
            case 5 -> {
                calculateFine(m);
                if (m.fine == 0) {
                    System.out.println("All your dues are cleared!");
                    Member.displayMInput(m);
                } else if (m.b1.getName() == null && m.b2.getName() == null) {
                    System.out.println("You have a fine due of Rupees " + m.fine + "/-");
                    m.b1.fineind = 0;
                    m.b2.fineind = 0;
                    m.fine = 0;

                    System.out.println("All your dues are cleared!");
                    Member.displayMInput(m);
                } else {
                    // can't pay the fine without returning the book
                    System.out.println("You have a fine due of Rupees " + m.fine + "/-");
                    System.out.println("First return the books, then pay the fine");
                    Member.displayMInput(m);
                }
            }
            case 6 -> Main.takeInput();
            default -> {
                System.out.println("Choose and enter valid option from 1-6");
                Member.displayMInput(m);
            }
        }
        s.close();
    }
}
