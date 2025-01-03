package starter.librarysystem.apiactions.preactions;

import io.cucumber.java.BeforeAll;

import starter.librarysystem.api.ApiUtil;
import starter.librarysystem.dto.Book;

import java.util.ArrayList;
import java.util.List;


public class PreAction {
    public static Book globalBookToTest;
    public static List<Book> globalBookToDelete = new ArrayList<>();
    public static List<Book> globalBookToUpdate = new ArrayList<>();

    @BeforeAll
    public static void givenThatBookIsAvailableInLibraryWithTitleAndAuthor() {
        // For Book fetch with Id
        Book book = new Book("Jenkins Tutorial", "Reyon");
        ApiUtil util = new ApiUtil();
        globalBookToTest = util.asUser().addBook(book);

        // For Delete book
        Book book2 = new Book("Delete book 1", "Shakila");
        Book book3 = new Book("Delete book 2", "Akila");
        Book book4 = new Book("Delete book 3", "Hasitha");
        globalBookToDelete.add(util.asUser().addBook(book2));
        globalBookToDelete.add(util.asUser().addBook(book3));
        globalBookToDelete.add(util.asUser().addBook(book4));

        // For update book
        Book book5 = new Book("Komuthu book 5", "Komuthu");
        Book book6 = new Book("Komuthu book 6", "Komuthu1");
        Book book7 = new Book("Komuthu book 7", "Komuthu1");
        globalBookToUpdate.add(util.asUser().addBook(book5));
        globalBookToUpdate.add(util.asUser().addBook(book6));
        globalBookToUpdate.add(util.asUser().addBook(book7));

    }
}
