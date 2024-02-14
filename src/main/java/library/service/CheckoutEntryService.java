package library.service;

import library.model.CheckoutEntry;

import java.util.List;

public interface CheckoutEntryService {

    List<CheckoutEntry> findAll();
    CheckoutEntry saveCheckoutEntry(CheckoutEntry checkoutEntry);
    CheckoutEntry findById(Long id);
    CheckoutEntry update(CheckoutEntry checkoutEntry);
    void delete(Long id);

}
