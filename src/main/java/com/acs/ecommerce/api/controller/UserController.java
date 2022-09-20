package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.model.User;
import com.acs.ecommerce.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //When we need an userTyper and DocumentNumber
    @GetMapping("users/{userType},{documentNumber}" )
    public ResponseEntity<User> getUser(@PathVariable String userType, int documentNumber, @RequestBody User user) {
        //Consulto por tipo de usuario, PENDIENTE por tipo de documento
        User myUsers = userService.getByUserType(userType);

        return Objects.isNull(myUsers) ? ResponseEntity.notFound().build() : ResponseEntity.ok(myUsers);
    }

    //- La api deberá permitir crear un usuario.
    //- Solamente un usuario administrador podrá crear un usuario de tipo comprador y vendedor.
    @PostMapping("users")
    public ResponseEntity<User> create(@RequestBody User user) {

        if (user.getUserType().equals("Admin")){
            return ResponseEntity.ok(userService.create(user));
        }
        return null;
    }

    //- Se podrá editar los nombres, apellidos, tipo de documento y número de documento.
    @PutMapping("users/{firstName},{LastName},{documentType}, {documentNumber}")
    public ResponseEntity<User> update(@PathVariable String firstName, String LastName, String documentType, int documentNumber, @RequestBody User user) {
        User userUpdated = userService.update(firstName, LastName, documentType, documentNumber, user);

        return Objects.isNull(userUpdated) ? ResponseEntity.notFound().build() : ResponseEntity.ok(userUpdated);
    }

    //- Solo se eliminará un usuario sí y solo sí este no tiene ventas o productos en un carrito activo.
    //idShoppingCart ->>>> variable de carrito (variable identificador)
    @DeleteMapping("users/{idUser}")
    public ResponseEntity delete(@PathVariable String idUser, String idShoppingCart) {
        boolean deleted = false;
        if (idShoppingCart.equals(' ')){
            deleted = userService.delete(idUser, idShoppingCart);
        }
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}

