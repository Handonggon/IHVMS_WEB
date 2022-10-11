package kr.or.i815.ihvms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.i815.ihvms.dto.UserDto;
import kr.or.i815.ihvms.dto.UserSearchDto;
import kr.or.i815.ihvms.service.UserService;

@Controller
@RequestMapping("/user")
//@RestController
//@RequiredArgsConstructor
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    UserService userService;

	@GetMapping({"/list"})
	public String list(Model model) {
		return "/user/list";
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<UserDto>> find(@RequestParam(required=false) String userId) {
		return ResponseEntity.ok(userService.findByUserIdLike(userId));
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
		return ResponseEntity.ok(userService.save(userDto));
	}

	@PutMapping
	@ResponseBody
	public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
		return ResponseEntity.ok(userService.save(userDto));
	}

	@DeleteMapping
	@ResponseBody
	public ResponseEntity<UserDto> delete(@RequestBody UserSearchDto userSearchDto) {
		return ResponseEntity.ok(userService.delete(userSearchDto));
	}
}