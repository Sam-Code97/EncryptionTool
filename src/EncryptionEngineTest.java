import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EncryptionEngineTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEncrypt() {
		// Arrange / set-up
		Controller controller = null; // dummy controller
		EncryptionEngine e = new EncryptionEngine(controller);
		e.setEncryptionKey(3);
		// Act and Assert in one line
		assertEquals(e.encrypt("ABC"), "DEF");
		assertEquals(e.encrypt("XYZ"), "ABC");
		
		e.setEncryptionKey(33);
		assertEquals(e.encrypt("ABC"), "HIJ");
		
	}

	@Test
	public void testDecrypt() {
		// Arrange / set-up
		Controller controller = null; // dummy controller
		EncryptionEngine e = new EncryptionEngine(controller);
		e.setEncryptionKey(3);
		// Act and Assert in one line
		assertEquals(e.decrypt("DEF"), "ABC");
		assertEquals(e.decrypt("ABC"), "XYZ");
		
		e.setEncryptionKey(33);
		assertEquals(e.decrypt("ABC"), "TUV");
		
	    //assertThrows(IllegalArgumentException.class, () -> {
	     //   e.decrypt("AbC");  // Should throw an IllegalArgumentException because of the lowercase 'b'
	    //});
	}

}
