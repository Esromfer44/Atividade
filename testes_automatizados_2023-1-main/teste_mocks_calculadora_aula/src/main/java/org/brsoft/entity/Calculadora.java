package org.brsoft.entity;

import java.security.InvalidParameterException;

public class Calculadora {
	/*
	 * uma soma louca... 
	 * se n1 for maior que n2 retorna n1+n2
	 * se n1 for igual a n2 retorna n1
	 * se n2 for maior que n1 retorna n2
	 * se n1 for zero retorne InvalidParameterException
	 * se n2 for zero retorne InvalidParameterException
	 * se n1 e n2 forem zero retorne InvalidParameterException
	 */
	public double somar(double n1, double n2) {
		if (n1==0 || n2==0)
			throw new InvalidParameterException("N1 ou N2 igual a 0");
		if (n1>n2) return n1+n2;
		else if (n1==n2) return n1;
		else return n2;
	}
}
