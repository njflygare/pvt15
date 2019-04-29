package com.PVT10.ArtQuestAPI.DAO;

import com.PVT10.ArtQuestAPI.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
//DENNA KLASS ÄR DET SOM KOMMER INEHÅLLA MASSA SQL-SATSER TROR JAG
@Repository("DAO")
public class UserDataAccessService implements UserDAO {

    private List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getUserName()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return DB;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteUserById(UUID id) {
        Optional<User> userDelete = selectUserById(id);
        if (userDelete.isEmpty()) {
            return 0;
        }
        DB.remove(userDelete.get());
        return 1;
    }

    @Override
    public int updateUserById(UUID id, User update) {
        return selectUserById(id).map(user -> {
            int indexOfUserToUpdate = DB.indexOf(user);
            if (indexOfUserToUpdate >= 0) {
                DB.set(indexOfUserToUpdate, new User(id, update.getUserName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
