package string.atlassian.leetcode.ratelimiter;

public class RateLimiterApp {

    public static void main(String[] args) {
        RateLimiterManager rateLimiterManager = RateLimiterManager.getInstance("sliding");

        String clientId = "client1";

        // Simulate requests
        for (int i = 0; i < 10; i++) {
            if (rateLimiterManager.allowRequest(clientId)) {
                System.out.println("Request allowed for " + clientId);
            } else {
                System.out.println("Request denied for " + clientId);
            }
        }
    }
}
