public class TwoPhaseCommitExample {
    
    public static void main(String[] args) {
        //Creating participants
        TransactionParticipant participantA = new TransactionParticipant("A");
        TransactionParticipant participantB = new TransactionParticipant("B");
        TransactionParticipant participantC = new TransactionParticipant("C");

        // Create transaction coordinator and add participants
        TransactionCoordinator txCoordinator = new TransactionCoordinator();
        txCoordinator.addParticipant(participantA);
        txCoordinator.addParticipant(participantB);
        txCoordinator.addParticipant(participantC);

        // Execute Transaction commit
        System.out.println("Transaction commit status: " + txCoordinator.commitTransaction());
    }
}