package ru.yandex.practicum.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import ru.yandex.practicum.model.Language;
import ru.yandex.practicum.model.UserModel;


public class UserSpecifications {

  private UserSpecifications() {}

  public static Specification<UserModel> hasLanguageEqual(Language language) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("language"), language);
  }

  public static Specification<UserModel> hasAgeGreaterOrEqual(Integer age) {
    return ((root, query, criteriaBuilder) ->
        criteriaBuilder.greaterThanOrEqualTo(root.get("age"), age));
  }

  @SuppressWarnings("all")
  public static Specification<UserModel> hasLoginLike(String login) {
    return new Specification<UserModel>() {
      @Override
      public Predicate toPredicate(
          Root<UserModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("login"), "%" + login + "%");
      }
    };
  }
}
