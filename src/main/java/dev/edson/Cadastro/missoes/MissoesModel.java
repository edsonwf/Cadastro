package dev.edson.Cadastro.missoes;

import dev.edson.Cadastro.clientes.ClienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
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
