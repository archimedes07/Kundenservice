package com.example.kundensendungsservice.service;

import com.example.kundensendungsservice.domain.Sendung;
import com.example.kundensendungsservice.repository.SendungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbrechnungsScheduler {

    @Autowired
    private SendungRepository sendungRepository;

    @Scheduled(fixedDelay = 10000)
    public void checkAndUpdateSendungStatus() {
        List<Sendung> sendungen = sendungRepository.findByStatus("eingereicht");
        
        for (Sendung sendung : sendungen) {
            sendung.setStatus("ist abgerechnet");
            System.out.println(sendung);
            sendungRepository.save(sendung);
        }
    }
}