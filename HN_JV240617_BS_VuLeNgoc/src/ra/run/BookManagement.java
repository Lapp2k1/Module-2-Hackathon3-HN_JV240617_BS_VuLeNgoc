package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    public static final Book[] bookList = new Book[100];
    public static int bookCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("**************** JAVA-HACKATATHON-05-BASIC-MENU ***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.print("Mời bạn chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBooks(scanner);
                    displayAllBooks();
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    sortBooksByInterest();
                    displayAllBooks();
                    break;
                case 4:
                    deleteBookById(scanner);
                    displayAllBooks();
                    break;
                case 5:
                    searchBooks(scanner);
                    break;
                case 6:
                    updateBookById(scanner);
                    displayAllBooks();
                    break;
                case 7:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 7);


    }

    private static void addBooks(Scanner scanner) {
        System.out.print("Nhập số lượng sách cần thêm: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (n > 0 && bookCount + n <= 100) {
            for (int i = 0; i < n; i++) {
                System.out.println("Nhập thông tin sách thứ " + (i + 1) + ":");
                Book book = new Book();
                book.inputData();
                bookList[bookCount] = book;
                bookCount++;
            }
        } else {
            System.out.println("Số lượng sách không hợp lệ hoặc danh sách đã đầy (tối đa 100 sách).");
        }
    }

    private static void displayAllBooks() {
        if (bookCount == 0) {
            System.out.println("Thư viện không có sách.");
        } else {
            for (int i = 0; i < bookCount; i++) {
                bookList[i].displayData();
            }
        }
    }

    private static void sortBooksByInterest() {
        if (bookCount == 0) {
            System.out.println("Thư viện không có sách để sắp xếp.");
        } else {
            for (int i = 0; i < bookCount - 1; i++) {
                for (int j = i + 1; j < bookCount; j++) {
                    if (bookList[i].getInterest() > bookList[j].getInterest()) {
                        Book temp = bookList[i];
                        bookList[i] = bookList[j];
                        bookList[j] = temp;
                    }
                }
            }
            System.out.println("Đã sắp xếp sách theo lợi nhuận tăng dần.");
        }
    }

    private static void deleteBookById(Scanner scanner) {
        System.out.print("Nhập mã sách cần xóa: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].getBookId() == bookId) {

                for (int j = i; j < bookCount - 1; j++) {
                    bookList[j] = bookList[j + 1];
                }
                bookList[bookCount - 1] = null;
                bookCount--;
                System.out.println("Đã xóa sách có mã: " + bookId);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách có mã: " + bookId);
        }
    }

    private static void searchBooks(Scanner scanner) {
        System.out.print("Nhập chuỗi tìm kiếm (theo tên hoặc mô tả): ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].getBookName().toLowerCase().contains(keyword) ||
                    bookList[i].getDescriptions().toLowerCase().contains(keyword)) {
                bookList[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách nào phù hợp.");
        }
    }

    private static void updateBookById(Scanner scanner) {
        System.out.print("Nhập mã sách cần thay đổi thông tin: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].getBookId() == bookId) {
                System.out.println("Nhập mã sách cần thay đổi thông tin: " + bookId);
                bookList[i].inputData();
                System.out.println("Đã cập nhật thông tin sách.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách có mã: " + bookId);
        }
    }
}
