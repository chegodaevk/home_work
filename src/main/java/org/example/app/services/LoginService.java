package org.example.app.services;

import org.example.web.dto.LoginForm;
import org.springframework.stereotype.Service;

@Service
public class LoginService {	
	
	LoginRepository loginRepository = new LoginRepository();
	
	public boolean authentificate(LoginForm loginForm) {
		return loginRepository.authorization(loginForm);
	}
	
	public void saveAccoun(LoginForm loginForm) {
		loginRepository.addAccount(loginForm);		
	}
		
}
