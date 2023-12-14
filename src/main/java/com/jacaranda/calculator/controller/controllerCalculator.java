package com.jacaranda.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jacaranda.calculator.model.Calculator;
import com.jacaranda.calculator.model.CalculatorVatios;


@Controller
public class controllerCalculator {
	
	@GetMapping("/calculator")
	public String calculator(Model model) {
		Calculator calculator = new Calculator();
		CalculatorVatios calculatorVatios = new CalculatorVatios();
		
		model.addAttribute("calc", calculator);
		model.addAttribute("calcV", calculatorVatios);
		return "calculator";
	}
	
	@GetMapping("/solve")
	public String solve(@Validated Model model, @ModelAttribute("calc") Calculator calculatorUser ,BindingResult bindingResult) throws Exception {
		Calculator calculator = new Calculator();
		model.addAttribute("calc", calculator);
		CalculatorVatios calculatorVatios = new CalculatorVatios();
		model.addAttribute("calcV", calculatorVatios);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("resultC", "Error al realizar la operación");
			return "calculator";
		}
		
		String resultC = null;
		try {
			resultC = calculatorUser.getResultString();			
		}catch (Exception e) {
			resultC=e.getMessage();
		}
		model.addAttribute("resultC", resultC);
				
		return "calculator";
	}
	
	@GetMapping("/solveVatios")
	public String solveVatios(@Validated Model model, @ModelAttribute("calcV") CalculatorVatios calulatorVatiosUser, BindingResult bindingResult) throws Exception {
		Calculator calculator = new Calculator();
		model.addAttribute("calc", calculator);
		CalculatorVatios calculatorVatios = new CalculatorVatios();
		model.addAttribute("calcV", calculatorVatios);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("resultV", "Error al realizar la operación");
			return "calculator";
		}
		
		String resultV = null;
		resultV = calulatorVatiosUser.getResult();			
		model.addAttribute("resultV", resultV);
		
		return "calculator";
	}
	
}
