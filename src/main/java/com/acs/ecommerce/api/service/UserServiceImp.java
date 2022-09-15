package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp {

    private static final List<User> users = new ArrayList<>();

    public List<User> get() { return users; }









}
