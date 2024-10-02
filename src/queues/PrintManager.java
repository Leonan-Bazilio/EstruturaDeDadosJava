package queues;

public class PrintManager {
    
    class ItemToPrint {
        String itemName;
        ItemToPrint next;
        
        public ItemToPrint(String itemName) {
            this.itemName = itemName;
            this.next = null;
        }
    }
    
    private ItemToPrint first;
    private ItemToPrint last;
    
    public PrintManager() {
        this.first = null;
        this.last = null;
    }
    
    public void addPrintQueue(String itemName) {
        ItemToPrint newPrint = new ItemToPrint(itemName);
        if (last == null) {
            first = last = newPrint;
        } else {
            last.next = newPrint;
            last = newPrint;
        }
    }
    
    public void nextPrint() {
        if (first == null) {
            System.out.println("Nenhum item para imprimir na fila.");
            return;
        }
        
        ItemToPrint nextPrint = first;
        System.out.println(nextPrint.itemName + " foi impresso");
        first = first.next;
        
        if (first == null) {
            last = null;
        }
    }
    
    public void showQueue() {
        ItemToPrint current = first;
        while (current != null) {
            System.out.print(current.itemName + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        PrintManager manager = new PrintManager();
        
        manager.addPrintQueue("Documento1.pdf");
        manager.addPrintQueue("Documento2.pdf");
        manager.addPrintQueue("Documento3.pdf");
        manager.showQueue();
        
        manager.nextPrint();
        manager.nextPrint();
        manager.showQueue();
        
    }
}

