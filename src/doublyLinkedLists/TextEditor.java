package doublyLinkedLists;

class TextEditor {
    private ActionNode currentAction;
    private StringBuilder currentText;
    
    public TextEditor() {
        this.currentAction = null;
        this.currentText = new StringBuilder();
    }
    
    private class ActionNode {
        String action;
        ActionNode prev;
        ActionNode next;
        
        ActionNode(String action) {
            this.action = action;
            this.prev = null;
            this.next = null;
        }
    }
    
    public void addText(String text) {
        this.currentText.append(text);
        ActionNode newAction = new ActionNode(text);
        
        if (this.currentAction != null) {
            this.currentAction.next = newAction;
            newAction.prev = currentAction;
        }
        currentAction = newAction;
    }
    
    public void undo() {
        if (currentAction != null) {
            currentText.delete(currentText.length() - currentAction.action.length(), currentText.length());
            currentAction = currentAction.prev;
        } else {
            System.out.println("Nenhuma ação para desfazer.");
        }
    }
    
    public void redo() {
        if (currentAction != null) {
            this.currentAction = this.currentAction.next;
            
            currentText.append(currentAction.action);
            
        } else {
            System.out.println("Nenhuma ação para refazer.");
        }
    }
    
    public void showText() {
        System.out.println("Texto atual: " + currentText.toString());
    }
    
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        
        editor.addText("Hello ");
        editor.showText();
        
        editor.addText("World! ");
        editor.addText("hunterxhunter!");
        editor.showText();
        
        editor.undo();
        editor.undo();
        editor.showText();
        
        editor.redo();
        editor.redo();
        editor.showText();
    }
}
