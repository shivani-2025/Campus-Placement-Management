package com.application.project.TierRound;

import com.application.project.DetailedRound.DetailedRound;
import com.application.project.TierTotalRound.TierTotalRound;

import jakarta.persistence.*;

@Entity
@Table(name = "tierround")
public class TierRound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tierTotalRoundId")
    private TierTotalRound tierTotalRound;

    @ManyToOne
    @JoinColumn(name = "detailedRoundId")
    private DetailedRound detailedRound;

    public TierRound() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TierTotalRound getTierTotalRound() {
        return tierTotalRound;
    }

    public void setTierTotalRound(TierTotalRound tierTotalRound) {
        this.tierTotalRound = tierTotalRound;
    }

    public DetailedRound getDetailedRound() {
        return detailedRound;
    }

    public void setDetailedRound(DetailedRound detailedRound) {
        this.detailedRound = detailedRound;
    }
}
