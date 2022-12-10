package tn.esprit.spring;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.VoyageRepository;
import tn.esprit.spring.services.VoyageServiceImpl;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VoyageServiceImplTest {

@Mock
VoyageRepository vr;
@InjectMocks
VoyageServiceImpl vs;

Voyage v = new Voyage(1234,12,14);

Long getId()
{
    for (Voyage voy: vr.findAll()) {
        return voy.getIdVoyage();
    }
    return 0L;
}
@Test
@Order(0)
void TestaddVoyage() {
	Voyage voy = new Voyage();
    List<Voyage> Voyages = new ArrayList<>();
    for (Long i=1L;i<=10L;i++) {
        voy.setIdVoyage(i);
        voy.setCodeVoyage(50);
        voy.setHeureDepart(8);
        voy.setHeureArrivee(14);
        Voyage vo=vr.save(voy);
        Voyages.add(vo);
    }
    assertEquals(10,Voyages.size());
}
@Test
@Order(3)
void TestdeleteAllVoyage() {
    vr.deleteAll();
    assertEquals(0,vr.findAll().spliterator().estimateSize());
}
@Test
@Order(2)
void TestretrieveVoyage() {
    Mockito.when(vr.findById(Mockito.anyLong())).thenReturn(Optional.of(v));

    Mockito.when(vr.findById(Mockito.anyLong())).thenReturn(Optional.of(v))
    ;
    Voyage voy = vs.recupererVoyageParId(2L);
    Assertions.assertNotNull(voy);


}
@Test
@Order(4)
void TestgetAllVoyage(){
    Iterable<Voyage> Voyages = vr.findAll();
    Assertions.assertNotNull(Voyages);
}

}	
