package com.jacaranda.calculator.model;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;


public class Calculator {
	@NotNull
	private double number1;
	@NotNull
	private double number2;
	private char operator;
	
	public double getNumber1() {
		return number1;
	}
	
	public void setNumber1(double number1) throws Exception {
		try {			
			this.number1 = number1;
		} catch (Exception e) {
			throw new Exception("El numero 1 deber ser un número y mayor que 0");
		}
	}
	
	public double getNumber2() {
		return number2;
	}
	
	public void setNumber2(double number2) throws Exception {
		try {
			this.number2 = number2;
		}catch (Exception e) {
			throw new Exception("El numero 2 deber ser un número y mayor que 0");
		}
	}
	
	public char getOperator() {
		return operator;
	}
	
	public void setOperator(char operator) {
		this.operator = operator;
	}
	
	private double getResult() throws Exception {
		double result = 0;
		
		if(this.operator == '+') {
			result = this.number1 + this.number2;
		}else if(this.operator == '-') {
			result = this.number1 - this.number2;
		}else if(this.operator == '*') {
			result = this.number1 * this.number2;
		}else if(this.operator == '/') {
			result = this.number1 / this.number2;
		}else {
			throw new Exception("Ese operador no existe");
		}
		
		return result;
	}
	
	public String getResultString() throws Exception {
		return String.format("Operación anterior: %s %s %s = %s", 
				this.getNumber1(),this.getOperator(),this.getNumber2(),this.getResult());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(number1, number2, operator);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		return number1 == other.number1 && number2 == other.number2 && Objects.equals(operator, other.operator);
	}
	
	
}
