package com.stock.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.Entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

         User findByEmail(String email);
}
