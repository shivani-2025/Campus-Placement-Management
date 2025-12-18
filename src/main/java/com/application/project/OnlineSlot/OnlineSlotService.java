package com.application.project.OnlineSlot;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OnlineSlotService {

    private final OnlineSlotRepository repository;

    public OnlineSlotService(OnlineSlotRepository repository) {
        this.repository = repository;
    }

    public OnlineSlot createOnlineSlot(OnlineSlot onlineSlot) {
        return repository.save(onlineSlot);
    }

    public List<OnlineSlot> getAllOnlineSlots() {
        return repository.findAll();
    }

    public OnlineSlot getOnlineSlotById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("OnlineSlot not found for id: " + id));
    }

    public OnlineSlot updateOnlineSlot(Integer id, OnlineSlot updated) {
        OnlineSlot existing = getOnlineSlotById(id);

        existing.setSlot(updated.getSlot());
        existing.setEmployee(updated.getEmployee());

        return repository.save(existing);
    }

    public void deleteOnlineSlot(Integer id) {
        repository.deleteById(id);
    }
}
