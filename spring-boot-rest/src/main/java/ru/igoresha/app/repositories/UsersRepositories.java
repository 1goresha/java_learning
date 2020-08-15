package ru.igoresha.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.igoresha.app.models.User;

import java.util.List;

public interface UsersRepositories extends JpaRepository<User, Long> {
}
