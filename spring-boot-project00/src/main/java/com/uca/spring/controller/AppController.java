package com.uca.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
@RequestMapping("/")
public class AppController {
	
  //Primera ruta (endpoint inicial)
  @GetMapping("/")
  public String getForm() {
	  
	  
    return "login.jsp";
  }
   
  @PostMapping("/loginn")   
  public String login(@RequestParam("CARNET") String CARNET,
		  @RequestParam("PASSWORD") String PASSWORD, 
		  ModelMap modelMap){ 
	  
		  return "login.jsp";
				  
  } 
  
   
  
}

    
	  
   
    
  
  

