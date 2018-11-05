package br.com.dbc.locadora.service;

import br.com.dbc.locadora.entity.User;
import br.com.dbc.locadora.dto.UserDTO;
import br.com.dbc.locadora.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Jaqueline
 */
//@Component
@Service
public class AppUserDetailsService extends AbstractCRUDService<User> implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;
    

    
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
    }

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }
    
    public User findByUserName (String nome){
        User user = userRepository.findByUsername(nome); //desse jeito só irá pegar o primeiro que encontrar
        return user;
    }
    
    /*@Transactional(readOnly = false, rollbackFor = Exception.class)
    public User updateSenha (@RequestBody UserDTO dto){
        User user = findByUserName(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        return user;
    }*/
}