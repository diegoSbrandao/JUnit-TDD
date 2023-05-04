package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    /*
    A anotação chama todos os métodos antes de qualquer outro método
     */
    @BeforeEach
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Fulano", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    void ajusteDeveriaSerDeTresPorcentoSeDesempenhoForADesejar() {
        assertEquals(new BigDecimal("30.00"),
                service.desempenhoSalario(Desempenho.A_DESEJAR, funcionario.getSalario()));
    }

    @Test
    void ajusteDeveriaSerDeQuinzePorcentoSeDesempenhoForBom() {
        assertEquals(new BigDecimal("150.00"),
                service.desempenhoSalario(Desempenho.BOM, funcionario.getSalario()));
    }

    @Test
    void ajusteDeveriaSerDeVintePorcentoSeDesempenhoForOtimo() {
        assertEquals(new BigDecimal("200.00"),
                service.desempenhoSalario(Desempenho.OTIMO, funcionario.getSalario()));
    }

}
