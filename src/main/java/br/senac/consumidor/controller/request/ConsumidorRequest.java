package br.senac.consumidor.controller.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsumidorRequest {

    private String operador;
    private double valor1;
    private double valor2;

}
