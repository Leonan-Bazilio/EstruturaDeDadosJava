package singlyLinkedLists;

class TextEditor {
    private ActionNode head;
    private StringBuilder currentText;
    
    public TextEditor() {
        this.head = null;
        this.currentText = new StringBuilder();
    }
    
    private class ActionNode {
        String action;
        ActionNode next;
        
        ActionNode(String action) {
            this.action = action;
            this.next = null;
        }
    }
    
    public void addText(String text) {
        currentText.append(text);
        addAction(text);
        System.out.println("Texto adicionado:" + text);
    }
    
    private void addAction(String action) {
        ActionNode newAction = new ActionNode(action);
        newAction.next = head;
        this.head = newAction;
    }
    
    public void undo() {
        if (head != null) {
            String lastAction = head.action;
            head = head.next;
            currentText.delete(currentText.length() - lastAction.length(), currentText.length());
            System.out.println("Ultima ação desfeita:" + lastAction);
        } else {
            System.out.println("Nenhuma ação para desfazer");
        }
    }
    
    public void showText() {
        System.out.println("Texto atual: " + currentText.toString());
    }
    
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        
        editor.addText("Hello ");
        editor.showText();
        
        editor.addText("World!");
        editor.showText();
        
        editor.undo();
        editor.showText();
        
        editor.undo();
        editor.showText();
        
        editor.undo();
    }
}
