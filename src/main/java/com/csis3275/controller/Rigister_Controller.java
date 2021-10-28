package com.csis3275.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.DAOIm.RegisterDAoImpl;
import com.csis3275.model.registerData;


@Controller
public class Rigister_Controller {

	@Autowired
	RegisterDAoImpl registerDAoImpl;
	
	@RequestMapping("/")
	public String showRegister (@ModelAttribute("rigister") registerData createRegister ,Model model,HttpSession session) {
		
		
		
		//model.addAttribute("message", createRegister.getMessage());
			
			//model.addAttribute("username", session.getAttribute("username"));
		ArrayList<registerData> allUsers = registerDAoImpl.allRegisterUser();
		model.addAttribute("allUsers", allUsers);
		

		
		return "MainForm" ;
	}
	
//	@PostMapping("/registers/list")
//	public String allRegister (@ModelAttribute("rigister") registerData createRegister ,Model model,HttpSession session) {
//		
//		//getall register
//		ArrayList<registerData> allUsers = registerDAoImpl.allRegisterUser();
//		model.addAttribute("allUsers", allUsers);
//		
//		return "showList";
//	}
	
	
	
	
	
	
	@PostMapping("/registers/create")
	public String createRegister (@ModelAttribute("rigister") registerData createRegister ,Model model,HttpSession session) {
		
		registerDAoImpl.createRegisterUser(createRegister);
		
		//session.setAttribute("username","you connot lesve the user name empty");
		System.out.println(createRegister.getMessage());
		model.addAttribute("message", createRegister.toString());

		
		return "showList";
	}
	
	
	@PostMapping("/userInfo/edit")
	public String editUserInfo(@ModelAttribute("rigister") registerData rigister, Model model, HttpSession session) {
		//String userName = (String) session.getAttribute("userName");
		//String password = (String) session.getAttribute("password");

		//user.setUserName(userName);
		//user.setUserPassword(password);

		registerDAoImpl.updateRigister(rigister);

		model.addAttribute("rigister", rigister);

		return "redirect:/userInfo/edit";
	}
	
	
	
	
	
	
}
