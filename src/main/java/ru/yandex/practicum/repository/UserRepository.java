package ru.yandex.practicum.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.model.UserModel;

@Repository
public interface UserRepository
    extends JpaRepository<UserModel, Integer>, JpaSpecificationExecutor<UserModel> {
  Optional<UserModel> findOneByLogin(String login);
}
