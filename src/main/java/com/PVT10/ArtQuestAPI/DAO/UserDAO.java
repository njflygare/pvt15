package com.PVT10.ArtQuestAPI.DAO;

import com.PVT10.ArtQuestAPI.Model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Interface for User class database access
public interface UserDAO {

    int insertUser(UUID id, User user);

    default int insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAllUsers();

    Optional<User> selectUserById(UUID id);

    int deleteUserById(UUID id);

    int updateUserById(UUID id, User user);



}
