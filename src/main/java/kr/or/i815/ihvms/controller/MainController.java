package kr.or.i815.ihvms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.i815.ihvms.service.CommonCodeService;

@Controller
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    CommonCodeService commonCodeService;

	@GetMapping({"/"})
	public String index(Model model) {
		model.addAttribute("commonCodeList", commonCodeService.findAll());
		return "/index";
	}
}