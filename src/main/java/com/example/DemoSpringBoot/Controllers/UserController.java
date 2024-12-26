package com.example.DemoSpringBoot.Controllers;

import com.example.DemoSpringBoot.Models.UserModel;
import com.example.DemoSpringBoot.Repository.UserRepository;
import com.example.DemoSpringBoot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserModel addUser(@RequestBody UserModel userModel){
       return userService.addUser(userModel);
    }

    @PostMapping("/saveUsers")
    public List<UserModel> saveUsers(@RequestBody List<UserModel> userModels){
       return userService.saveUsers(userModels);
    }

    @GetMapping("/getAllUsers")
    public List<UserModel> getAllUsers(){
        return  userService.getAllUsers();
    }


    @GetMapping("/getById/{_id}")
    public UserModel getById(@PathVariable int _id ){
        return userService.getById(_id);
    }


    @DeleteMapping("/deleteById/{_id}")
    public String deleteById(@PathVariable int _id){
       return userService.deleteById(_id);
    }

    @PutMapping("/updateById/{_id}")
    public UserModel updateBYId(@PathVariable int _id,@RequestBody UserModel reqUser){
        return userService.updateById(_id,reqUser);
    }

    @PutMapping("/updateUsers")
    public List<UserModel> updateUsers(@RequestBody List<UserModel> users){
        return userService.updateUsers(users);
    }

    @GetMapping("/findByTeam")
    public List<UserModel> findByTeam(@RequestParam String team){
        return userService.findUsersByTeam(team);
    }
}
