package smartconsertos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControllerTest {
    
    public ControllerTest() {
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

    
    public void testAtualizarTabelaDefeitos() {
        System.out.println("atualizarTabelaDefeitos");
        Controller instance = new Controller();
        instance.atualizarTabelaDefeitos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnalisaBeneficio() {
        System.out.println("analisaBeneficio");
        double valorTotal = 50;
        Celular cel = new Celular(1, "Galaxy S4", new Marca(1, "Samsung"), 100);
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.analisaBeneficio(valorTotal, cel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    
    public void testSetarDefeitos() {
        System.out.println("setarDefeitos");
        Controller instance = new Controller();
        instance.setarDefeitos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    public void testInsereMarcas() {
        System.out.println("insereMarcas");
        Controller instance = new Controller();
        instance.insereMarcas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    public void testInsereCelulares() {
        System.out.println("insereCelulares");
        Controller instance = new Controller();
        instance.insereCelulares();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
