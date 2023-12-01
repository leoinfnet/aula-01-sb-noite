package br.com.infnet.aula01sbnoite.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class Telefone {
    private String codigoPais;
    private String ddd;
    private String numero;
    private String tipo;
}
