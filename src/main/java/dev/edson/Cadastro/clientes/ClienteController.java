package dev.edson.Cadastro.clientes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ClienteController {

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    //Adicionar Cliente Create
    @PostMapping("/criar")
    public String criarCliente(){
        return "Cliente criado";
    }


    // Procurar Cliente por ID Read
    @GetMapping("/clienteId")
    public String mostrarClientesPorID(){
        return "Todos os clientes";
    }

    //Mostrar todos os clientes Read
    @GetMapping("/todos")
    public String mostrarTodosClientes(){
        return "Todos os clientes";
    }

    //Alterar dados dos Clintes Update
    @PutMapping("/alterarID")
    public String alterarClientesPorID(){
        return "Alterar clientes";
    }




    //Deletar Clientes Delete
    @DeleteMapping("/deletarID")
    public String deletarClientesPorID(){
        return "clientes deletado por id";
    }

}
