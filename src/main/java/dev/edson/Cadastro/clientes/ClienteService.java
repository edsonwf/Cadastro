package dev.edson.Cadastro.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> listarTodos() {

        return clienteRepository.findAll();
    }

    public ClienteModel buscarPorId(Long id) {

        Optional<ClienteModel> clienteModel = clienteRepository.findById(id);
        return clienteModel.orElse(null);
    }

    public ClienteModel salvar(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public ClienteModel atualizar(Long id, ClienteModel cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        throw new RuntimeException("Cliente não encontrado com ID: " + id);
    }
}
