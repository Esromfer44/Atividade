package calculadora;

import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
public class CalculadoraTest {
	private Calculadora calculadora;

	@BeforeEach
	public void inicializarCenario() {
		calculadora = new Calculadora();
		System.out.println("BeforeEach");
	}
	
    @Test
    public void testarSomaDoisInteirosSucesso() {
    	//Arrange - Definir o cenário de teste
    	int entradaNumeroUm = 10;
    	int entradaNumeroDois = 5;
    	int saidaEsperada = 15;
    	
    	//Act - Executaros métodos que estão sendo testados
    	int saidaObtida = calculadora.somar(entradaNumeroUm, entradaNumeroDois);
    	
    	//Assign - Validar o resultado obtido
    	Assertions.assertEquals(saidaEsperada, saidaObtida);
    }
    
    @Test
    public void testarSubtrairDoisInteirosSucesso() {
    	//Arrange - Definir o cenário de teste
    	int entradaNumeroUm = 10;
    	int entradaNumeroDois = 5;
    	int saidaEsperada = 5;
    	
    	//Act - Executaros métodos que estão sendo testados
    	int saidaObtida = calculadora.subtrair(entradaNumeroUm, entradaNumeroDois);
    	
    	//Assign - Validar o resultado obtido
    	Assertions.assertEquals(saidaEsperada, saidaObtida);
    }    
    
    @Test
    public void testarMultiplicarDoisInteirosSucesso() {
    	//Arrange - Definir o cenário de teste
    	int entradaNumeroUm = 10;
    	int entradaNumeroDois = 5;
    	int saidaEsperada = 50;
    	
    	//Act - Executaros métodos que estão sendo testados
    	int saidaObtida = calculadora.multiplicar(entradaNumeroUm, entradaNumeroDois);
    	
    	//Assign - Validar o resultado obtido
    	Assertions.assertEquals(saidaEsperada, saidaObtida);
    }        
    
    @Test
    public void testarDividirDoisInteirosSucesso() throws Exception {
    	//Arrange - Definir o cenário de teste
    	int entradaNumeroUm = 10;
    	int entradaNumeroDois = 5;
    	int saidaEsperada = 2;
    	
    	//Act - Executaros métodos que estão sendo testados
    	int saidaObtida = calculadora.dividir(entradaNumeroUm, entradaNumeroDois);
    	
    	//Assign - Validar o resultado obtido
    	Assertions.assertEquals(saidaEsperada, saidaObtida);
    }        
    
    @Test
    public void testarDividirPorZeroRetornaErro() {
    	//Arrange - Definir o cenário de teste
    	int entradaNumeroUm = 10;
    	int entradaNumeroDois = 0;
    	
    	//Act + Assign- Executar o método e valida a ocorrência de erro
    	Assertions.assertThrows(ArithmeticException.class, ()-> calculadora.dividir(entradaNumeroUm, entradaNumeroDois));
    	
    }        

    
}