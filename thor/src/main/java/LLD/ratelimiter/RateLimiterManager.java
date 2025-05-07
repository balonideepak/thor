package LLD.ratelimiter;

public class RateLimiterManager {
    private static RateLimiterManager instance;
    private static String rateLimiterType;
    private RateLimiter rateLimiter;

    private RateLimiterManager() {
        this.rateLimiter = RateLimiterFactory.createRateLimiter(rateLimiterType, 5, 60000);
    }


    // Overloaded method to set the rate limiter type
    public static RateLimiterManager getInstance(String rateLimiterAlgoType) {
        if (instance == null) {
            synchronized (RateLimiterManager.class) {
                rateLimiterType=rateLimiterAlgoType;
                instance = new RateLimiterManager();

            }

        }
        return instance;
    }

    public boolean allowRequest(String clientId) {
        return rateLimiter.allowRequest(clientId);
    }
}
