package legacy_med_project.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import legacy_med_project.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

	Page<Medico> findAllByAtivoTrue(Pageable pageable);

}
