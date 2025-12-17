package com.application.project.slot;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SlotService {

    private final SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public Slot createSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    public Slot getSlotById(Integer id) {
        return slotRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Slot not found with id: " + id));
    }

    public Slot updateSlot(Integer id, Slot updatedSlot) {
        Slot existing = getSlotById(id);

        existing.setDrive(updatedSlot.getDrive());
        existing.setStartTime(updatedSlot.getStartTime());
        existing.setEndTime(updatedSlot.getEndTime());

        return slotRepository.save(existing);
    }

    public void deleteSlot(Integer id) {
        slotRepository.deleteById(id);
    }
}
