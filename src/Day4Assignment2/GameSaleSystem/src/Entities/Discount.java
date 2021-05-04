package Entities;

import java.time.LocalDate;

public class Discount {

    private int id;

    private LocalDate validUntil;

    private double discountAmount;

    private String[] eligibleCategories;


    public Discount(){
        
    }
    public Discount(int id, LocalDate validUntil, double discountAmount, String[] eligibleCategories) {
        this.id = id;
        this.validUntil = validUntil;
        this.discountAmount = discountAmount;
        this.eligibleCategories = eligibleCategories;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getValidUntil() {
        return this.validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String[] getEligibleCategories() {
        return this.eligibleCategories;
    }

    public void setEligibleCategories(String[] eligibleCategories) {
        this.eligibleCategories = eligibleCategories;
    }

}
