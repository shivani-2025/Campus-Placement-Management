package com.application.project.OnlineSlot;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/onlineslots")
public class OnlineSlotController {

    private final OnlineSlotService service;

    public OnlineSlotController(OnlineSlotService service) {
        this.service = service;
    }

    @PostMapping
    public OnlineSlot create(@RequestBody OnlineSlot onlineSlot) {
        return service.createOnlineSlot(onlineSlot);
    }

    @GetMapping
    public List<OnlineSlot> getAll() {
        return service.getAllOnlineSlots();
    }

    @GetMapping("/{id}")
    public OnlineSlot getById(@PathVariable Integer id) {
        return service.getOnlineSlotById(id);
    }

    @PutMapping("/{id}")
    public OnlineSlot update(
            @PathVariable Integer id,
            @RequestBody OnlineSlot onlineSlot) {
        return service.updateOnlineSlot(id, onlineSlot);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteOnlineSlot(id);
        return "OnlineSlot deleted successfully";
    }
}
