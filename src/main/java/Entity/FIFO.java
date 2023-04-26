package Entity;

import java.util.LinkedList;
import java.util.Queue;

public class FIFO {
    private Queue<Customer> fifoQueue;
    private Cashier cashier;
    public FIFO(Cashier cashier){
        this.cashier = cashier;
        this.fifoQueue = new LinkedList<>();
    }
    public void addCustomerToFIFO(Customer customer){
        fifoQueue.offer(customer);
    }
    public void FIFOcheckout() throws InterruptedException{
        while(!fifoQueue.isEmpty()) {
           cashier.checkOut(fifoQueue.poll());
            System.out.println();
            System.out.println("*******************************************");
            System.out.println();
        }
    }

    public Queue<Customer> getFifoQueue() {
        return fifoQueue;
    }
}
