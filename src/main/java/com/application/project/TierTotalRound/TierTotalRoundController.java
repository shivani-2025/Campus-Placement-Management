package com.application.project.TierTotalRound;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tiertotalround")
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

    @GetMapping("/tier/{tierId}")
    public TierTotalRound getByTierId(@PathVariable Integer tierId) {
        return service.getByTierId(tierId);
    }

    @PostMapping
    public TierTotalRound create(@RequestBody TierTotalRound tierTotalRound) {
        return service.save(tierTotalRound);
    }

    @PutMapping("/{id}")
    public TierTotalRound update(
            @PathVariable Integer id,
            @RequestBody TierTotalRound updated) {

        TierTotalRound existing = service.getById(id);

        existing.setTotalRounds(updated.getTotalRounds());
        existing.setTier(updated.getTier());

        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
