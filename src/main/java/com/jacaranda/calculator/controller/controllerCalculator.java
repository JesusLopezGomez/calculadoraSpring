package com.jacaranda.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jacaranda.calculator.model.Calculator;

@Controller
public class controllerCalculator {
	
	@GetMapping("/calculator")
	public String calculator(Model model) {
		Calculator calculator = new Calculator();
		
		model.addAttribute("calc", calculator);
		return "calculator";
	}
	
	@GetMapping("/solve")
	public String solve(Model model, @ModelAttribute("calc") Calculator calculatorUser) throws Exception {
		Calculator calculator = new Calculator();
		model.addAttribute("calc", calculator);
		String result = null;
		try {
			result = String.format("Operación anterior: %s %s %s = %s", 
					calculatorUser.getNumber1(),calculatorUser.getOperator(),calculatorUser.getNumber2(),calculatorUser.getResult());			
		}catch (Exception e) {
			result=e.getMessage();
		}
		model.addAttribute("result", result);
		return "calculator";
	}
}
