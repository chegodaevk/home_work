package org.example.app.services;

import java.util.HashMap;
import org.example.web.dto.LoginForm;

public class LoginRepository {
	
	HashMap<String, String> accountList = new HashMap<>();
	
	public void addAccount(LoginForm loginForm) {
		if(!loginForm.getUsername().equals("") && !loginForm.getPassword().equals("")) {		
			accountList.put(loginForm.getUsername(), loginForm.getPassword());
		}
	}
		
	public boolean authorization(LoginForm loginForm) {
		String key = loginForm.getUsername();
		if (accountList.containsKey(key) && accountList.get(key).equals(loginForm.getPassword())) {
				return true;
		}
		return false;
	}	

}
