package com.barak.participation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ParticipationService {

    private IParticipationRepository participationRepository;

    @Autowired
    public ParticipationService(IParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public void createParticipation(Participation participation) {
        participationRepository.save(participation);
    }

    public void deleteParticipation(long participationId) {
        participationRepository.deleteById(participationId);
    }

    public void updateParticipation(Participation participation) {
        participationRepository.save(participation);
    }

    public Participation getParticipationById(long participationId) {
        return participationRepository.getById(participationId);
    }

    public List<Participation> getAllParticipations() {
        return participationRepository.findAll();
    }

}
