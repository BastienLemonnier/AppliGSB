/**
 *
 * Créé le 18 nov. 2021
 *
 */
package gsb.tests.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import gsb.modele.Visite;
import gsb.service.VisiteService;

/**
 * @author LEMONNIER Bastien
 * 18 nov. 2021
 *
 */
public class VisiteServiceTest extends TestCase {
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public final void testCreerClientNullArguments() {
		assertEquals("Resultat insertion : ", 0, VisiteService.ajouterVisite(new Visite(null, null, null, null, null)));
	}
	
}
