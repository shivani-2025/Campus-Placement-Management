package com.application.project.slot;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/slots")
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping
    public Slot createSlot(@RequestBody Slot slot) {
        return slotService.createSlot(slot);
    }

    @GetMapping
    public List<Slot> getAllSlots() {
        return slotService.getAllSlots();
    }

    @GetMapping("/{id}")
    public Slot getSlotById(@PathVariable Integer id) {
        return slotService.getSlotById(id);
    }

    @PutMapping("/{id}")
    public Slot updateSlot(
            @PathVariable Integer id,
            @RequestBody Slot slot) {
        return slotService.updateSlot(id, slot);
    }

    @DeleteMapping("/{id}")
    public String deleteSlot(@PathVariable Integer id) {
        slotService.deleteSlot(id);
        return "Slot deleted successfully";
    }
}
