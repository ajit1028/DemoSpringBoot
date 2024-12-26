package com.example.DemoSpringBoot.Service;

import com.example.DemoSpringBoot.Models.UserModel;
import com.example.DemoSpringBoot.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserModel addUser(UserModel userModel){
       UserModel obj =  userRepository.save(userModel);
       return obj;
    }

    public List<UserModel> saveUsers(List<UserModel> userModels){
          List<UserModel> listObj =userRepository.saveAll(userModels);
          return listObj;

    }

    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    public UserModel getById(int _id){
        UserModel userDetails = userRepository.findById(_id).get();
        return userDetails;

    }

    public String deleteById(int _id){
        userRepository.deleteById(_id);
        return "User Deteleted Successfully.🚀";
    }

    public UserModel updateById(@PathVariable int _id, @RequestBody UserModel reqUser){
        UserModel origionalUser = getById(_id);
        origionalUser = updateUserFields(reqUser,origionalUser);
        return userRepository.save(origionalUser);
    }

    public UserModel updateUserFields(UserModel reqUser, UserModel origionalUser){
      display(reqUser);
      display(origionalUser);
      if(reqUser.getUserName()!=null){
          origionalUser.setUserName(reqUser.getUserName());
      }
      if(reqUser.getPassword()!=null){
          origionalUser.setPassword(reqUser.getPassword());
      }
      if(reqUser.getPhoneNumber()!=0){
          origionalUser.setPhoneNumber(reqUser.getPhoneNumber());
      }
        if(reqUser.getTeam()!=null){
            origionalUser.setTeam(reqUser.getTeam());
        }

      return origionalUser;
    }

    public List<UserModel> updateUsers(List<UserModel> users){
        List<UserModel> updatedUserList  =new ArrayList<>();
        for(UserModel reqUser: users) {
            UserModel updatedUser = updateById(reqUser.getUserId(),reqUser);
            //display(updatedUser);
            updatedUserList.add(updatedUser);

        }
        return updatedUserList;
    }

    public List<UserModel> findUsersByTeam(String team){
        return userRepository.findByTeam(team);
    }

    public void display(UserModel user){
        System.out.println(user.getUserId()+" "+user.getUserName()+" "+user.getPassword()+" "+user.getPhoneNumber());
    }
}
