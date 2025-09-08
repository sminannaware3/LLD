import java.util.ArrayList;
import java.util.List;

public class TransactionCoordinator {
    private List<TransactionParticipant> participants;

    public TransactionCoordinator() {
        this.participants = new ArrayList<>();
    }

    public void addParticipant(TransactionParticipant particpant) {
        this.participants.add(particpant);
    }

    public boolean commitTransaction(){
        // check if all participants are ready
        boolean allPrepared = participants.stream().allMatch(p -> p.isReady());

        if (allPrepared) {
            participants.stream().forEach(p -> p.commit());
            System.out.print("Committed the transaction");
            return true;
        } else {
            participants.stream().forEach(p -> p.rollback());
            System.out.println("Rollbacked the transaction. All participants are not ready.");
            return false;
        }
    }
}