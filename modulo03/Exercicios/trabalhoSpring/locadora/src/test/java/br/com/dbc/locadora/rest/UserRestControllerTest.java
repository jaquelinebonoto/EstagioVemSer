package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.LocadoraApplicationTests;
import br.com.dbc.locadora.dto.UserDTO;
import br.com.dbc.locadora.entity.User;
import br.com.dbc.locadora.repository.UserRepository;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author jaqueline.bonoto
 */
public class UserRestControllerTest extends LocadoraApplicationTests {

    @Autowired
    private UserRestController userRestController;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected AbstractController getController() {
        return userRestController;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateUser() throws Exception {
        User u = User.builder()
                .firstName("Ele")
                .lastName("Ele Mesmo")
                .password("elesim")
                .username("esseehocara")
                .build();
        restMockMvc.perform(MockMvcRequestBuilders.post("/api/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(u)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(u.getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(u.getLastName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value(u.getPassword()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value(u.getUsername()));
        List<User> users = userRepository.findAll();
        Assert.assertEquals(3, users.size());
        Assert.assertEquals(u.getFirstName(), users.get(2).getFirstName());
        Assert.assertEquals(u.getPassword(), users.get(2).getPassword());
    }

    @Test(expected = Exception.class)
    @WithMockUser(username = "joaodasneves",
            password = "jwtpass",
            authorities = {"STANDARD_USER"})
    public void testGetUsersAccessDenied() throws Exception {
        UserDTO u = UserDTO.builder()
                .username("joaodasneves")
                .password("jwtpass")
                .build();
        restMockMvc.perform(MockMvcRequestBuilders.post("/api/user/password")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(u)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
        @WithMockUser(username = "admin.admin",
            password = "jwtpass",
            authorities = {"ADMIN_USER"})
    public void testeUpdateSenha() throws Exception {
        UserDTO u = UserDTO.builder()
                .username("admin.admin")
                .password("jwtpass")
                .build();
        restMockMvc.perform(MockMvcRequestBuilders.post("/api/user/password")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsBytes(u)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
