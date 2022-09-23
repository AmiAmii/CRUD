package com.rest.API.CRUD.Controller;

import com.rest.API.CRUD.Models.Users;
import com.rest.API.CRUD.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/demo")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping(value = "/user")
    public List<Users> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping(value = "/one/{id}")
    public Users getSingle(@PathVariable long id){
        return userRepo.findById(id).get();
    }


    @PostMapping(value = "/save")
    public String saveUser(@RequestBody Users users) {
        userRepo.save(users);
        return "Saved..";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody Users user) {
        Users updateUser = userRepo.findById(id).get();
        updateUser.setId(user.getId());
        updateUser.setAge(user.getAge());
        updateUser.setDpt(user.getDpt());
        updateUser.setExp(user.getExp());
        updateUser.setName(user.getName());
        userRepo.save(updateUser);
        return "Updated...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        Users deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Delete user with Id: " + id;
    }


}
