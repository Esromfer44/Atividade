package org.brsoft.service;

import org.brsoft.entity.Calculadora;
import org.springframework.beans.factory.annotation.Autowired;

public class CalculadoraService {
	@Autowired
	private Calculadora calc;
	
	public double calculo(double n1, double n2) {
		return calc.somar(n1,n2)*10;
	}
}
