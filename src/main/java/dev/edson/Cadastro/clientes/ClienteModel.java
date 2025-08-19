package dev.edson.Cadastro.clientes;

import dev.edson.Cadastro.missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tb_cadastro")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;
//@ManyToOne um cliente tem apenas uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

    public ClienteModel() {

    }

    public ClienteModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
