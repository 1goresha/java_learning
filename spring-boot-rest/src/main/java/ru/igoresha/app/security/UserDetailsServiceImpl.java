package ru.igoresha.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.igoresha.app.models.User;
import ru.igoresha.app.repositories.UsersRepository;

import java.util.Optional;


@Service(value = "myUserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> userCandidate = usersRepository.findFirstByLogin(login);
        if (userCandidate.isPresent()){
            return new UserDetailsImpl(userCandidate.get());
        }
        throw new UsernameNotFoundException("логин " + login + " не найден");
    }
}
