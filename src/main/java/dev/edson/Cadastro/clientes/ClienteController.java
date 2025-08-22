package dev.edson.Cadastro.clientes;


import ch.qos.logback.core.net.server.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    //Adicionar Cliente Create
    @PostMapping("/criar")
    public ResponseEntity<String> criarCliente (@RequestBody ClienteDTO cliente ){
        ClienteDTO clienteDTO = clienteService.salvar(cliente);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Cliente criado com sucesso: "+clienteDTO.getNome()+ " (ID) :"+clienteDTO.getId());
    }

    //Mostrar todos os clientes Read
    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> mostrarTodosClientes(){
        List<ClienteDTO> cliente = clienteService.listarTodos();
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/listar/id")
    public ResponseEntity<?> listarClientePorId(@PathVariable Long id){

        ClienteDTO cliente = clienteService.buscarPorId(id);
        if(cliente != null){
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com esse ID não existe nos registros ");
    }

    //Alterar dados dos Clintes Update
    @PutMapping("/alterar/{id}")
    public  ResponseEntity<?> alterarClientesPorID(@PathVariable Long id, @RequestBody  ClienteDTO cliente){
        ClienteDTO clienteAtualizado = clienteService.atualizar(id, cliente);
        if(clienteAtualizado != null){
            return ResponseEntity.ok(clienteAtualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com id: " + id + " não existe no cadastro.");
    }




    //Deletar Clientes Delete
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarClientesPorID(@PathVariable Long id){
        if(clienteService.buscarPorId(id)!= null) {
            clienteService.deletar(id);
            return ResponseEntity.ok("Cliente deletado com sucesso "+ id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com id "+ id + " não encontrado ");
    }

}
