package com.example.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dom.User;

@Repository
public interface loginRepository extends JpaRepository<User, Long>{
	User findByUsernameAndPassword(String username, String password);
	 
	}