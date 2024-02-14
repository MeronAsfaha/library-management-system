package library.service;

import library.model.CheckoutRecord;

import java.util.List;

public interface CheckoutRecordService {
    List<CheckoutRecord> findAll();
    CheckoutRecord saveCheckoutRecord(CheckoutRecord checkoutRecord);
    CheckoutRecord findById(Long id);
    CheckoutRecord update(CheckoutRecord checkoutRecord);
    void delete(Long id);

    CheckoutRecord borrowBook(Long id);
}
