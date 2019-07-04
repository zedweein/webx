package javax.webx.action;

import javax.webx.pages.LoginPage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginAction {

	@RequestMapping("/auth/login")
	public String login() {
		return new LoginPage().index();
	}
}
