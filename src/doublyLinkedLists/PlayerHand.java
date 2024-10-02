package doublyLinkedLists;

public class PlayerHand {
    
    class Node {
        String card;
        Node prev;
        Node next;
        
        public Node(String card) {
            this.card = card;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node first;
    private Node last;
    private int size;
    
    public PlayerHand() {
        first = null;
        last = null;
        size = 0;
    }
    
    public void addCard(String card) {
        Node newNode = new Node(card);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }
    
    public void removeCard(int index) {
        if (index < 0 || index >= size) {
            System.out.println("indice invalido");
            return;
        }
        
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            this.first = current.next;
        }
        
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            last = current.prev;
        }
        
        size--;
    }
    
    private Node getNode(int index) {
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    
    public void moveCard(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex >= size || toIndex < 0 || toIndex >= size) {
            System.out.println("indice invalido");
            return;
        }
        
        if (fromIndex == toIndex) return;
        
        Node cardToMove = getNode(fromIndex);
        removeCard(fromIndex);
        
        if (toIndex == 0) {
            cardToMove.next = first;
            first.prev = cardToMove;
            first = cardToMove;
        } else {
            Node current = getNode(toIndex - 1);
            cardToMove.next = current.next;
            cardToMove.prev = current;
            
            if (current.next != null) {
                current.next.prev = cardToMove;
            } else {
                last = cardToMove;
            }
            current.next = cardToMove;
        }
        size++;
    }
    
    
    public void showHand() {
        Node current = first;
        System.out.print("Mão do jogador: ");
        while (current != null) {
            System.out.print(current.card + ", ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        PlayerHand hand = new PlayerHand();
        
        hand.addCard("as");
        hand.addCard("rei");
        hand.addCard("2");
        hand.addCard("3");
        hand.showHand();
        
        hand.removeCard(1);
        hand.showHand();
        
        hand.moveCard(2, 0);
        hand.showHand();
    }
}
