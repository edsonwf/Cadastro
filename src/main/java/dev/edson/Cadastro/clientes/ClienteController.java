package dev.edson.Cadastro.clientes;


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
    public ClienteModel criarCliente(@RequestBody ClienteModel cliente){
        return clienteService.salvar(cliente);
    }


    // Procurar Cliente por ID Read
    @GetMapping("/listar/{id}")
    public ClienteModel mostrarClientesPorID(@PathVariable Long id){
        return  clienteService.buscarPorId(id);
    }

    //Mostrar todos os clientes Read
    @GetMapping("/listar")
    public List<ClienteModel> mostrarTodosClientes(){
        return clienteService.listarTodos();
    }

    //Alterar dados dos Clintes Update
    @PutMapping("/alterar/{id}")
    public ClienteModel alterarClientesPorID(@PathVariable Long id, @RequestBody ClienteModel cliente){

        return clienteService.atualizar(id, cliente);
    }




    //Deletar Clientes Delete
    @DeleteMapping("/deletar/{id}")
    public void deletarClientesPorID(@PathVariable Long id){
        clienteService.deletar(id);
    }

}
