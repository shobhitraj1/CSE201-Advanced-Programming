package org.IIITD;

class Book extends Library{
    private String name;
    private String author;
    private int copies;
    private int book_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    boolean isBorrowed;
    long issuetime;
    int noofday;
    int fineind;

    public Book(String name, String author, int book_id) {
        setName(name);
        setAuthor(author);
        setBook_id(book_id);
        this.issuetime=0;
        this.noofday=0;

    }

    public Book(String name, String author, int copies, int book_id) {
        setName(name);
        setAuthor(author);
        setCopies(copies);
        setBook_id(book_id);
        this.isBorrowed = false;
    }
}
