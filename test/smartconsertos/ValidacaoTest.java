package smartconsertos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidacaoTest {
    
    public ValidacaoTest() {
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

    @Test
    public void testValidaLogin() {
        System.out.println("validaLogin");
        Usuario u = new Usuario("Antedeguemon", "123");
        Validacao instance = new Validacao();
        boolean expResult = true;
        boolean result = instance.validaLogin(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    public void testValidaDefeito() {
        System.out.println("validaDefeito");
        int tipoDefeito = 0;
        String descricao = "";
        String tempoConserto = "";
        String valorConserto = "";
        Validacao instance = new Validacao();
        Defeito expResult = null;
        Defeito result = instance.validaDefeito(tipoDefeito, descricao, tempoConserto, valorConserto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
