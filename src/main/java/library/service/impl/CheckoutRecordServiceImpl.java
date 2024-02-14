package library.service.impl;

import library.model.CheckoutRecord;
import library.repository.BookRepo;
import library.repository.CheckoutRecordRepo;
import library.service.CheckoutRecordService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckoutRecordServiceImpl implements CheckoutRecordService {
    private final CheckoutRecordRepo checkoutRecordRepo;
    private final BookRepo bookRepo;
    @Override
    public List<CheckoutRecord> findAll() {
        return checkoutRecordRepo.findAll();
    }

    @Override
    public CheckoutRecord saveCheckoutRecord(CheckoutRecord checkoutRecordService) {
        return checkoutRecordRepo.save(checkoutRecordService);
    }

    @Override
    public CheckoutRecord findById(Long id) {
        return checkoutRecordRepo.findById(id).orElse(null);
    }

    @Override
    public CheckoutRecord update(CheckoutRecord checkoutRecordService) {
        if (checkoutRecordRepo.findById(checkoutRecordService.getId()).isPresent()) {
            return checkoutRecordRepo.save(checkoutRecordService);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        checkoutRecordRepo.deleteById(id);
    }

    @Override
    public CheckoutRecord borrowBook(Long id) {
        val checkoutRecord = new CheckoutRecord(null, bookRepo.findById(id).orElse(null), null);
        return checkoutRecordRepo.save(checkoutRecord);
    }
}
