package dev.edson.Cadastro.missoes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController{

    @Autowired
    private MissoesService missoesService;

    //Post para cadastrar/criar uma missão
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO missoesDTO = missoesService.salvar(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body(("Missao criada com sucesso"));
    }

    //Get listar todas as missões
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> mostrarTodasMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoId(@PathVariable Long id){
        MissoesDTO missao = missoesService.buscarPorId(id);
        if(missao != null){
            return ResponseEntity.ok(missao);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com esse ID não existe nos registros ");
    }


    //Put -- Alterar uma missão
    @PutMapping("/alterar")
    public ResponseEntity<?> alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missoes){
        MissoesDTO misaoAtualizada = missoesService.atualizar(id, missoes);
        if(misaoAtualizada != null){
            return ResponseEntity.ok(misaoAtualizada);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("Missão com id: "+id+ " não existe na base de dados."));
    }

    //Delete - Apagar uma missão pelo ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id){
        if(missoesService.buscarPorId(id)!= null){
            missoesService.deletar(id);
            return ResponseEntity.ok("Missão deletada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com id "+ id + " não encontrada ");
    }

}