package pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaTest {
	private Pessoa pessoa;	
	
	@BeforeEach
	public void iniciaDados() {
		pessoa = new Pessoa();
	}
	
	/**
	 * Cenário de teste 1
	 */	
	@Test
	@DisplayName("Testar o nome da pessoa quando a entrada é válida (entre 2 e 100 caracteres) no limite superior")
	public void testarNomeCorretoNoLimiteSuperior() {
		//Arrange = Cria o cenário
		String entradaNome = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
		String resultadoEsperado = "BRUNO QUEIROZ 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
		
		//Act = executar os métodos a serem testados		
		pessoa.setNome(entradaNome);
		String resultadoObtido = pessoa.getNome();
		
		//Assign = comparação
		Assertions.assertEquals(resultadoEsperado, resultadoObtido);
	}

	/**
	 * Cenário de teste 2
	 */
	@Test
	@DisplayName("Testar o nome da pessoa quando a entrada é válida (entre 2 e 100 caracteres) no limite inferior")
	public void testarNomeCorretoNoLimiteInferior() {
		String entradaNome = "Ze";
		String resultadoEsperado = "ZE";

		pessoa.setNome(entradaNome);
		String resultadoObtido = pessoa.getNome();

		Assertions.assertEquals(resultadoEsperado, resultadoObtido);
	}	
	
	/**
	 * Cenário de teste 3	 
	 */
	@Test
	@DisplayName("Testar o nome da pessoa quando a entrada é inválida, menos de 2 caracteres")
	public void testarNomeInCorretoAbaixoLimiteInferior() {
		String entradaNome = "A";
		
		assertThrows(IllegalArgumentException.class, ()->{pessoa.setNome(entradaNome);});
	}	
	
	/**
	 * Cenário de teste 4
	 */
	@Test
	@DisplayName("Testar o nome da pessoa quando a entrada é inválida, mais de 100 caracteres")
	public void testarNomeInCorretoAcimaLimiteSuperior() {
		String entradaNome = "0101Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
		
		assertThrows(IllegalArgumentException.class, ()->{pessoa.setNome(entradaNome);});
	}	
	
	/**
	 * Cenário de teste 5
	 */
	@Test
	@DisplayName("Testar se o construtor cria um objeto pessoa quando o nome é correto.")
	public void testarConstrutorNomeCorretoNoLimiteSuperior() {
		//Arrange = Cria o cenário
		String entradaNome = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
		String resultadoEsperado = "BRUNO QUEIROZ 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
		
		//Act = executar os métodos a serem testados		
		pessoa = new Pessoa(entradaNome);
		String resultadoObtido = pessoa.getNome();
		
		//Assign = comparação
		Assertions.assertEquals(resultadoEsperado, resultadoObtido);
	}

	/**
	 * Cenário de teste 6
	 */
	@Test
	@DisplayName("Testar se o construtor retorna exception para nome incorreto.")
	public void testarConstrutorNomeInvalidoRetornaException() {
		String entradaNome = "A";
		
		assertThrows(IllegalArgumentException.class, ()->{new Pessoa(entradaNome);});

	}
	
	/**
	 * Cenário de teste 7
	 */	
	@Test
	@DisplayName("Testar se o salário pessoa quando a entrada é válida (entre 1100 e 1000000) no limite superior")
	public void testarSalarioCorretoNoLimiteSuperior() {
		//Arrange = Cria o cenário
		double entradaSalario = 900000;
		double resultadoEsperado = 900000;
		
		//Act = executar os métodos a serem testados		
		pessoa.setSalario(entradaSalario);
		double resultadoObtido = pessoa.getSalario();
		
		//Assign = comparação
		Assertions.assertEquals(resultadoEsperado, resultadoObtido);
	}

	/**
	 * Cenário de teste 8
	 */	
	@Test
	@DisplayName("Testar se o salário pessoa quando a entrada é válida (entre 1100 e 1000000) no limite inferior")
	public void testarSalarioCorretoNoLimiteInferior() {
		//Arrange = Cria o cenário
		double entradaSalario = 1100;
		double resultadoEsperado = 1100;
		
		//Act = executar os métodos a serem testados		
		pessoa.setSalario(entradaSalario);
		double resultadoObtido = pessoa.getSalario();
		
		//Assign = comparação
		Assertions.assertEquals(resultadoEsperado, resultadoObtido);
	}

	/**
	 * Cenário de teste 9
	 */	
	@Test
	@DisplayName("Testar se o salário pessoa quando a entrada é inválida retorna exception")
	public void testarSalarioIncorretoNoLimiteSuperiorRetornaException() {
		//Arrange = Cria o cenário
		double entradaSalario = 1000001;
		
		assertThrows(IllegalArgumentException.class, ()->{pessoa.setSalario(entradaSalario);});
	}

	/**
	 * Cenário de teste 10
	 */	
	@Test
	@DisplayName("Testar se o salário pessoa quando a entrada é inválida retorna exception")
	public void testarSalarioIncorretoNoLimiteInferiorRetornaException() {
		//Arrange = Cria o cenário
		double entradaSalario = 1000;
		
		assertThrows(IllegalArgumentException.class, ()->{pessoa.setSalario(entradaSalario);});
	}
	
	/**
	 * Cenário de teste 11
	 */	
	@Test
	@DisplayName("Testar se o reajuste do salário da pessoa quando a entrada é válida no limite superior.")
	public void testarReajusteSalariocorretoNoLimiteSuperior() {
		//Arrange = Cria o cenário
		double entradaPorcentagem = 100;
		double entradaSalarioValido = 2000.00;
		double salarioEsperado = 4000.00;
		
		pessoa.setSalario(entradaSalarioValido);
		pessoa.reajustaSalario(entradaPorcentagem);
		double salarioObtido = pessoa.getSalario();
		assertEquals(salarioEsperado, salarioObtido);
	}
	
	/**
	 * Cenário de teste 12
	 */	
	@Test
	@DisplayName("Testar se o reajuste do salário da pessoa quando a entrada é válida no limite inferior.")
	public void testarReajusteSalariocorretoNoLimiteInferior() {
		//Arrange = Cria o cenário
		double entradaPorcentagem = 1;
		double entradaSalarioValido = 2000.00;
		double salarioEsperado = 2020.00;
		
		pessoa.setSalario(entradaSalarioValido);
		pessoa.reajustaSalario(entradaPorcentagem);
		double salarioObtido = pessoa.getSalario();
		assertEquals(salarioEsperado, salarioObtido);
	}
	
	/**
	 * Cenário de teste 13
	 */	
	@Test
	@DisplayName("Testar se o reajuste do salário da pessoa quando a entrada é inválida no limite superior retorna exception.")
	public void testarReajusteIncorretoNoLimiteSuperiorRetornaException() {
		//Arrange = Cria o cenário
		double entradaPorcentagem = 110;
		assertThrows(IllegalArgumentException.class, ()->{pessoa.reajustaSalario(entradaPorcentagem);});
	}
	
	/**
	 * Cenário de teste 14
	 */	
	@Test
	@DisplayName("Testar se o reajuste do salário da pessoa quando a entrada é inválida no limite inferior retorna exception.")
	public void testarReajusteIncorretoNoLimiteInferiorRetornaException() {
		//Arrange = Cria o cenário
		double entradaPorcentagem = 0;
		assertThrows(IllegalArgumentException.class, ()->{pessoa.reajustaSalario(entradaPorcentagem);});
	}

	
}
