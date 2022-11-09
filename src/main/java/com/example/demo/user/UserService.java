package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByUsername(user.getUsername());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("username already registered");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with id " + userId + " does not exist!");
        }
        userRepository.deleteById(userId);
    }

    private UserDTO convertEntityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setAge(user.getAge());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUsername(user.getUsername());
        userDTO.setSubscriptionType(user.getSubscriptionType());
        return userDTO;
    }

    @Transactional
    public void updateUser(Long userId, String firstName, String lastName, String username, String subscriptionType, Integer age) {
        User user = userRepository.findUserById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "User with id " + userId + " does not exist!"
                ));

        if (username != null && username.length() > 0 &&
                !Objects.equals(user.getUsername(), username)) {
            Optional<User> userOptional = userRepository.findUserByUsername(username);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("Username already taken");
            }
            user.setUsername(username);
        }

        if (firstName != null && firstName.length() > 0 &&
                !Objects.equals(user.getFirstName(), firstName)) {
            user.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 &&
                !Objects.equals(user.getLastName(), lastName)) {
            user.setLastName(lastName);
        }

        if (subscriptionType != null && subscriptionType.length() > 0 &&
                !Objects.equals(user.getSubscriptionType(), subscriptionType)) {
            user.setSubscriptionType(subscriptionType);
        }

        if (age != null && age > 0 &&
                !Objects.equals(user.getAge(), age)) {
            user.setAge(age);
        }
    }
}
