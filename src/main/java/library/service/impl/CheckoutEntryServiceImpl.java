package library.service.impl;

import library.model.CheckoutEntry;
import library.repository.CheckoutEntryRepo;
import library.service.CheckoutEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CheckoutEntryServiceImpl implements CheckoutEntryService {
    private final CheckoutEntryRepo checkoutEntryRepo;

    @Override
    public List<CheckoutEntry> findAll() {
        return checkoutEntryRepo.findAll();
    }

    @Override
    public CheckoutEntry saveCheckoutEntry(CheckoutEntry checkoutEntry) {
        return checkoutEntryRepo.save(checkoutEntry);
    }

    @Override
    public CheckoutEntry findById(Long id) {
        return checkoutEntryRepo.findById(id).orElse(null);
    }

    @Override
    public CheckoutEntry update(CheckoutEntry checkoutEntry) {
        if (checkoutEntryRepo.findById(checkoutEntry.getId()).isPresent()) {
            return checkoutEntryRepo.save(checkoutEntry);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        checkoutEntryRepo.deleteById(id);
    }
}
