package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.User;

import java.util.List;

public interface UserService {

    List<User> get();

    User readByUserType(String userType);

    User getByDocumentNumber(int DocumentNumber);


    User create(int id);

    User update(String firstName, String LastName, String documentType, int documentNumber);

    boolean delete(int idUser);

}
