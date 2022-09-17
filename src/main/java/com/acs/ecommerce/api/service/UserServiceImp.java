package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImp implements UserService{

    private static List<User> users = new ArrayList<>();
    //Inyección?
    public UserServiceImp(List<User> usersInjected) {
        users = usersInjected;
    }

    //Para obtener el tipo de usuario
    public User getByUserType(String userType) {
        Optional<User> optionalUser = users.stream()
                .filter(users -> users.getUserType().equals(userType))
                .findFirst();

        return optionalUser.orElse(null);
    }

    //Para obtener el número de documento
    public User getByDocumentNumber(int DocumentNumber) {
        Optional<User> optionalUser = users.stream()
                .filter(users -> users.getDocumentNumber() == DocumentNumber)
                .findFirst();

        return optionalUser.orElse(null);
    }

    //CREAR USUARIO A PARTIR DE UN ID
    public User create(User user) {
        user.setId(UUID.randomUUID().toString());
        users.add(user);

        return user;
    }

    //PENDIENTE
    public User update(String firstName, String LastName, String documentType, int documentNumber)
    {
        return null;
    }

    //PENDIENTE
    public boolean delete(int idUser) {

        return false;
    }
}
