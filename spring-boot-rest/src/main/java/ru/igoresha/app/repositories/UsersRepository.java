package ru.igoresha.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.igoresha.app.models.User;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAllByOrderByAge();
    List<User> findAllByOrderByAgeDesc();
    List<User> findAllByOrderById();
    List<User> findAllByOrderByIdDesc();

    List<User> findAllByFirstNameContainsIgnoreCaseOrLastNameContainsIgnoreCase(String query1, String query2);
    List<User> findUserByFirstNameContainsIgnoreCase(String firstName);
}
