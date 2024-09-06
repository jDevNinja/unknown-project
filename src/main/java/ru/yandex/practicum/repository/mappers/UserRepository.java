package ru.yandex.practicum.repository.mappers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.model.UserModel;

import java.util.Optional;

@Component
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
  Optional<UserModel> findOneByLogin(String login);
}
