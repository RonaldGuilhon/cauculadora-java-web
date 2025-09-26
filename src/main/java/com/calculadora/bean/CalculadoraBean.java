package com.calculadora.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@ManagedBean(name = "calculadoraBean")
@ViewScoped
public class CalculadoraBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String display = "0";
    private String historico = "";
    private BigDecimal numero1;
    private BigDecimal numero2;
    private String operacao;
    private boolean novaOperacao = true;
    private boolean operacaoRealizada = false;

    public void adicionarNumero(String numero) {
        if (novaOperacao || display.equals("0")) {
            display = numero;
            novaOperacao = false;
        } else {
            display += numero;
        }
        operacaoRealizada = false;
    }

    public void adicionarPonto() {
        if (novaOperacao) {
            display = "0.";
            novaOperacao = false;
        } else if (!display.contains(".")) {
            display += ".";
        }
        operacaoRealizada = false;
    }

    public void definirOperacao(String op) {
        try {
            if (numero1 != null && !novaOperacao && !operacaoRealizada) {
                calcular();
            }
            numero1 = new BigDecimal(display);
            operacao = op;
            
            // Atualizar histórico com o número e operação
            String simboloOperacao = op;
            switch (op) {
                case "*":
                    simboloOperacao = "×";
                    break;
                case "/":
                    simboloOperacao = "÷";
                    break;
                case "-":
                    simboloOperacao = "−";
                    break;
                case "+":
                    simboloOperacao = "+";
                    break;
            }
            
            historico = display + " " + simboloOperacao + " ";
            display = "0";
            
            novaOperacao = true;
        } catch (NumberFormatException e) {
            mostrarErro("Número inválido");
        }
    }

    public void calcular() {
        try {
            if (numero1 == null || operacao == null) {
                return;
            }

            numero2 = new BigDecimal(display);
            BigDecimal resultado = null;

            switch (operacao) {
                case "+":
                    resultado = numero1.add(numero2);
                    break;
                case "-":
                    resultado = numero1.subtract(numero2);
                    break;
                case "*":
                    resultado = numero1.multiply(numero2);
                    break;
                case "/":
                    if (numero2.compareTo(BigDecimal.ZERO) == 0) {
                        mostrarErro("Divisão por zero não é permitida");
                        return;
                    }
                    resultado = numero1.divide(numero2, 10, RoundingMode.HALF_UP);
                    break;
                default:
                    mostrarErro("Operação inválida");
                    return;
            }

            // Atualizar histórico com o cálculo completo
            historico = historico + display + " =";

            // Remove zeros desnecessários
            if (resultado.stripTrailingZeros().scale() <= 0) {
                display = resultado.stripTrailingZeros().toPlainString();
            } else {
                display = resultado.stripTrailingZeros().toPlainString();
            }

            numero1 = resultado;
            operacao = null;
            novaOperacao = true;
            operacaoRealizada = true;

        } catch (NumberFormatException e) {
            mostrarErro("Número inválido");
        } catch (ArithmeticException e) {
            mostrarErro("Erro na operação matemática");
        }
    }

    public void limpar() {
        display = "0";
        historico = "";
        numero1 = null;
        numero2 = null;
        operacao = null;
        novaOperacao = true;
        operacaoRealizada = false;
    }

    public void apagarUltimo() {
        if (display.length() > 1) {
            display = display.substring(0, display.length() - 1);
        } else {
            display = "0";
            novaOperacao = true;
        }
        operacaoRealizada = false;
    }

    public void calcularRaizQuadrada() {
        try {
            BigDecimal numero = new BigDecimal(display);
            if (numero.compareTo(BigDecimal.ZERO) < 0) {
                mostrarErro("Não é possível calcular raiz quadrada de número negativo");
                return;
            }
            
            double resultado = Math.sqrt(numero.doubleValue());
            display = BigDecimal.valueOf(resultado).stripTrailingZeros().toPlainString();
            novaOperacao = true;
            operacaoRealizada = true;
        } catch (NumberFormatException e) {
            mostrarErro("Número inválido");
        }
    }

    public void calcularPorcentagem() {
        try {
            BigDecimal numero = new BigDecimal(display);
            BigDecimal resultado = numero.divide(new BigDecimal("100"), 10, RoundingMode.HALF_UP);
            display = resultado.stripTrailingZeros().toPlainString();
            novaOperacao = true;
            operacaoRealizada = true;
        } catch (NumberFormatException e) {
            mostrarErro("Número inválido");
        }
    }

    private void mostrarErro(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", mensagem));
        limpar();
    }

    // Getters e Setters
    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }
}