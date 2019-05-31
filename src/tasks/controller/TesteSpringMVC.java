package tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TesteSpringMVC {
	
	@RequestMapping("/testespringmvc")
	public String execute() {
		System.out.println("Testando o Framework Spring MVC");
		return "testando";
	}
}