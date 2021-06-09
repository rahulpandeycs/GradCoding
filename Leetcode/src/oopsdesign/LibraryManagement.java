package src.oopsdesign;

import java.time.LocalDate;
import java.util.Date;
import java.util.*;

public class LibraryManagement {
}


enum BookFormat {
    HARDCOVER,
    PAPERBACK,
    AUDIO_BOOK,
    EBOOK,
    NEWSPAPER,
    MAGAZINE,
    JOURNAL
}

enum BookStatus {
    AVAILABLE,
    RESERVED,
    LOANED,
    LOST
}

enum ReservationStatus{
    WAITING,
    PENDING,
    CANCELED,
    NONE,
    COMPLETED
}

enum AccountStatus{
    ACTIVE,
    CLOSED,
    CANCELED,
    BLACKLISTED,
    NONE
}

class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}

class Person {
    private String name;
    private Address address;
    private String email;
    private String phone;
}

class Author extends Person{

}

class Constants {
    public static final int MAX_BOOKS_ISSUED_TO_A_USER = 5;
    public static final int MAX_LENDING_DAYS = 10;
}




 abstract class Account {
    private String id;
    private String password;
    private AccountStatus status;
    private Person person;

    public boolean resetPassword() {
         return false;
     }

     public String getId() {
         return id;
     }

     public AccountStatus getStatus() {
         return status;
     }
 }

 class Librarian extends Account {
    public boolean addBookItem(BookItem bookItem) {
        return false;
    }

    public boolean blockMember(Member member) {
        return false;
    }

    public boolean unBlockMember(Member member) {
        return false;
    }
}

 class Member extends Account {
    private Date dateOfMembership;
    private int totalBooksCheckedout;

    public int getTotalBooksCheckedOut() {
        return totalBooksCheckedout;
    }

    public boolean reserveBookItem(BookItem bookItem) {
        return false;
    }

    private void incrementTotalBooksCheckedout() {
        this.totalBooksCheckedout++;
    }


    private void decrementTotalBooksCheckedout() {
        this.totalBooksCheckedout--;
    }

    public boolean checkoutBookItem(BookItem bookItem) {
        if (this.getTotalBooksCheckedOut() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
            //ShowError("The user has already checked-out maximum number of books");
            return false;
        }
        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarCode());
        if (bookReservation != null && bookReservation.getMemberId() != this.getId()) {
            // book item has a pending reservation from another user
            //ShowError("This book is reserved by another member");
            return false;
        } else if (bookReservation != null) {
            // book item has a pending reservation from the give member, update it
            bookReservation.updateStatus(ReservationStatus.COMPLETED);
        }

        if (!bookItem.checkout(this.getId())) {
            return false;
        }

        this.incrementTotalBooksCheckedout();
        return true;
    }

    private void checkForFine(String bookItemBarcode) {
        BookLending bookLending = BookLending.fetchLendingDetails(bookItemBarcode);
        Date dueDate = bookLending.getDueDate();
        Date today = new Date(); //todays date
        // check if the book has been returned within the due date
        if (today.compareTo(dueDate) > 0) {
            long todaysData = 0;
            long diff = todaysData - dueDate.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            // ** Fine.collectFine(memberId, diffDays);
        }
    }

    public void returnBookItem(BookItem bookItem) {
        this.checkForFine(bookItem.getBarCode());
        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarCode());
        if (bookReservation != null) {
            // book item has a pending reservation
          //**  bookItem.updateBookItemStatus(BookStatus.RESERVED);
           //** bookReservation.sendBookAvailableNotification();
        }
        bookItem.updateBookItemStatus(BookStatus.AVAILABLE);
    }

    public boolean renewBookItem(BookItem bookItem) {
        this.checkForFine(bookItem.getBarCode());
        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarCode());
        // check if this book item has a pending reservation from another member
        if (bookReservation != null && bookReservation.getMemberId() != this.getId()) {
            //ShowError("This book is reserved by another member");
            this.decrementTotalBooksCheckedout();
            bookItem.updateBookItemStatus(BookStatus.RESERVED);
            bookReservation.sendNotification();
            return false;
        } else if (bookReservation != null) {
            // book item has a pending reservation from this member
            bookReservation.updateStatus(ReservationStatus.COMPLETED);
        }
        BookLending.lendBook(bookItem.getBarCode(), this.getId());
        bookItem.updateDueDate(LocalDate.now().plusDays(Constants.MAX_LENDING_DAYS));
        return true;
    }
}


 class BookReservation {
    private Date creationDate;
    private ReservationStatus status;
    private String bookItemBarcode;
    private String memberId;

    public static BookReservation fetchReservationDetails(String barcode) {
        return null;
    }

     public void sendNotification() {
         return;
     }

     public ReservationStatus getStatus() {
         return status;
     }

     public ReservationStatus updateStatus(ReservationStatus status) {
         return status;
     }

     public String getBookItemBarcode() {
         return bookItemBarcode;
     }

     public String getMemberId() {
         return memberId;
     }
}

 class BookLending {
    private Date borrowedDate;
    private Date dueDate;
    private Date returnDate;
    private String bookItemBarcode;
    private String memberId;

    public static boolean lendBook(String barcode, String memberId) {
        return false;
    }

    public static BookLending fetchLendingDetails(String barcode) {
        return null;
    }

     public Date getDueDate() {
         return dueDate;
     }

}

 class Fine {
    private Date creationDate;
    private double bookItemBarcode;
    private String memberId;

    public static void collectFine(String memberId, long days) {}
}


 abstract class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private List<Author> authors;
}

 class BookItem extends Book {
    private String barcode;
    private boolean isReferenceOnly;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;


    public void updateBookItemStatus(BookStatus loaned) {
    }

     public void updateDueDate(LocalDate date) {
     }

    public String getBarCode() {
        return "";
    }

    public boolean checkout(String memberId) {
        if(this.isReferenceOnly) {
            //ShowError("This book is Reference only and can't be issued");
            return false;
        }
        if(!BookLending.lendBook(this.getBarCode(), memberId)){
            return false;
        }
        this.updateBookItemStatus(BookStatus.LOANED);
        return true;
    }

}

 class Rack {
    private int number;
    private String locationIdentifier;
}



 interface Search {
    public List<Book> searchByTitle(String title);
    public List<Book> searchByAuthor(String author);
    public List<Book> searchBySubject(String subject);
    public List<Book> searchByPubDate(Date publishDate);
}

 class Catalog implements Search {
    private HashMap<String, List<Book>> bookTitles;
    private HashMap<String, List<Book>> bookAuthors;
    private HashMap<String, List<Book>> bookSubjects;
    private HashMap<String, List<Book>> bookPublicationDates;

    public List<Book> searchByTitle(String query) {
        // return all books containing the string query in their title.
        return bookTitles.get(query);
    }

    public List<Book> searchByAuthor(String query) {
        // return all books containing the string query in their author's name.
        return bookAuthors.get(query);
    }

     @Override
     public List<Book> searchBySubject(String subject) {
         return null;
     }

     @Override
     public List<Book> searchByPubDate(Date publishDate) {
         return null;
     }
 }
