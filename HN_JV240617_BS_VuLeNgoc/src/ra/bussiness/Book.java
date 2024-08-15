package ra.bussiness;

import java.util.Scanner;

import ra.run.BookManagement;

import java.text.DecimalFormat;

public class Book {

    private static int bookIdCounter = 1;
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;
    private static final DecimalFormat df = new DecimalFormat("#,###");

    public Book() {
        this.bookId = bookIdCounter++;
        this.bookStatus = true;
    }


    public Book(String bookName, String author, String descriptions, double importPrice, double exportPrice) {
        this.bookId = bookIdCounter++;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = (float) (exportPrice - importPrice);
        this.bookStatus = true;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData() {

        Scanner scanner = new Scanner(System.in);


        do {
            System.out.print("Nhập tên sách: ");
            this.bookName = scanner.nextLine();
            if (this.bookName.trim().isEmpty()) {
                System.out.println("Tên sách không được để trống.");
            }
        } while (this.bookName.trim().isEmpty());

        do {
            System.out.print("Nhập tác giả: ");
            this.author = scanner.nextLine();
            if (this.author.trim().isEmpty()) {
                System.out.println("Tác giả không được để trống.");
            }
        } while (this.author.trim().isEmpty());

        do {
            System.out.print("Nhập mô tả (ít nhất 10 ký tự): ");
            this.descriptions = scanner.nextLine();
            if (this.descriptions.trim().isEmpty()) {
                System.out.println("Mô tả không được để trốn");
            }
            if (this.descriptions.length() < 10) {
                System.out.println("Mô tả phải có ít nhất 10 ký tự.");
            }
        } while (this.descriptions.length() < 10);

        do {
            System.out.print("Nhập giá nhập: ");
            this.importPrice = scanner.nextDouble();
            if (this.importPrice <= 0) {
                System.out.println("Giá nhập phải lớn hơn 0.");
            }
        } while (this.importPrice <= 0);

        do {
            System.out.print("Nhập giá xuất: ");
            this.exportPrice = scanner.nextDouble();
            if (this.exportPrice <= 1.2 * this.importPrice) {
                System.out.println("Giá xuất phải lớn hơn 1.2 lần giá nhập.");
            }
        } while (this.exportPrice <= 1.2 * this.importPrice);

        this.interest = (float) (this.exportPrice - this.importPrice);

        this.bookStatus = true;
    }

    public void displayData() {
        System.out.println("Mã sách: " + this.bookId);
        System.out.println("Tên sách: " + this.bookName);
        System.out.println("Tác giả: " + this.author);
        System.out.println("Mô tả: " + this.descriptions);
        System.out.println("Giá nhập: " + df.format(this.importPrice) + "VND");
        System.out.println("Giá xuất: " + df.format(this.exportPrice) + "VND");
        System.out.println("Lợi nhuận: " + df.format(this.interest) + "VND");
        System.out.println("Trạng thái sách: " + (this.bookStatus ? "Còn" : "Hết"));
        System.out.println("-------------------------------");
    }

}

