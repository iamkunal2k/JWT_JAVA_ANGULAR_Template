package com.chatbot.catchup.services;

import com.chatbot.catchup.domain.User;
import com.chatbot.catchup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String verify(User user) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());

        return "fail";
    }
}
