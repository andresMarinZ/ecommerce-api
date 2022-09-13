package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.security;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class securityController {
    private final static List<security> list = new ArrayList<>();

    @GetMapping("/security")
    public List<security> getsecurity() {

        ArrayList<security> list = new ArrayList<security>();
        security first = new security();
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

    @PostMapping("/security")
    public String create( @RequestBody security request) {
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
    public security update(@RequestBody security request){
        security response = request;

        return response;
    }

    @DeleteMapping("/deletesecurity")
    public String delete(@PathVariable int id){
        return "ok";
    }
}

