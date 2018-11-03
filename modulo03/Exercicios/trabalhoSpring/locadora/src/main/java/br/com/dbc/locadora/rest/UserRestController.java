/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.entity.User;
import br.com.dbc.locadora.repository.UserRepository;
import br.com.dbc.locadora.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *
 * @author jaqueline.bonoto
 */

@RestController
@RequestMapping("/api/user")
public class UserRestController extends AbstractController<User> {

    @Autowired
    private AppUserDetailsService userService;

    @Autowired
    private UserRepository userRepository;
    @Override
    protected AppUserDetailsService getService() {
        return userService;
    }
    
    @PostMapping("/password") 
    public ResponseEntity<?> post(@RequestBody User user) {
        Long id = getService().findByUserName(user.getUsername());
        return ResponseEntity.ok(getService().updateSenha(id, user.getPassword()));
    }

     
}
