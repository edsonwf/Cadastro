package dev.edson.Cadastro.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public List<ClienteDTO> listarTodos() {
       List<ClienteModel> clientes = clienteRepository.findAll();
       return clientes.stream()
               .map(clienteMapper::map)
               .collect(Collectors.toList());

    }

    public ClienteDTO buscarPorId(Long id) {

        Optional< ClienteModel>  cliente = clienteRepository.findById(id);
        return  cliente.map(clienteMapper::map).orElse(null);
    }

    public  ClienteDTO salvar( ClienteDTO clienteDTO) {
        ClienteModel cliente = clienteMapper.map(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.map(cliente);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public  ClienteDTO atualizar(Long id,  ClienteDTO cliente) {
        Optional<ClienteModel> clienteExistente = clienteRepository.findById(id);
        if(clienteExistente.isPresent()){
            ClienteModel clienteAtualizado = clienteMapper.map(cliente);
            clienteAtualizado.setId(id);
            ClienteModel clienteSalvo = clienteRepository.save(clienteAtualizado);
            return clienteMapper.map(clienteSalvo);
        }
        return null;

    }

}
