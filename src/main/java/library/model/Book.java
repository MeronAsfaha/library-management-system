package library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    @OneToMany(mappedBy = "book")
    private List<BookCopy> bookCopies= new ArrayList<>();

    public int getNumberOfCopies() {
        return bookCopies.size();
    }

    public long getNumberOfAvailableCopies() {
        return bookCopies.stream().filter(bookCopy -> bookCopy.getBookCopyStatus().equals(BookCopyStatus.AVAILABLE)).count();
    }

    public boolean checkoutBookCopy() {
        if (getNumberOfAvailableCopies() > 0) {
            bookCopies.stream().filter(bookCopy -> bookCopy.getBookCopyStatus().equals(BookCopyStatus.AVAILABLE))
                    .findFirst()
                    .ifPresent(bookCopy -> bookCopy.setBookCopyStatus(BookCopyStatus.CHECKED_OUT));
            return true;
        }
        return false;
    }

    public boolean returnBookCopy(BookCopy bookCopy) {
        bookCopies.stream().filter(copy -> copy.getId().equals(bookCopy.getId()))
                .findFirst()
                .ifPresent(copy -> copy.setBookCopyStatus(BookCopyStatus.AVAILABLE));
        return true;
    }

}
