package com.jacaranda.calculator.model;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;

public class CalculatorVatios {
	
	@NotNull
	private double voltio;
	@NotNull
	private double amperio;
	
	public double getVoltio() {
		return voltio;
	}
	
	public String getResult() {
		return "La potencia électrica de " + this.voltio + " voltios y de "+ this.amperio + " amperios " +  "es de :" + (voltio * amperio) + "W";
	}
	
	public void setVoltio(double voltio) throws Exception {
		try {
			this.voltio = voltio;			
		}catch (Exception e) {
			throw new Exception("Error solo se permiten números");
		}
	}
	
	public double getAmperio() {
		return amperio;
	}
	
	public void setAmperio(double amperio) throws Exception {
		try {
			this.amperio = amperio;
		}catch (Exception e) {
			throw new Exception("Error solo se permiten números");
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(amperio, voltio);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalculatorVatios other = (CalculatorVatios) obj;
		return Double.doubleToLongBits(amperio) == Double.doubleToLongBits(other.amperio)
				&& Double.doubleToLongBits(voltio) == Double.doubleToLongBits(other.voltio);
	}
	
}
