package com.example.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.dom.User;
import com.example.rep.loginRepository;

@Controller
public class loginService {
	@Autowired
	private loginRepository repo;
	  
	  public User login(String username, String password) {
	  User user = repo.findByUsernameAndPassword(username, password);
	   return user;
	  }
}
