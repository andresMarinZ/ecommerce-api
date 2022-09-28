package com.acs.ecommerce.api.service;

import com.acs.ecommerce.api.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SpringExtension.class)
class UserServiceImpTest {
    private final List<User> users = new ArrayList<>();
    private final UserService userService;

    User user;

    public UserServiceImpTest() {
        this.userService = new UserServiceImp(users);
    }

    @BeforeEach
    public void initializeUserList(){

        users.clear();
    }

    @Test
    public void getEmptyUsersTest() {
        List<User> usersResult = userService.get();
        Assertions.assertTrue(usersResult.isEmpty());
    }

    @Test
    public void createUserTest() {
        User userCreated = userService.create(getNewUser());
        if (userCreated.getUserType().equals("ADMIN")){

        Assertions.assertAll(
                () -> Assertions.assertEquals("firstname", userCreated.getFirstName()),
                () -> Assertions.assertEquals("lastname", userCreated.getLastName()),
                () -> Assertions.assertEquals("ADMIN", userCreated.getUserType()),
                () -> Assertions.assertEquals("CC", userCreated.getDocumentType()),
                () -> Assertions.assertEquals("STORE", userCreated.getStoreName()),
                () -> Assertions.assertEquals(4525522, userCreated.getDocumentNumber()),
                () -> Assertions.assertTrue(Objects.nonNull(userCreated.getId()))
        );}
    }

    @Test
    public void updateUserSuccessfullyTest() {
        User userCreated = userService.create(getNewUser());
        User userToUpdate = getNewUser();
        userToUpdate.setFirstName("editFirstname");
        userToUpdate.setLastName("edit");
        userToUpdate.setDocumentType("CC");
        userToUpdate.setDocumentNumber(998765432);

        User userUpdated = userService.update(userCreated.getFirstName(), userCreated.getLastName(),
                userCreated.getDocumentType(), userCreated.getDocumentNumber(), userToUpdate);

        Assertions.assertEquals("editFirstname", userUpdated.getFirstName());
        Assertions.assertEquals("edit", userUpdated.getLastName());
        Assertions.assertEquals("CC", userUpdated.getDocumentType());
        Assertions.assertEquals(998765432, userUpdated.getDocumentNumber());
    }

    public void updateUserUnsuccessfullyTest() {

    }

    @Test
    void deleteTest(){
        users.add(user);
        boolean result = userService.delete("1", " ");
        assertFalse(result);

    }


    private User getNewUser() {
        User user = new User();
        user.setId("1");
        user.setUserType("comprador");
        user.setFirstName("peranito");
        user.setLastName("sulanito");
        user.setDocumentType("cedula ciudadania");
        user.setDocumentNumber(1234567899);
        user.setStoreName("store");

        return user;
    }

}