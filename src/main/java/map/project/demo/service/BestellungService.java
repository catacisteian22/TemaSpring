package map.project.demo.service;

import map.project.demo.model.Bestellung;
import map.project.demo.model.Buch;
import map.project.demo.repository.BestellungRepo;
import map.project.demo.repository.BuchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BestellungService {

    @Autowired
    private BestellungRepo bestellungRepository;

    @Autowired
    private BuchRepo buchRepository;

    public void addBuchToBestellung(Long bestellungId, Long buchId) {
        Bestellung bestellung = bestellungRepository.findById(bestellungId).orElse(null);
        Buch buch = buchRepository.findById(buchId).orElse(null);

        if (bestellung != null && buch != null) {
            bestellung.getListeBucherInBestellung().add(buch);
            buch.getBestellungen().add(bestellung);

            bestellungRepository.save(bestellung);
            buchRepository.save(buch);
        }
    }

}