package kr.or.i815.ihvms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping({"/"})
	public String index(Model model) {
		
		return "/index";
	}
}