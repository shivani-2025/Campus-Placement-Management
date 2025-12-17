package com.application.project.TierTotalRound;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TierTotalRoundRepository extends JpaRepository<TierTotalRound, Integer> {

    Optional<TierTotalRound> findByTier_Id(Integer tierId);
}
