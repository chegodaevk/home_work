package org.example.web.controllers;

//import org.apache.log4j.Logger;
import org.example.app.services.LoginService;
import org.example.web.dto.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	// использование логированиея
	//private Logger logger = Logger.getLogger(LoginController.class);
	private LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping
	public String login(Model model) {
		// вывод в консоли информации
		//logger.info("GET /login returns login_page.html");
		model.addAttribute("loginForm", new LoginForm());
		return "login_page";
	}

	@PostMapping("/auth")
	public String authenticate(LoginForm loginForm) {
		if (loginService.authentificate(loginForm)) {
			return "redirect:/books/shelf";
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/new")
	public String newLogin(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "new_login_page";
	}
	
	@PostMapping("/new/save")
	public String newAccount (LoginForm loginForm) {
		loginService.saveAccoun(loginForm);
		return "redirect:/login";
	}	

}
