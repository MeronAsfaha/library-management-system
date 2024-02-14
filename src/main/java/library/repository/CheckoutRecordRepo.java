package library.repository;

import library.model.CheckoutRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRecordRepo extends JpaRepository<CheckoutRecord, Long> {
}
