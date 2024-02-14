package library.repository;

import library.model.CheckoutEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutEntryRepo extends JpaRepository<CheckoutEntry, Long> {
}
