package dev.edson.Cadastro.clientes;

import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public ClienteModel map(ClienteDTO clienteDTO){
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setId(clienteDTO.getId());
        clienteModel.setNome(clienteDTO.getNome());
        clienteModel.setEmail(clienteDTO.getEmail());
        clienteModel.setIdade(clienteDTO.getIdade());
        clienteModel.setImgUrl(clienteDTO.getImgUrl());
        clienteModel.setRank(clienteDTO.getRank());
        clienteModel.setMissoes(clienteDTO.getMissoes());
        return clienteModel;
    }
    public ClienteDTO map(ClienteModel clienteModel){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clienteModel.getId());
        clienteDTO.setNome(clienteModel.getNome());
        clienteDTO.setEmail(clienteModel.getEmail());
        clienteDTO.setIdade(clienteModel.getIdade());
        clienteDTO.setImgUrl(clienteModel.getImgUrl());
        clienteDTO.setRank(clienteModel.getRank());
        clienteDTO.setMissoes(clienteModel.getMissoes());

        return clienteDTO;
    }
}
