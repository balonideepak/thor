package LLD.votingsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VotingSystemApplication {

    private static final int voters_count = 101;

    public static void main(String[] args) throws InterruptedException {
        VotingSystem votingSystem = VotingSystem.getInstance();
        votingSystem.registerCandidate("C1", "John Doe", "Party A");
        votingSystem.registerCandidate("C2", "Jane Smith", "Party B");

        for (int i = 1; i <= voters_count; i++) {
            votingSystem.registerVoter("V" + i, "Voter " + i, "email" + i);
        }


        votingSystem.startVoting();

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Boolean>> futures = new ArrayList<>();

        for (int i = 1; i <= voters_count; i++) {
            final String voterId = "V" + i;
            final String candidateId = "C" + ((i % 2) + 1);

            futures.add(executor.submit(() ->

                    {
                        try {
                            Thread.sleep(new Random().nextInt(100));
                            return votingSystem.castVote(voterId, candidateId);
                        } catch (Exception e) {
                            System.out.println("Error voting for " + voterId + ": " + e.getMessage());
                            Thread.currentThread().interrupt();
                            return false;
                        }
                    }

            ));
        }

        for (Future<Boolean> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        votingSystem.endVoting();


        Map<String, Integer> results = votingSystem.getCurrentResults();
        System.out.println("\nVoting Results:");
        results.forEach((candidate, votes) ->
                System.out.println(candidate + ": " + votes + " votes"));


        System.out.println("\nAudit Log:");
        votingSystem.getAuditLog().forEach(System.out::println);

        executor.shutdown();


    }
}
