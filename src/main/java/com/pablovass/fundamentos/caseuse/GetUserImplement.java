package com.pablovass.fundamentos.caseuse;

import com.pablovass.fundamentos.entity.User;

import java.util.List;

public class GetUserImplement implements  GetUser{
    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
