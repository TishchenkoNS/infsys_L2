package com.example.testt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item;
    private float amount;

    protected Expense() {
    }

    protected Expense(String item, float amount) {
        this.item = item;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return id + ". " + item + " - " + amount + " USD";
    }
}
