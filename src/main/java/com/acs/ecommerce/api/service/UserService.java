package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.User;

import java.util.List;

public interface UserService {

    List<User> get();
    User getByUserType(String userType);

    User getByDocumentNumber(int DocumentNumber);

    User getByIdUser(String idUser);

    User create(User user);

    User update(String firstName, String LastName, String documentType, int documentNumber, User user);

    boolean delete(String idUser, String idShoppingCart);

}
