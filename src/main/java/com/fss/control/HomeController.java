package com.fss.control;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fss.model.Employee;
import com.fss.model.Login;
import com.fss.service.AddService;
import com.fss.service.DelService;
import com.fss.service.LoginService;
import com.fss.service.RegisterService;
import com.fss.service.UpdateService;

@Controller
public class HomeController {
	
	@Autowired
	Login login;
	
	@Autowired
	Employee emp;

	@Autowired
	LoginService loginSer;

	@Autowired
	RegisterService regSer;
	
	@Autowired
	AddService addSer;
	
	@Autowired
	DelService delSer;
	
	@Autowired
	UpdateService updateSer;
	
	
//	Login Controller	

	@PostMapping(value = "/login")
	public String login(@RequestParam("email") String email, @RequestParam("pwd") String pwd, Model model) throws SQLException {

		login.setEmail(email);
		login.setPassword(pwd);
		
		String msg = "";

		boolean b = loginSer.login(login);
		if (b) {
			return "home";
		} else {
			msg = "Invalid user or password.. Try again!!";
		}
		
		model.addAttribute("msg", msg);
		return "index";
	}
	
//	Register Controller
	
	@GetMapping("/register")
	public String showRegister() {
		return "register";
	}
	
	@PostMapping(value = "/doRegister")
	public String register(@RequestParam("email") String email, @RequestParam("pwd1") String pas1, @RequestParam("pwd2") String pas2, Model model) {

		boolean b = false;
		String msg = "";

		if (pas1.equals(pas2)) {

			login.setEmail(email);
			login.setPassword(pas1);

			b = regSer.register(login);

			if (!b)
				msg = "Server Error!! Try again";

		} else {
			msg = "Passwords not matched.. Try again!!";
		}

		if (b) {
			msg = "User registered successfully.. Login Now!";
			model.addAttribute("msg", msg);
			return "index";
		}
		
		model.addAttribute("msg", msg);
		return "register";
	}

//	Add Employee Controller
	
	@GetMapping("/add")
	public String addUser(Model model) {
		
		model.addAttribute("emp", new Employee());
		
		return "add";
	}
	
	
	@PostMapping(value = "/addUser")
	public String AddUser(@ModelAttribute("emp") Employee emp, Model model) {
		
		boolean b = false;
		String msg = "";

		b = addSer.addInFile(emp);
		
		if(b)
			msg = "Record added successfully!!";
		else
			msg = "Some error occured!!";
		
		
		model.addAttribute("msg", msg);
		return "home";
	}	
	
//	Show details Controller
	
	@GetMapping("/showDetails")
	public String showUser() {
		return "showDetails";
	}
	
	
//	Edit Controller
	
	@PostMapping(value = "/showUpdateEmpDetails")
	public String addUser(@RequestParam("sNo") String sNo, Model model) {
	
		emp = updateSer.getUserWithSNo(sNo);
		
		model.addAttribute("emp", emp);
		return "updateDetails";
	}
	
	@PostMapping(value = "/updateEmpDetails")
	public String updateUser(@ModelAttribute("emp") Employee emp, Model model) {
		
		updateSer.updateUser(emp);
		return "showDetails";
	}
	
//	Delete Controller
	
	@PostMapping(value = "/deleteEmpDetails")
	public String delUser(@RequestParam("sNo") String sNo, Model model) {
	
		delSer.delLineWithSNo(sNo);
		return "showDetails";
	}
}
