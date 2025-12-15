package com.application.OnlineSlot;


import jakarta.persistence.*;

@Entity
@Table(name = "onlineslot")
public class OnlineSlot {

    @Id
    private Integer id;

    private Integer slotId;

    private Integer employeeId;

    public OnlineSlot() {}

    public OnlineSlot(Integer slotId, Integer employeeId) {
        this.slotId = slotId;
        this.employeeId = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
