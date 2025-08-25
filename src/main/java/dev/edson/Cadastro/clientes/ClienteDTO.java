package dev.edson.Cadastro.clientes;

import dev.edson.Cadastro.missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClienteDTO {

    private Long id;

    private String nome;

    private String email;

    private String imgUrl;

    private int idade;

    private MissoesModel missoes;

    private String rank;
}
