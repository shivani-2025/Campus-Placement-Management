package com.application.TierTotalRound;

import jakarta.persistence.*;

@Entity
@Table(name = "tiertotalround")
public class TierTotalRound {

    @Id
    private Integer id;

    private Integer totalRounds;

    public TierTotalRound() {}

    public TierTotalRound(Integer totalRounds) {
        this.totalRounds = totalRounds;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTotalRounds() {
        return totalRounds;
    }

    public void setTotalRounds(Integer totalRounds) {
        this.totalRounds = totalRounds;
    }
}
