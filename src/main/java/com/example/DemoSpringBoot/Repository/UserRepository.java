package com.example.DemoSpringBoot.Repository;

import com.example.DemoSpringBoot.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel,Integer> {
    List<UserModel> findByTeam(String team);
}
