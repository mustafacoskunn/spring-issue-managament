package com.example.issuemanagement.repository;


import com.example.issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> { //bir çok sorogu yapabiliyoruz//sayfalama yapabilirruz

    
}
