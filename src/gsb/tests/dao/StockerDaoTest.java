/**
 *
 * Créé le 25 nov. 2021
 *
 */
package gsb.tests.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.dao.StockerDao;
import junit.framework.TestCase;

/**
 * @author LEMONNIER Bastien
 * 25 nov. 2021
 *
 */
public class StockerDaoTest extends TestCase {
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public final void testRechercherStocks() {
		assertNotNull("Resultat recherche : ", StockerDao.rechercherLesStocks("13012"));
	}
	
	@Test
	public final void testRechercherStocksInexistants() {
		assertNull("Resultat recherche : ", StockerDao.rechercherLesStocks("56100"));
	}
	
}
