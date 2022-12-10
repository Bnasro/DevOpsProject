package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.TrainRepository;
import tn.esprit.spring.repository.VoyageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VoyageServiceImpl implements IVoyageService {
    @Autowired
    VoyageRepository voyageRepository;
    @Autowired
    TrainRepository trainRepository;
    @Override
    public Voyage ajouterVoyage(Voyage v) {
        return voyageRepository.save(v);
    }

    @Override
    public void modifierVoyage(Voyage v) {
		voyageRepository.save(v);
    }


    public void affecterTrainAVoyage(Long idTrain, Long idVoyage) {
    	Optional<Train> train = trainRepository.findById(idTrain);
    	Optional<Voyage> voyage = voyageRepository.findById(idVoyage);
    	if(voyage.isPresent() && train.isPresent()) {
    		Train t = train.get();
    		Voyage v = voyage.get();
    		 v.setTrain(t);
    	     voyageRepository.save(v);
    	}  
    }

    @Override
    public List<Voyage> recupererAll() {
        return (List<Voyage>) voyageRepository.findAll();
    }

    @Override
    public Voyage recupererVoyageParId(long idVoyage) {
        return voyageRepository.findById(idVoyage).orElse(null);
    }

    @Override
    public void supprimerVoyage(Voyage v) {
    	voyageRepository.deleteById(v.getIdVoyage());
    }

}
