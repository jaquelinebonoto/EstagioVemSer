/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora;
/*
import br.com.dbc.locadora.entity.Role;
import br.com.dbc.locadora.entity.User;
import br.com.dbc.locadora.repository.RoleRepository;
import br.com.dbc.locadora.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author henrique.laporta
 
@Component
public class AppRunner implements CommandLineRunner{

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    @Transactional(readOnly = false)
    public void run(String... args) throws Exception {
        System.out.println("salva roles");
        
        jdbcTemplate.update("INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights')");
        jdbcTemplate.update("INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks')");
        
        jdbcTemplate.update("INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'John', 'Doe', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'john.doe')");
        jdbcTemplate.update("INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'admin.admin')");
        
        jdbcTemplate.update("INSERT INTO user_role(user_id, role_id) VALUES(1,1)");
        jdbcTemplate.update("INSERT INTO user_role(user_id, role_id) VALUES(2,1)");
        jdbcTemplate.update("INSERT INTO user_role(user_id, role_id) VALUES(2,2)");
        
        System.out.println("salvou roles");
    }
    
}*/
