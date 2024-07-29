package com.example.networkingcourse.service;

import com.example.networkingcourse.model.QUser;
import com.example.networkingcourse.model.User;
import com.example.networkingcourse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> listUsers(Pageable pageable, String searchName)
    {

//       var specification =  new Specification<User>(){
//            @Override
//            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)
//            {
//                return criteriaBuilder.like(root.get("name"), searchName);
//            }
//        };

        if (searchName != null)
        {
            var predicate = QUser.user.name.like(searchName);

            return IterableUtils.toList(userRepository.findAll(predicate));
        }
//        var totalPages = page.getTotalPages();

        return userRepository.findAll(pageable).getContent();
    }
}
