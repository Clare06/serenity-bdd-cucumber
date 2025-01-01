package starter.librarysystem.dto;

public class Book {
    private String title;
    private String author;
    private Integer id;

    public Book() {

    }

    public Book(Integer id, String title, String author) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
