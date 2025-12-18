package com.application.project.TierRound;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tierrounds")
public class TierRoundController {

    private final TierRoundService service;

    public TierRoundController(TierRoundService service) {
        this.service = service;
    }

    @PostMapping
    public TierRound create(@RequestBody TierRound tierRound) {
        return service.createTierRound(tierRound);
    }

    @GetMapping
    public List<TierRound> getAll() {
        return service.getAllTierRounds();
    }

    @GetMapping("/{id}")
    public TierRound getById(@PathVariable Integer id) {
        return service.getTierRoundById(id);
    }

    @PutMapping("/{id}")
    public TierRound update(
            @PathVariable Integer id,
            @RequestBody TierRound tierRound) {
        return service.updateTierRound(id, tierRound);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteTierRound(id);
    }
}
