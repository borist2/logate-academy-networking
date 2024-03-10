package com.example.networkingcourse.repository;

import com.example.networkingcourse.model.User;
import com.example.networkingcourse.model.projections.UserIdNameProjection;
import com.example.networkingcourse.model.projections.UserNameEmailConcatenatedProjection;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.QuerydslJpaPredicateExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<User, Integer>, QuerydslPredicateExecutor<User>
{
    List<User> findAll();

    Page<User> findAll(Pageable pageable);


    <I> List<I> findAllById(Integer id, Class<I> projectedBy);

//    List<User> findAll(Predicate predicate);

    User save(User user);

    Optional<User> findById(Integer id);

    void deleteById(Integer id);

    List<User> findAllByIdIsGreaterThanEqualAndIdIsLessThan (Integer from, Integer to);

    boolean existsById(Integer id);
}
