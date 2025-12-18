package com.application.project.OnlineSlot;

import com.application.project.Employee.Employee;
import com.application.project.slot.Slot;

import jakarta.persistence.*;

@Entity
@Table(name = "onlineslot")
public class OnlineSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FK → slot.id
    @ManyToOne
    @JoinColumn(name = "slotId", referencedColumnName = "id")
    private Slot slot;

    // FK → employee.id
    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "id")
    private Employee employee;

    public OnlineSlot() {}

    // -------- Getters & Setters --------

    public Integer getId() {
        return id;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
