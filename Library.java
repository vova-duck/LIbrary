package HomeWork14_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Library {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public  ArrayList<Author> authors = new ArrayList<>();
    public  ArrayList<Genre> genres = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        System.out.println("press any button to start");
        Library library = new Library();
            while (!(reader.readLine()).equals("exit")){
                System.out.println("Choose object: BOOK, AUTHOR or GENRE. After choose action: ADD, DELETE or PRINT.");
            try {
                library.chooseObject(Unit.valueOf(reader.readLine()),Action.valueOf(reader.readLine()));
            } catch (IllegalArgumentException e) {
                System.out.println("press any button to restart");
            }

        }

    }

    public void createAuthor() throws IOException {
        System.out.println("Input author's name:");
        String name = reader.readLine();

        System.out.println("Input author's surname:");
        String surname = reader.readLine();

        ArrayList<Book> authorBooks = new ArrayList<>();

        Author author = new Author(name, surname, authorBooks);
        author.printAuthor();
        authors.add(author);
    }

    public void createGenre() throws IOException {
        System.out.println("Input genre name: ");
        String name = reader.readLine();

        System.out.println("Input genre description:");
        String description = reader.readLine();

        Genre genre = new Genre(name, description);

        genre.printGenre();
        genres.add(genre);

    }

    public void createBook() throws IOException {
        System.out.println("Input book's name: ");
        String name = reader.readLine();
        System.out.println("Input year: ");
        int year = Integer.parseInt(reader.readLine());
        System.out.println("Input description: ");
        String description = reader.readLine();
        Book book = new Book(name, year, description, chooseGenre());
        book.printBook();
        chooseAuthor().getBooks().add(book);
    }

    public Genre chooseGenre() throws IOException {
        if (genres.size() == 0) {
            System.out.println("Create genre:");
            createGenre();
        }
        System.out.println("Choose genre: ");
        for (int i = 0; i < genres.size(); i++) {
            System.out.println("[" + i + "] -" + genres.get(i));
        }
        int input = Integer.parseInt(reader.readLine());
        if (input < 0 || input >= genres.size()) {
            return chooseGenre();
        }
        return genres.get(input);
    }

    public Author chooseAuthor() throws IOException {
        if (authors.size() == 0) {
            System.out.println("Create author:");
            createAuthor();
        }
        System.out.println("Choose author: ");
        for (int i = 0; i < authors.size(); i++) {
            System.out.println("[" + i + "] -" + authors.get(i));
        }
        int input = Integer.parseInt(reader.readLine());
        if (input < 0 || input >= authors.size()) {
            return chooseAuthor();
        }
        return authors.get(input);
    }


    public ArrayList<Genre> deleteGenre() throws IOException {
        if (genres.size() == 0) {
            System.out.println("No genres created!");
        }
        System.out.println("What genre do you want to delete?");
        for (int i = 0; i < genres.size(); i++) {
            System.out.println("[" + i + "] -" + genres.get(i));
        }
        int input = Integer.parseInt(reader.readLine());
        if (input < 0 || input >= genres.size()) {
            return deleteGenre();
        }
        genres.remove(input);
        return genres;
    }

    public void deleteBook() throws IOException {

        System.out.println("What book do you want to delete? Input name:");
        String input = reader.readLine();
        for (Author author : authors) {
            if (getBookIndex(author, input) != -1) {
                author.getBooks().remove(getBookIndex(author, input));
            }
        }
    }

    public int getBookIndex(Author author, String input) {
        int numberBook;
        for (Book book : author.getBooks()) {
            if (book.getName().equals(input)) {
                numberBook = author.getBooks().indexOf(book);
                return numberBook;
            }
        }
        return -1;
    }


    public ArrayList<Author> deleteAuthor() throws IOException {
        if (authors.size() == 0) {
            System.out.println("No authors created!");
        }
        System.out.println("What author do you want to delete?");
        for (int i = 0; i < authors.size(); i++) {
            System.out.println("[" + i + "] -" + authors.get(i));
        }
        int input = Integer.parseInt(reader.readLine());
        if (input < 0 || input >= authors.size()) {
            return deleteAuthor();
        }
        authors.remove(input);
        return authors;
    }

    public void chooseObject(Unit unit, Action action) throws IOException {
        switch (unit) {
            case AUTHOR ->
                chooseAuthorAction(action);
            case GENRE ->
                chooseGenreAction(action);
            case BOOK ->
                chooseBookAction(action);
        }
    }

    public void chooseAuthorAction(Action action) throws IOException {
        switch (action) {
            case ADD -> createAuthor();
            case DELETE -> deleteAuthor();
            case PRINT -> {
                if (authors.size() == 0) {
                    System.out.println("no authors created yet, create one)");
                }
                for (Author author : authors) {
                    System.out.println(author);
                }
            }
        }

    }

    public void chooseGenreAction(Action action) throws IOException {
        switch (action) {
            case ADD -> createGenre();
            case DELETE -> deleteGenre();
            case PRINT -> {
                if (genres.size() == 0) {
                    System.out.println("no genres created yet, create one)");
                }
                for (Genre genre : genres) {
                    System.out.println(genre);
                }
            }
        }
    }

    public void chooseBookAction(Action action) throws IOException {
        switch (action) {
            case ADD -> createBook();
            case DELETE -> deleteBook();
            case PRINT -> {
                if (authors.size() == 0) {
                    System.out.println("no books created yet, create one)");
                }
                for (Author author : authors) {
                    author.printAuthorBooks();
                }
            }
        }
    }

}





