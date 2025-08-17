

public class TransactionParticipant {
    private boolean ready;
    private String name;

    public TransactionParticipant(String name) {
        this.name = name;
        this.ready = false;
    }

    public void commit() {
        // Committing the transaction
        if (this.ready) {
            System.out.println(this.name + ": Commiting transaction");
            this.ready = false;
        } else {
            System.out.println(this.name + ": Cannot commit, not prepared");
        }
    }

    public boolean isReady(){
        if (Math.random() > 0.1) {
            System.out.println(this.name + ": Ready");
            this.ready = true;
        } else {
            System.out.println(this.name + ": Not ready");
        }
        return this.ready;
    }

    public void rollback() {
        System.err.println(this.name + "Rolling back transaction");
        this.ready = false;
    }
}