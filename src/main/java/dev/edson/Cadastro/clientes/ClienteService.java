package dev.edson.Cadastro.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public List<ClienteDTO> listarTodos() {
        ClienteModel <cliente> = clienteRepository.findAll();
        return new clienteMapper.map(cliente);
    }

    public ClienteDTO buscarPorId(Long id) {

        Optional< ClienteDTO>  clienteDTO = clienteRepository.findById(id);
        return  clienteDTO.orElse(null);
    }

    public  ClienteDTO salvar( ClienteDTO clienteDTO) {
        ClienteModel cliente = new clienteMapper.map(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.map(cliente);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public  ClienteDTO atualizar(Long id,  ClienteDTO cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        throw new RuntimeException("Cliente não encontrado com ID: " + id);
    }

}
