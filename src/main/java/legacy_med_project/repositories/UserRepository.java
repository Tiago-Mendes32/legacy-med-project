package legacy_med_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import legacy_med_project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
