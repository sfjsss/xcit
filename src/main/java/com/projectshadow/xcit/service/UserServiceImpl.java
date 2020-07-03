package com.projectshadow.xcit.service;

import com.projectshadow.xcit.entity.User;
import com.projectshadow.xcit.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        String hashedPW = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPW);
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
