package dev.edson.Cadastro.clientes;

import dev.edson.Cadastro.missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tb_cadastro")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name="idade")
    private int idade;
//@ManyToOne um cliente tem apenas uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;


}
