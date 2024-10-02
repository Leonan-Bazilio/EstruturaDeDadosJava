package queues;

public class BankQueue {
    
    class Node {
        String name;
        Node next;
        
        public Node(String name) {
            this.name = name;
            this.next = null;
        }
    }
    
    private Node first;
    private Node last;
    
    public BankQueue() {
        this.first = null;
        this.last = null;
    }
    
    public void addCustomer(String name) {
        Node newCustomer = new Node(name);
        if (last == null) {
            first = last = newCustomer;
        } else {
            last.next = newCustomer;
            last = newCustomer;
        }
    }
    
    public void callNextCustomer() {
        if (first == null) {
            System.out.println("fila vazia");
            return;
        }
        first = first.next;
        
        if (first == null) {
            last = null;
        }
    }
    
    public void showQueue() {
        Node current = first;
        while (current != null) {
            System.out.print(current.name + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        BankQueue simulator = new BankQueue();
        
        simulator.addCustomer("Jumpei");
        simulator.addCustomer("Bochi");
        simulator.addCustomer("killua");
        simulator.addCustomer("Sukuna");
        simulator.showQueue();
        
        simulator.callNextCustomer();
        simulator.callNextCustomer();
        simulator.callNextCustomer();
        simulator.addCustomer("Kaguya");
        simulator.showQueue();
    }
}
