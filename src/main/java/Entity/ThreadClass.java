package Entity;

public class ThreadClass implements Runnable{
    private final Cashier cashier;
    private Customer customer;


    public ThreadClass(Cashier cashier, Customer customer) {
        this.customer = customer;
       this.cashier = cashier;
    }


    @Override
    public void run() {
        try {
            cashier.checkOut(customer);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
