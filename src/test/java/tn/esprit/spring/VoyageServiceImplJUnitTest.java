package tn.esprit.spring;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.services.IVoyageService;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VoyageServiceImplJUnitTest {
	
	@Autowired
	IVoyageService vs;
	 
	 @Test
	    void retrieveAllVoyages() {
	    	List<Voyage> Voyages = vs.recupererAll();
	        Assertions.assertEquals(0, Voyages.size());
	    }
	 
	 @Test
	    public void testAddVoyage(){
		    List<Voyage> Voyages = vs.recupererAll();
		    int expected = Voyages.size();
		    Voyage v = new Voyage(1234,12,14);
		    Voyage savedVoyage= vs.ajouterVoyage(v);
		    assertEquals(expected+1, vs.recupererAll().size());
		    assertNotNull(savedVoyage.getIdVoyage());
		    vs.supprimerVoyage(savedVoyage);

	    }
	 
	 @Test
	    public void testUpdateVoyage() {
		 	Voyage v = new Voyage(1234,12,14);
		 	Voyage savedVoyage= vs.ajouterVoyage(v);
		    savedVoyage.setCodeVoyage(546);
		    vs.modifierVoyage(savedVoyage);
		    assertEquals(v.getCodeVoyage(),savedVoyage.getCodeVoyage());
		    vs.supprimerVoyage(savedVoyage);
	    }

	 @Test
	    public void testDeleteVoyage() {
		 	Voyage v = new Voyage(1234,12,14);
		 	Voyage savedVoyage= vs.ajouterVoyage(v);
		 	vs.supprimerVoyage(savedVoyage);
		    assertNotNull(savedVoyage.getIdVoyage());

	    }

	
}
