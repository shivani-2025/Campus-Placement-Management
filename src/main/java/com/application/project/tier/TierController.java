package com.application.project.tier;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tier")
public class TierController {

    private final TierService service;

    public TierController(TierService service) {
        this.service = service;
    }

    @PostMapping
    public Tier create(@RequestBody Tier tier) {
        return service.create(tier);
    }

    @GetMapping
    public List<Tier> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Tier getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping("/number/{tierNumber}")
    public Tier getByTierNumber(@PathVariable Integer tierNumber) {
        return service.getByTierNumber(tierNumber);
    }

    @PutMapping("/{id}")
    public Tier update(
            @PathVariable Integer id,
            @RequestBody Tier tier) {
        return service.update(id, tier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
