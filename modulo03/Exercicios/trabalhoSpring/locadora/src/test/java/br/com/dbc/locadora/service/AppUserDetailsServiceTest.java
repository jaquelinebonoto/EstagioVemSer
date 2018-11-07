
package br.com.dbc.locadora.service;

import br.com.dbc.locadora.LocadoraApplicationTests;
import br.com.dbc.locadora.entity.User;
import br.com.dbc.locadora.rest.AbstractController;
import br.com.dbc.locadora.rest.UserRestController;
import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author Windows
 */
public class AppUserDetailsServiceTest extends LocadoraApplicationTests{
    
    @Autowired
    private UserRestController userRestController;
    
        @Autowired
    private AppUserDetailsService userService;
        

    
    protected AbstractController getController() {
        return userRestController;
    }

    @Test
        @WithMockUser(username = "admin.admin",
            password = "jwtpass",
            authorities = {"ADMIN_USER"})
    public void testFindByUserName() throws Exception {
        System.out.println("findByUserName");
        User u = User.builder().firstName("Joao").lastName("das Neves").username("jao").password("jwtpass").build();
        userService.save(u);
        User u2 = User.builder().firstName("Alex").lastName("Silva").username("alex").password("jxtpass").build();
        userService.save(u2);
        AppUserDetailsService mock = Mockito.mock(AppUserDetailsService.class);
        User u3 = userService.findByUserName("Joao");
        //userService.save(u3);
        
        restMockMvc.perform(MockMvcRequestBuilders.post("/api/user/password")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(u)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").isString());
        
        //Assert.assertEquals(u3.getFirstName(), u.getFirstName());
    }
    
}
