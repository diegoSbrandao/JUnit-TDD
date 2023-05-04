package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class ReajusteService {

    public BigDecimal desempenhoSalario(Desempenho desempenho, BigDecimal salario) {
        BigDecimal percentual = desempenho.percentualReajuste();
        return salario.multiply(percentual).setScale(2, RoundingMode.HALF_UP);
    }
}


