package com.waheed.crudApp.restApp.controller;


import com.waheed.crudApp.restApp.Models.User;
import com.waheed.crudApp.restApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiConttroller {

    @Autowired
    private UserRepo userRepo ;


    @GetMapping(value = "/")
    public String getPage()
    {
        return "welcome !" ;
    }

    @GetMapping(value = "/users")
   public List<User> getUsers ()
   {

       return userRepo.findAll() ;
   }

    @PostMapping(value = "/save")
   public String saveUser (@RequestBody  User user)
   {
userRepo.save(user) ;
 return "Saved.." ;
   }

    @PostMapping(value = "/update/{id}")
    public String updateUser (@PathVariable long id , @RequestBody User user)
    {
       User updateUser = userRepo.findById(id).get();
       updateUser.setFirstName(user.getFirstName());
       updateUser.setLastName(user.getLastName());
       updateUser.setAge(user.getAge());
       updateUser.setOccupation(user.getOccupation());
userRepo.save(updateUser) ;
return "updated.." ;
    }


    @DeleteMapping(value = "/delet/{id}")
    public String deleteUser(@PathVariable long id )
    {

        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);

        return "user deleted with id " +id ;


    }
}
