package com.application.project.TierRound;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TierRoundRepository extends JpaRepository<TierRound, Integer> {
}
