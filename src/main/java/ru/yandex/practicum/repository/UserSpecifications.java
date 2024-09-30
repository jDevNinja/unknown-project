package ru.yandex.practicum.repository;

import org.springframework.data.jpa.domain.Specification;
import ru.yandex.practicum.model.Group;
import ru.yandex.practicum.model.UserModel;

public class UserSpecifications {

  public static Specification<UserModel> hasGroup(Group group) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("appGroup"), group);
  }

  public static Specification hasAgeGreater(Integer age) {
    return ((root, query, criteriaBuilder) ->
        criteriaBuilder.lessThanOrEqualTo(root.get("age"), age));
  }
}
