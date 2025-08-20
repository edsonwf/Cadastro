package dev.edson.Cadastro.clientes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    // Métodos personalizados podem ser adicionados aqui
}
