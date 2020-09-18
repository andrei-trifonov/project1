package Practice3;

public class BookTest {
    public static void main(String[] args) {
    Book newBook1 = new Book();
    newBook1.setAuthor("В. Сорокин");
    newBook1.setDate(1979);
    newBook1.setPublisher("АСТ");
    newBook1.setName("Норма");
    newBook1.setSheets(300);
    System.out.println(newBook1.toString());

    }
}
class Book{
    private String author;
    private int date;
    private String name;
    private String publisher;
    private int sheets;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setSheets(int sheets) {
        this.sheets = sheets;
    }

    public int getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getSheets() {
        return sheets;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", sheets=" + sheets +
                '}';
    }
}