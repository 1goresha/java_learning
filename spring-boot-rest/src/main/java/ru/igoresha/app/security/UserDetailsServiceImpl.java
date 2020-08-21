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
        Optional<User> userCandidate = usersRepository.findFirstByLoginIgnoreCase(login);
        if (userCandidate.isPresent()){
            if (userCandidate.get().getPasswordHash().equals("$2a$08$P7MohxFaUTijgOhJeH3/5.QLldXO0aoiqUk3suJ/LsGEc8FB1K/o6")){
                System.out.println("есть сходство");
            }
            else
            {
                System.out.println("нет сходства");
            }
            System.out.println(userCandidate.get().getPasswordHash());
            return new UserDetailsImpl(userCandidate.get());
        }
        System.out.println(login + "не найден");
        throw new UsernameNotFoundException("логин " + login + " не найден");
    }
}
