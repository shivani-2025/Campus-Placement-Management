package com.application.TierTotalRound;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiers")
@CrossOrigin
public class TierTotalRoundController {

    private final TierTotalRoundService service;

    public TierTotalRoundController(TierTotalRoundService service) {
        this.service = service;
    }

    @GetMapping
    public List<TierTotalRound> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TierTotalRound getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public TierTotalRound create(@RequestBody TierTotalRound tier) {
        return service.save(tier);
    }

    @PutMapping("/{id}")
    public TierTotalRound update(
            @PathVariable Integer id,
            @RequestBody TierTotalRound tier) {

        TierTotalRound existing = service.getById(id);
        if (existing == null) return null;

        existing.setTotalRounds(tier.getTotalRounds());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
