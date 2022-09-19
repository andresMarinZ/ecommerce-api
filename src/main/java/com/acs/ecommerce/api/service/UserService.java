package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.User;

import java.util.List;

public interface UserService {

    List<User> get();
    User getByUserType(String userType);

    User getByDocumentNumber(int DocumentNumber);


    User create(User user);

    User update(String firstName, String LastName, String documentType, int documentNumber, User user);

    boolean delete(int idUser);

}
