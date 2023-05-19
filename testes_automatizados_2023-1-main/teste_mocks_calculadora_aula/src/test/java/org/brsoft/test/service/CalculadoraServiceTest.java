package org.brsoft.test.service;

import org.brsoft.entity.Calculadora;
import org.brsoft.service.CalculadoraService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.security.InvalidParameterException;

@ExtendWith(SpringExtension.class)
public class CalculadoraServiceTest {
	// a classe CalculadoraService irá receber os mocks necessários. Ela é a classe a ser testada.
    private final double n1 = 3;
    private final double n2 = 2;

    @InjectMocks
    private CalculadoraService servico;

    @Mock
    private Calculadora calculadora;

    /* Regra da soma da calculadora
     * uma soma louca...
     * se n1 for maior que n2 retorna n1+n2
     * se n1 for igual a n2 retorna n1
     * se n2 for maior que n1 retorna n2
     * se n1 for zero retorne InvalidParameterException
     * se n2 for zero retorne InvalidParameterException
     * se n1 e n2 forem zero retorne InvalidParameterException
     */
    @BeforeEach
    public void setupMock(){
        Mockito.when(calculadora.somar(n1,n2)).thenReturn(5.0);
        Mockito.when(calculadora.somar(n1,n1)).thenReturn(n1);
        Mockito.when(calculadora.somar(n2,n1)).thenReturn(n2);
        Mockito.doThrow(InvalidParameterException.class).when(calculadora).somar(0, n2);
        Mockito.doThrow(InvalidParameterException.class).when(calculadora).somar(n1, 0);
        Mockito.doThrow(InvalidParameterException.class).when(calculadora).somar(0, 0);
    }

    @Test
    @DisplayName("Testa o método calculo para valores N1 maior que N2")
    public void testarCalculoQuandoN1MaiorN2(){
        //Arrange
        double resultadoesperado = 50;

        //Act
        double resultadoObtido = servico.calculo(n1,n2);

        //Assign
        Assertions.assertEquals(resultadoesperado, resultadoObtido);

        Mockito.verify(calculadora, Mockito.times(1)).somar(n1,n2);
    }

    @Test
    @DisplayName("Testa o método calculo para valores N1 igual a N2")
    public void testarCalculoQuandoN1IgualN2(){
        //Arrange
        double resultadoesperado = 30;

        //Act
        double resultadoObtido = servico.calculo(n1,n1);

        //Assign
        Assertions.assertEquals(resultadoesperado, resultadoObtido);

        Mockito.verify(calculadora, Mockito.times(1)).somar(n1,n1);
    }

    @Test
    @DisplayName("Testa o método calculo para valores N1 menor N2")
    public void testarCalculoQuandoN1MenorN2(){
        //Arrange
        double resultadoesperado = 20;

        //Act
        double resultadoObtido = servico.calculo(n2,n1);

        //Assign
        Assertions.assertEquals(resultadoesperado, resultadoObtido);

        Mockito.verify(calculadora, Mockito.times(1)).somar(n2,n1);
    }

    @Test
    @DisplayName("Testa se parametro N1 igual a 0 retorna exception")
    public void testarCalculoQuandoN1IgualZeroRetornaException(){

        //Act
        Assertions.assertThrows(InvalidParameterException.class, ()-> {servico.calculo(0,n2);});

        Mockito.verify(calculadora, Mockito.times(1)).somar(0,n2);
    }

    @Test
    public void testaCalculoN2Zero() {
        Assertions.assertThrows(InvalidParameterException.class, ()->{servico.calculo(n1, 0);});
        Mockito.verify(calculadora, Mockito.times(1)).somar(n1, 0);
    }

    @Test
    public void testaCalculoN1N2Zero() {
        Assertions.assertThrows(InvalidParameterException.class, ()->{servico.calculo(0, 0);});
        Mockito.verify(calculadora, Mockito.times(1)).somar(0, 0);
    }

}
