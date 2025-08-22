package dev.java10x.service;

import dev.java10x.domain.Users;
import dev.java10x.exceptions.UserNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.findById;

@ApplicationScoped
public class UserService {

    public Users createUser(Users users) {
        Users.persist(users);
        return users;
    }

    public List<Users> findAllUsers(Integer page, Integer pageSize) {
        return Users.findAll()
                .page(page, pageSize)
                .list();
    }

    public Users findUserById(UUID userId) {
        return (Users) Users.findByIdOptional(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    public Users updateUser(UUID userId, Users users) {
        var user = findUserById(userId);

        user.username = users.username;
        user.email = users.email;

        Users.persist(user);
        return user;


    }
}
