package legacy_med_project.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import legacy_med_project.entities.Cliente;
import legacy_med_project.entities.DTO.cliente.DadosListagemCliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Page<Cliente> findAllByAtivoTrue(Pageable pageable);
}
