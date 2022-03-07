package com.example.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.dom.User;
import com.example.serv.loginService;

@Controller
public class userController {
    private loginService userService;
    
    
    @GetMapping("/login")
          
    public ModelAndView login() {
     ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }
 
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user ) {
    
     User oauthUser = userService.login(user.getUsername(), user.getPassword());
    
 
     System.out.print(oauthUser);
     if(Objects.nonNull(oauthUser))
     {
  
     return "redirect:/";
    
    
     } else {
     return "redirect:/login";
    
    
     }
    
}
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,Http11AprProtocol response)
    {
    
  
        return "redirect:/login";
    }
 
}
    
   
    
