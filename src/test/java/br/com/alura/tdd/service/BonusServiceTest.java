package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    private BonusService service = new BonusService();
    private ReajusteService services;


/*
Método de teste com expection try e catch, útil para verificar se a mensagem do erro está vindo da forma desejada
 */
//    @Test
//    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
//        BonusService service = new BonusService();
//        try {
//            service.calcularBonus(new Funcionario("Diego",
//                    LocalDate.now(),
//                    new BigDecimal("18000")));
//        } catch (Exception e) {
//            assertEquals("Salário do funcionário é acima do texto de R$ 10.000,00", e.getMessage());
//        }
//    }

    /*
Método de teste com expection
 */

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Diego",
                LocalDate.now(),
                new BigDecimal("18000"))));

    }

    @Test
    void bonusDeveriaSerDezPorcentoParaFuncionarioComSalarioAbaixoDeDezMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Diego",
                LocalDate.now(),
                new BigDecimal("8000")));
        assertEquals(new BigDecimal("800.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorcentoParaFuncionarioComSalarioDeDezMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Diego",
                LocalDate.now(),
                new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}