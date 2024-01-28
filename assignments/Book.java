/**
 * Book.java - Assignment 01
 * @author Cuso
 */

 enum BookMedium {
    PhysicalBook,
    EBook,
    AudioBook;
}
enum BookGenre {
    Fiction,
    NonFiction;
}
enum BookRating {
    Rating1(1),
    Rating2(2),
    Rating3(3),
    Rating4(4),
    Rating5(5);

    int number;
    BookRating(int number) {
        this.number = number;
    }
}


class Book {
    private String title;
    private String author;
    private int readDate;
    private int publishedDate;
    private BookGenre genre;
    private BookMedium medium;
    private BookRating rating;
   

    public Book(String title, String author, BookGenre genre) {
        this.title = title;
        this.setAuthor(author);
        this.setGenre(genre);
    }
    public Book(String title, String author, BookGenre genre, int publishedDate) {
        this.title = title;
        this.setAuthor(author);
        this.setGenre(genre);
        this.setPublishedDate(publishedDate);
    }
    public Book(String title, String author, BookGenre genre, int publishedDate, int readDate, BookMedium medium, BookRating rating) {
        this.title = title;
        this.setAuthor(author);
        this.setGenre(genre);
        this.setPublishedDate(publishedDate);
        this.setReadDate(readDate);
        this.setMedium(medium);
        this.setRating(rating);
    }

    public String getAuthor() {
        return author;
    }
    public BookMedium getMedium() {
        return medium;
    }
    public String getTitle() {
        return title;
    }
    public int getReadDate() {
        return readDate;
    }
    public BookGenre getGenre() {
        return genre;
    }
    public int getPublishedDate() {
        return publishedDate;
    }
    public BookRating getRating() {
        return rating;
    }


    public void setAuthor(String author) {
        this.author = author;
    }
    public void setMedium(BookMedium medium) {
        this.medium = medium;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setReadDate(int readDate) {
        this.readDate = readDate;
    }
    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }
    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }
    public void setRating(BookRating rating) {
        this.rating = rating;
    }


    public String toString() {
        if (rating != null) {
            return this.title + " by " + this.author + " ("+this.publishedDate+") " + "- " + "read in " + this.readDate + ", rated " + this.rating.number + "/5";
        }
        else if (publishedDate != 0) {
            return this.title + " by " + this.author + " ("+this.publishedDate+")";
        }
        else {
            return this.title + " by " + this.author;
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("Children of Time", "Adrian Tchaikovsky", BookGenre.Fiction);
        System.out.println(b1);
        Book b2 = new Book("The Fifth Season", "N. K. Jemesin", BookGenre.Fiction, 2015);
        System.out.println(b2);
        Book b3 = new Book("Perdido Street Station", "China Mieville",
            BookGenre.Fiction, 2000, 2020, BookMedium.EBook, BookRating.Rating5);
        System.out.println(b3);

        System.out.println(b1.getTitle());
        System.out.println(b1.getAuthor());
        System.out.println(b1.getGenre());
        System.out.println(b2.getPublishedDate());
        System.out.println(b3.getReadDate());
        System.out.println(b3.getMedium());
        System.out.println(b3.getRating());
    }
}