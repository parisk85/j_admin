package gr.parisk85.admin.service;

import gr.parisk85.admin.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> findAll();
    void save(User user);
    Optional<User> findByUsername(String username);
}
