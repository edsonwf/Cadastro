package dev.edson.Cadastro.missoes;

import dev.edson.Cadastro.clientes.ClienteDTO;
import dev.edson.Cadastro.clientes.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    @Autowired
    private MissoesRepository missoesRepository;

    @Autowired
    private MissoesMapper missoesMapper;

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());

    }

    public MissoesDTO buscarPorId(Long id){
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.map(missoesMapper::map).orElse(null);
    }
    public MissoesDTO salvar(MissoesDTO missaoDto){
        MissoesModel missao = missoesMapper.map(missaoDto);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    public void deletar(Long id){
        missoesRepository.deleteById(id);
    }

    public MissoesDTO atualizar(Long id, MissoesDTO missoes){
        Optional<MissoesModel> missoesExistentes = missoesRepository.findById(id);
        if(missoesExistentes.isPresent()){
            MissoesModel missoesAtualizada = missoesMapper.map(missoes);
            missoesAtualizada.setId(id);
            MissoesModel missoesSalva = missoesRepository.save(missoesAtualizada);
            return missoesMapper.map(missoesSalva);
        }
        return null;
    }



}
