package singlyLinkedLists;

class BrowserHistory {
    private Node head;
    private int size;
    private final int maxSize;
    
    public BrowserHistory() {
        this.maxSize = 3;
        this.size = 0;
        this.head = null;
    }
    
    private class Node {
        String url;
        Node next;
        
        Node(String url) {
            this.url = url;
            this.next = null;
        }
    }
    
    public void addUrl(String url) {
        Node newUrl = new Node(url);
        
        if (this.head == null) {
            this.head = newUrl;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUrl;
        }
        size++;
        
        if (size > this.maxSize) {
            removeOldestUrl();
        }
    }
    
    
    private void removeOldestUrl() {
        this.head = this.head.next;
        size--;
    }
    
    
    public void printHistory() {
        Node current = this.head;
        System.out.println("Historico de Navegação:");
        while (current != null) {
            System.out.println(current.url);
            current = current.next;
        }
    }
    
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();
        
        history.addUrl("teste1");
        history.addUrl("tedte2");
        
        history.printHistory();
        
        history.addUrl("teste3");
        history.addUrl("teste4");
        history.addUrl("teste5");
        history.addUrl("teste6");
        
        history.printHistory();
    }
}

