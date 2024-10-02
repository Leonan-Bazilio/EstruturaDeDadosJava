package queues;

public class ProcessQueue {
    
    class Process {
        String processName;
        Process next;
        
        public Process(String processName) {
            this.processName = processName;
            this.next = null;
        }
    }
    
    private Process first;
    private Process last;
    
    public ProcessQueue() {
        this.first = null;
        this.last = null;
    }
    
    public void addProcess(String processName) {
        Process newProcess = new Process(processName);
        if (last == null) {
            first = last = newProcess;
        } else {
            last.next = newProcess;
            last = newProcess;
        }
        System.out.println(processName + " adicionado");
    }
    
    public void executeNextProcess() {
        if (first == null) {
            System.out.println("Nenhum processo na fila");
            return;
        }
        
        Process nextProcess = first;
        System.out.println("Executando " + nextProcess.processName);
        first = first.next;
        
        if (first == null) {
            last = null;
        }
    }
    
    public static void main(String[] args) {
        ProcessQueue processQueue = new ProcessQueue();
        
        processQueue.addProcess("Processo1");
        processQueue.addProcess("Processo2");
        processQueue.addProcess("Processo3");
        
        processQueue.executeNextProcess();
        processQueue.executeNextProcess();
    }
}
