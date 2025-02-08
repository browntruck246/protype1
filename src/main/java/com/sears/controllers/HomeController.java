package com.sears.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sears.services.CustomerDOA;

import org.springframework.ui.Model;

@Controller
public class HomeController {
	
	//http://localhost:8080/1
    @GetMapping("/{id}")
    public String index(@PathVariable("id") int id,Model model) {
    	
    	CustomerDOA customer = new  CustomerDOA();
    	
    	System.out.println("Customer Id:" + id);
    	
    	
    	String firstPerson = customer.getFullName(id);
    	
        model.addAttribute("message", "Hello, " + firstPerson + "!");
        return "index";
    }

}
