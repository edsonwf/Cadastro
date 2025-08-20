package dev.edson.Cadastro.missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController{

    //Post para cadastrar/criar uma missão
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada";
    }

    //Get listar todas as missões
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missões Listadas com sucesso";
    }

    @GetMapping("/listarId")
    public String listarMissaoId(){
        return "Mostrar missão por ID";
    }

    //Put -- Alterar uma missão
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso";
    }

    //Delete - Apagar uma missão pelo ID
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }
}