package library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CheckoutEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String checkoutDate;
    private String dueDate;
    private String returnDate;
    private RentStatus status;
    private String fine;
    @ManyToOne
    private User user;
    @ManyToOne
    private BookCopy bookCopy;
}
