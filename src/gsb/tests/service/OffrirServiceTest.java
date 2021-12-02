/**
 *
 * Créé le 2 déc. 2021
 *
 */
package gsb.tests.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.service.MedicamentService;
import gsb.service.OffrirService;
import gsb.service.VisiteService;
import junit.framework.TestCase;

/**
 * @author LEMONNIER Bastien
 * 2 déc. 2021
 *
 */
public class OffrirServiceTest extends TestCase {
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		VisiteService.deleteVisite("v5000");
	}
	
	@Test
	public final void testRechercherOffrirNull () {
		assertNull("Resultat recherche : ", OffrirService.rechercher(null));
	}
	
	@Test
	public final void testRechercherOffrirNonExistant() {
		assertNull("Resultat recherche : ", OffrirService.rechercher("v0025"));
	}
	
	@Test
	public final void testRechercherOffrirExistant() {
		assertNotNull("Resultat recherche : ", OffrirService.rechercher("v0017"));
	}
	
	@Test
	public final void testInsererOffrirNull() {
		assertEquals("Resultat insertion : ", false, OffrirService.inserer(new Offrir(null, null, 0)));
	}
	
	@Test
	public final void testInsererOffrirVisiteInexistante() {
		assertEquals("Resultat insertion : ", false, OffrirService.inserer(new Offrir(MedicamentService.rechercher("BACTIG10"), VisiteService.rechercherVisite("v9999"), 10)));
	}
	
	@Test
	public final void testInsererOffrirVisiteFausse() {
		assertEquals("Resultat insertion : ", false, OffrirService.inserer(new Offrir(MedicamentService.rechercher("BACTIG10"), VisiteService.rechercherVisite("HFUIFF"), 10)));
	}
	
	@Test
	public final void testInsererOffrirMedicamentInexistant() {
		assertEquals("Resultat insertion : ", false, OffrirService.inserer(new Offrir(MedicamentService.rechercher("AXEGTX"), VisiteService.rechercherVisite("v0017"), 10)));
	}
	
	@Test
	public final void testInsererOffrirMedicamentFaux() {
		assertEquals("Resultat insertion : ", false, OffrirService.inserer(new Offrir(MedicamentService.rechercher("%NDFO[4"), VisiteService.rechercherVisite("v0017"), 10)));
	}
	
	@Test
	public final void testInsererOffrirQttStockInsuffisante() {
		assertEquals("Resultat insertion : ", false, OffrirService.inserer(new Offrir(MedicamentService.rechercher("BACTI10G"), VisiteService.rechercherVisite("v0025"), 999)));
	}
	
	@Test
	public final void testInsererOffrirCorrect() {
		assertEquals("Resultat insertion : ", true, OffrirService.inserer(new Offrir(MedicamentService.rechercher("BACTI10G"), VisiteService.rechercherVisite("v0025"), 10)));
	}
	
}
