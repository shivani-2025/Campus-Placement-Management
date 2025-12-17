package com.application.project.tier;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TierRepository extends JpaRepository<Tier, Integer> {

    Optional<Tier> findByTierNumber(Integer tierNumber);
}
