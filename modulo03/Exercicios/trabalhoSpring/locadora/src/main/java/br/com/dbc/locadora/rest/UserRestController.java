/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.entity.User;
import br.com.dbc.locadora.entity.UserDTO;
import br.com.dbc.locadora.repository.UserRepository;
import br.com.dbc.locadora.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 *
 * @author jaqueline.bonoto
 */

@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasAuthority('ADMIN_USER')")
public class UserRestController extends AbstractController<User> {

    @Autowired
    private AppUserDetailsService userService;

    @Override
    protected AppUserDetailsService getService() {
        return userService;
    }
   
    /*@RequestMapping(value = "/password", method = RequestMethod.POST)
    public User updateSenha(@RequestBody UserDTO dto) {
        return (getService().updateSenha(dto));
    }
    
    @PutMapping("/password")
        public User updateSenha(@RequestBody UserDTO dto) {
        return (getService().updateSenha(dto));
    }*/
    

}
