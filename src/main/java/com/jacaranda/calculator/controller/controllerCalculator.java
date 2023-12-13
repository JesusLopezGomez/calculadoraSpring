package com.jacaranda.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping("/calculatorVatios")
	public String calculatorVatios(Model model) {
		CalculatorVatios calculatorVatios = new CalculatorVatios();
		
		model.addAttribute("calcV", calculatorVatios);
		return "calculatorVatios";
	}
	
	@GetMapping("/solve")
	public String solve(Model model, @ModelAttribute("calc") Calculator calculatorUser) throws Exception {
		Calculator calculator = new Calculator();
		
		model.addAttribute("calc", calculator);
		String resultC = null;
		try {
			resultC = calculatorUser.getResultString();			
		}catch (Exception e) {
			resultC=e.getMessage();
		}
		model.addAttribute("resultC", resultC);
		
		CalculatorVatios calculatorVatios = new CalculatorVatios();
		
		model.addAttribute("calcV", calculatorVatios);
		
		return "calculator";
	}
	
	@GetMapping("/solveVatios")
	public String solveVatios(Model model, @ModelAttribute("calcV") CalculatorVatios calulatorVatiosUser) throws Exception {
		Calculator calculator = new Calculator();
		model.addAttribute("calc", calculator);

		CalculatorVatios calculatorVatios = new CalculatorVatios();
		model.addAttribute("calcV", calculatorVatios);
		String resultV = null;
		resultV = calulatorVatiosUser.getResult();			
		model.addAttribute("resultV", resultV);
		
		return "calculator";
	}
	
}
