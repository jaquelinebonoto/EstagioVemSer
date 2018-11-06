/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.dto.UserDTO;
import br.com.dbc.locadora.entity.User;
import br.com.dbc.locadora.service.AppUserDetailsService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaqueline.bonoto
 */
public class UserRestControllerTest {
    
    public UserRestControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getService method, of class UserRestController.
     */
    @Test
    public void testGetService() {
        System.out.println("getService");
        UserRestController instance = new UserRestController();
        AppUserDetailsService expResult = null;
        AppUserDetailsService result = instance.getService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSenha method, of class UserRestController.
     */
    @Test
    public void testUpdateSenha() {
        System.out.println("updateSenha");
        UserDTO dto = null;
        UserRestController instance = new UserRestController();
        User expResult = null;
        User result = instance.updateSenha(dto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
