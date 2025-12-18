package com.application.project.TierTotalRound;

import com.application.project.tier.Tier;

import jakarta.persistence.*;

@Entity
@Table(name = "tiertotalround")
public class TierTotalRound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer totalRounds;

    // FK → tier.id
    @ManyToOne
    @JoinColumn(name = "tier", referencedColumnName = "id")
    private Tier tier;

    public TierTotalRound() {}

    // ---------- Getters & Setters ----------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalRounds() {
        return totalRounds;
    }

    public void setTotalRounds(Integer totalRounds) {
        this.totalRounds = totalRounds;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }
}
