package br.com.dbc.locadora.repository;


import br.com.dbc.locadora.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
