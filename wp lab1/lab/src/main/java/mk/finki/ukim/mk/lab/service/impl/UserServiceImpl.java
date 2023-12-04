package mk.finki.ukim.mk.lab.service.impl;

import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findUserByUsername(String username) {
        Optional<User> userOptional = userRepository.findAll().stream()
                .filter(u -> u.getPersonName().getName().equals("slavcho")).findFirst();
        return userOptional.orElse(null);
    }
}
