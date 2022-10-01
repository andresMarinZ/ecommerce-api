package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.User;
import com.acs.ecommerce.api.model.UserUpdate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImp implements UserService{

    public List<User> get() {
        return users;
    }



    private static List<User> users = new ArrayList<>();


    //
    public UserServiceImp(List<User> usersInjected) {
        users = usersInjected;
    }

    //For get an user type
    public User getByUserType(String userType) {
        Optional<User> optionalUser = users.stream()
                .filter(users -> users.getUserType().equals(userType))
                .findFirst();

        return optionalUser.orElse(null);
    }

    public User getByIdUser(String idUser){
        Optional<User> optionalUser = users.stream()
                .filter(users -> users.getId().equals(idUser))
                .findFirst();

        return optionalUser.orElse(null);
    }

    //When we need to get a document number
    public User getByDocumentNumber(int DocumentNumber) {
        Optional<User> optionalUser = users.stream()
                .filter(users -> users.getDocumentNumber() == DocumentNumber)
                .findFirst();

        return optionalUser.orElse(null);
    }

    //Create an user
    public User create(User user) {
        user.setId(UUID.randomUUID().toString());
        users.add(user);

        return user;
    }

    public User update(String id, UserUpdate user) {

        User oldUser = getByDocumentNumber(user.getDocumentNumber());

        if(Objects.isNull(oldUser) && id != oldUser.getId()){
            return null;
        }

        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setDocumentType(user.getDocumentType());
        oldUser.setDocumentNumber(user.getDocumentNumber());

        return  oldUser;

    }

    public boolean delete(String idUser) {
        User user = getByIdUser(idUser);

        return Objects.isNull(user);

    }

}
