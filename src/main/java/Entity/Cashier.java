package Entity;

import static Entity.ThreadColor.ANSI_GREEN;
import static Entity.ThreadColor.ANSI_RED;

public class Cashier extends Person{
    private int staffID;
    private Store store;
    private String name;
    private boolean isfired;

    private int noOfSales=0;

    public Cashier(String name, Store store, int staffID) {
        super(name);
        this.staffID = staffID;
        this.store = store;

    }


    public synchronized void checkOut(Customer customer) throws InterruptedException{
        for(Product p : customer.getCart()) {
            customer.setAmount(p.getPricePerUnit() * p.getQuantity());
            for(Product product : store.getListOfProduct()){
                if(p.getProductName().equals(product.getProductName())){
                    product.setQuantity(product.getQuantity() - p.getQuantity());
                }
            }
        }
        if (customer.getAmount() <= customer.getWalletBalance()) {
            customer.setWalletBalance(customer.getAmount());
            receipt(customer);
            Thread.sleep(2000);
            setNoOfSales(1);
        } else {
            System.out.println("Insufficient funds.");
        }
    }


    public int getNoOfSales() {
        return noOfSales;
    }

    public void setNoOfSales(int noOfSales) {
        this.noOfSales += noOfSales;
    }

    public int getStaffID() {
        return staffID;
    }

    public boolean isIsfired() {
        return isfired;
    }

    public void setIsfired(boolean isfired) {

        this.isfired = isfired;
    }

    public void receipt(Customer customer) {
        System.out.println(ANSI_GREEN + "Receipt: " + customer.getName());
        for(Product p : customer.getCart()){
            System.out.println("Product: " + p.getProductName() + "\n" + "Price: " + p.getPricePerUnit() + "\n" +
                    "Quantity: " + p.getQuantity() + "\n" + "Amount: " + customer.getAmount());
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Cashier{" + "name: " + this.getName() +
                " staffID: " + staffID +
                '}';
    }
}
