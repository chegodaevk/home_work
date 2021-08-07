package org.example.app.services;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import org.example.web.dto.LoginForm;

public class LoginRepository {
	
	//List<LoginForm> accountList = new ArrayList<>();
	HashMap<String, String> accountList = new HashMap<>();
	
	public void addAccount(LoginForm loginForm) {
		if(!loginForm.getUsername().equals("") && !loginForm.getPassword().equals("")) {						
			//accountList.add(loginForm);		
			accountList.put(loginForm.getUsername(), loginForm.getPassword());
		}
	}
	
//	public boolean authorization(LoginForm loginForm) {
//		for (LoginForm lf : accountList) {
//			if (lf.getUsername().equals(loginForm.getUsername()) && lf.getPassword().equals(loginForm.getPassword())) {
//				return true;
//			}
//		}
//		return false;
//	}	
	
	public boolean authorization(LoginForm loginForm) {
		String key = loginForm.getUsername();
		if (accountList.containsKey(key) && accountList.get(key).equals(loginForm.getPassword())) {
				return true;
		}
		return false;
	}	

}
