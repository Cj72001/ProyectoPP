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
	  
	//Validacion para campos
	  if(CARNET.isEmpty() || PASSWORD.isEmpty()) {
		  modelMap.put("errorL","No deje espacios en blanco");
		  return "login.jsp";
	  }
	  else {
		
		  //Si no hay usuarios
		  //Vamos a evaluar si el estudiante que desea logearse existe:
		  //return "pagina principal"  -> si existe el usuario y se autentica e identifica
		  return "login.jsp";
	  }		  
  }
  
  @PostMapping("/registrarEstudiante")
  public String registrarEstudiante(@RequestParam("nombreRe") String nombreRe,
		  @RequestParam("carnetRe") String carnetRe, 
		  @RequestParam("passwordRe") String passwordRe,
		  @RequestParam("passwordRe2") String passwordRe2,
		  ModelMap modelMap){ 
	  
		  return "regUpdateSuccess.jsp";
	  }
}

    
	  
   
    
  
  

