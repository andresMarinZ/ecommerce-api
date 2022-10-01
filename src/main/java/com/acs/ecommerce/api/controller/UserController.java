package com.acs.ecommerce.api.controller;

import com.acs.ecommerce.api.enums.UserTypeEnum;
import com.acs.ecommerce.api.model.User;
import com.acs.ecommerce.api.model.UserUpdate;
import com.acs.ecommerce.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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


    //- The api should allow creating a user.
    //- Only an administrator user can create a user of type buyer and seller.
    @PostMapping("users")
    public ResponseEntity<User> create(@RequestBody User user) {

        if (user.getCreatedUserType().equals(String.valueOf(UserTypeEnum.ADMIN))){
            return ResponseEntity.ok(userService.create(user));
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //- Names, surnames, document type and document number can be edited.
    @PutMapping("users")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody UserUpdate user) {

        User userUpdated = userService.update(id, user);

        return Objects.isNull(userUpdated) ? ResponseEntity.notFound().build() : ResponseEntity.ok(userUpdated);
    }

    //- A user will only be deleted if and only if he has no sales or products in an active cart.
    @DeleteMapping("users/{idUser}")
    public ResponseEntity delete(@PathVariable String idUser, String idShoppingCart) {
        boolean deleted = false;
        if (idShoppingCart.equals(' ')){
            deleted = userService.delete(idUser, idShoppingCart);
        }
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}

