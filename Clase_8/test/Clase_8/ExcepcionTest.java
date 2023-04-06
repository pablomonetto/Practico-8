/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Clase_8;

import static java.lang.Boolean.TRUE;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pablo
 */
public class ExcepcionTest {
    
    public ExcepcionTest() {
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
     * Test of exc1 method, of class Excepcion.
     */
    @Test
    public void testExc1() throws Exception {
        System.out.println("Excepcion para descuento cuando el precio es 0");
        float precio = 10.0F;
        Excepcion instance = new Excepcion();
        boolean expResult = TRUE;
        boolean result = instance.exc1(precio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of exc2 method, of class Excepcion.
     */
    @Test
    public void testExc2() throws Exception {
        System.out.println("Excepcion para descuento fijo < 0");
        float descFijo = 50.0F;
        Excepcion instance = new Excepcion();
        float expResult = 50.0F;
        float result = instance.exc2(descFijo);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
