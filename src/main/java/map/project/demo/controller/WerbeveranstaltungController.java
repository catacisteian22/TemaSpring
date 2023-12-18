package map.project.demo.controller;

import com.example.temaj.repository.KontoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // This means that this class is a Controller
@RequestMapping(path="/werbeveranstaltungController")
public class WerbeveranstaltungController {

    @Autowired
    private KontoRepo kontoRepo;

    public WerbeveranstaltungController(KontoRepo kontoRepo) {
        this.kontoRepo = kontoRepo;
    }

//    public void notifyAllClients(String message) {
//        for (KundeObserver client :) {
//            client.getUpdate(message);
//        }
//    }
//
//    @Override
//    public void subscribe(KundeObserver client) {
//        clients.add(client);
//    }
//
//    @Override
//    public void unsubscribe(KundeObserver client) {
//        clients.remove(client);
//
//    }
}