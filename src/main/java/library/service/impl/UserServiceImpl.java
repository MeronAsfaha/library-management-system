package library.service.impl;

import library.model.User;
import library.repository.UserRepo;
import library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User saveUser(User userService) {
        return userRepo.save(userService);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User update(User userService) {
        if (userRepo.findById(userService.getId()).isPresent()) {
            return userRepo.save(userService);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
