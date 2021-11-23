package HomeWork14_2;

public class Book {
    private String name;
    private int year;
    private String description;
    private Genre genre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Book(String name, int year, String description, Genre genre){
        this.name = name;
        this.year = year;
        this.description = description;
        this.genre = genre;

    }
    public String toString() {
        return "Book name - " + this.name + ", genre - " + this.genre.getTitle()
                + "was written in " + this.year + ", description: " + this.description + ".";
    }
    public void printBook(){
        System.out.println(this);
    }

}
