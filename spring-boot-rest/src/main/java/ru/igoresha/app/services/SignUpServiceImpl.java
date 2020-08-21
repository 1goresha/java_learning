package ru.igoresha.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.igoresha.app.forms.SignUpForm;
import ru.igoresha.app.models.Role;
import ru.igoresha.app.models.User;
import ru.igoresha.app.repositories.UsersRepository;


@Service
public class SignUpServiceImpl implements SignUpService {


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpForm signUpForm) {
        User user = User.builder()
                .firstName(signUpForm.getFirstName())
                .lastName(signUpForm.getLastName())
                .login(signUpForm.getLogin().toLowerCase())
                .password(passwordEncoder.encode(signUpForm.getPassword()))
                .age(signUpForm.getAge())
                .role(Role.USER)
                .build();

        usersRepository.save(user);
    }
}
