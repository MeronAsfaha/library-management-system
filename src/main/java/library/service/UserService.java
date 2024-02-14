package library.service;

import library.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User saveUser(User user);
    User findById(Long id);
    User update(User user);
    void delete(Long id);

}
