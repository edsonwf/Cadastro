package dev.edson.Cadastro.missoes;

import dev.edson.Cadastro.clientes.ClienteModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesDTO {

    private Long id;

    private String nome;

    private String dificuldade;

    private List<ClienteModel> clientes;
}
