package HomeWork14_2;

import java.util.ArrayList;

public class Author {
    private String firstName;
    private String secondName;
    private ArrayList<Book> books;
    public Author(){

    }

    ArrayList<Book>authorBooks = new ArrayList<>();

    public Author(String firstName, String secondName, ArrayList<Book> books){
        this.firstName = firstName;
        this.secondName = secondName;
        this.books = books;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public ArrayList<Book> getBooks() {
        return authorBooks;
    }

    public void setBooks(ArrayList<Book> books) {
        this.authorBooks = books;
    }

public String toString(){
     return "Author`s name is " + this.firstName +" his surname is " + this.secondName;
}
    public void printAuthorBooks() {
        System.out.println(this + " Books " + this.getBooks());
    }
    public void printAuthor(){
        System.out.println(this);
    }

}

