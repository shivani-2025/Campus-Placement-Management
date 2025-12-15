package com.application.OnlineSlot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnlineSlotRepository extends JpaRepository<OnlineSlot, Integer> {

}
