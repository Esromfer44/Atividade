package pessoa;

public class Pessoa {
	private String nome;
	private double salario;

	public Pessoa(String nome) {
		this.nome = validaNome(nome);
	}

	public Pessoa() {
		
	}
	
	public void setNome(String nome) {
		this.nome = validaNome(nome);
	}

	public String getNome() {
		return this.nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = validaSalario(salario);
	}

	public static double validaSalario(double salario) {
		if (salario >=1100 && salario <=1000000)
			return salario;
		else
			throw new IllegalArgumentException("O salário precisa ter um valor entre R$ 1100,00 e R$ 1000000,00.");
	}
	
	public static String validaNome(String nome) {
		if (nome.length() >= 2 && nome.length() <= 100)
			return nome.toUpperCase();
		else
			throw new IllegalArgumentException("O nome precisa ter entre 2 e 100 caracteres");

		
	}

	public void reajustaSalario(double porcentagem) {
		this.salario += this.salario*validaPorcentagem(porcentagem);
		
	}

	private double validaPorcentagem(double porcentagem) {
		if(porcentagem >=1 && porcentagem <=100) {
			return porcentagem/100;
		}else {
			throw new IllegalArgumentException("A porcetagem precisa ser um valor entre 1 e 100.");
			
		}
	}
}
