package dev.edson.Cadastro.missoes;

import dev.edson.Cadastro.clientes.ClienteModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;
    //@OneToMany - um missão pode ter vários clientes
    @OneToMany(mappedBy = "missoes")
    private List<ClienteModel> clientes;
}
