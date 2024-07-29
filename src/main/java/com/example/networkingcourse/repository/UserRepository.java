package com.example.networkingcourse.repository;

import com.example.networkingcourse.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
