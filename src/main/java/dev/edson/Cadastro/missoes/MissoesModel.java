package dev.edson.Cadastro.missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    // Relacionamento OneToMany removido para evitar dependência circular
    // Um cliente pode ter uma missão, mas não precisamos da lista inversa aqui
    @OneToMany
    @JsonIgnore
    private List<ClienteModel> clientes;

}
