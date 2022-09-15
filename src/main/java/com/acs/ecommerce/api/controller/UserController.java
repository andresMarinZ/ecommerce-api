package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.User;
import com.acs.ecommerce.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/security")
    public List<User> getsecurity() {

        ArrayList<User> list = new ArrayList<User>();
        User first = new User();
        first.setId(1);
        first.setUserType("vendedor");
        first.setFirstName("peranito");
        first.setLastName("perez");
        first.setDocumentType("cedula de ciudadania");
        first.setDocumentNumber(1234567899);
        first.setStoreName("ecommerce");

        list.add(first);
        return list;
    }

    //pendiente

    @PostMapping("/security")
    public String create( @RequestBody User request) {
        return String.format("POST Recibido: \nAId: %s," +
                        " \nusertype: %s," +
                        " \nfirstname: %s," +
                        " \nlastname: %s," +
                        " \ndocumentType: %s," +
                        " \ndocumentnumber: %s," +
                        " \nstorename: %s ",
                request.getId(),
                request.getUserType(),
                request.getFirstName(),
                request.getLastName(),
                request.getDocumentType(),
                request.getDocumentNumber(),
                request.getStoreName());
    }

    @PutMapping("/updatesecurity")
    public User update(@RequestBody User request){
        User response = request;

        return response;
    }

    @DeleteMapping("/deletesecurity")
    public String delete(@PathVariable int id){
        return "ok";
    }
}

