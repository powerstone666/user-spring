package com.example.springcrud.repo;

import com.example.springcrud.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<user,Long> {


}
