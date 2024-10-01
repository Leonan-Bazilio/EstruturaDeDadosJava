package singlyLinkedLists;

public class TaskManager {
    private Task head;
    
    public TaskManager() {
        this.head = null;
    }
    
    public
    class Task {
        String description;
        boolean isCompleted;
        Task next;
        
        public Task(String description) {
            this.description = description;
            this.isCompleted = false;
            this.next = null;
        }
    }
    
    public void addTask(String description) {
        Task newTask = new Task(description);
        if (this.head == null) {
            this.head = newTask;
        } else {
            Task currentTask = this.head;
            while (currentTask.next != null) {
                currentTask = currentTask.next;
            }
            currentTask.next = newTask;
        }
        System.out.println("Tarefa Adicionada");
    }
    
    public void removeTask(int index) {
        if (this.head == null) {
            System.out.println("Nenhuma tarefa");
            return;
        }
        
        if (index == 0) {
            this.head = this.head.next;
            System.out.println("tarefa removida");
            return;
        }
        
        Task current = this.head;
        Task prev = null;
        int counter = 0;
        
        while (current != null && counter < index) {
            prev = current;
            current = current.next;
            counter++;
        }
        
        if (current != null) {
            prev.next = current.next;
            System.out.println("Tarefa removida");
        } else {
            System.out.println("Índice inválido");
        }
    }
    
    public void completeTask(int index) {
        Task current = this.head;
        int counter = 0;
        
        while (current != null && counter < index) {
            current = current.next;
            counter++;
        }
        
        if (current != null) {
            current.isCompleted = true;
            System.out.println("Tarefa concluída: " + current.description);
        } else {
            System.out.println("Índice inválido.");
        }
    }
    
    public void listTasks() {
        if (this.head == null) {
            System.out.println("Nenhuma tarefa disponível.");
            return;
        }
        
        Task current = this.head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.description);
            current = current.next;
            index++;
        }
    }
    
    
    public static void main(String[] args) {
        TaskManager taskManeger = new TaskManager();
        taskManeger.addTask("tarefaAleatoria");
        taskManeger.addTask("estavouremover");
        taskManeger.addTask("teste vou completar");
        taskManeger.listTasks();
        taskManeger.completeTask(2);
        taskManeger.removeTask(1);
        taskManeger.listTasks();
    }
}
