package com.java8.edu.java_interview.exam3;

public class Product {
    /**
     * 产品单价
     */
    private Long unitPrice;
    /**
     * 产品数量
     */
    private int quantity;
    /**
     * 产品分摊所得金额
     */
    private Long amount;

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}