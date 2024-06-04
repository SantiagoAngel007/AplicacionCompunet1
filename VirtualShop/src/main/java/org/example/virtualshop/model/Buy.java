package org.example.virtualshop.model;

public class Buy {

    public Buy(String product, int quantity, double total) {
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }

    public String product;

    public int quantity;

    public double total;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
