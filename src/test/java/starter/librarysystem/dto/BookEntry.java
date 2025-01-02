package starter.librarysystem.dto;

public class BookEntry {
    private String title;
    private String author;
    private String role;

    // Constructor, getters, and setters
    public BookEntry(String title, String author, String role) {
        this.title = title;
        this.author = author;
        this.role = role;

    }

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

}
