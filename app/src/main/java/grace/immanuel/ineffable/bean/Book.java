package grace.immanuel.ineffable.bean;

public class Book {
    private String bookName;
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBookName() {
        return bookName;
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}