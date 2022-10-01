package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.User;
import com.acs.ecommerce.api.model.UserUpdate;

import java.util.List;

public interface UserService {

    List<User> get();
    User getByUserType(String userType);


    User getByDocumentNumber(int DocumentNumber);

    User getByIdUser(String idUser);

    User create(User user);

    User update(String id, UserUpdate user);

    boolean delete(String idUser);



}
