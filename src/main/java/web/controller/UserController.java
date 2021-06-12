package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String printAllUsers(ModelMap model) {

		model.addAttribute("users", userService.getAllUsers());
		return "allusers";
	}

	@DeleteMapping(value = "/allusers/{id}")
	public String delUser(@PathVariable("id") int id){
		userService.removeUserById(id);
		return "redirect:/";
	}

	@GetMapping(value = "adduser")
	public String addUser(ModelMap model){
		model.addAttribute("user", new User());
		return "adduser";
	}

	@PostMapping(value = "allusers")
	public String endAddUser(@ModelAttribute("user") User user){
		userService.userAdd(user);
		return "redirect:/";
	}

	@GetMapping(value = "/edituser/{id}")
	public String editUser(@PathVariable("id") int id, ModelMap model){
		model.addAttribute("user", userService.getUserById(id));
		return "edituser";
	}

	@PatchMapping(value = "/allusers/{id}")
	public String endEditUser(@ModelAttribute("user") User user) {
		userService.updUser(user);
		return "redirect:/";
	}
}