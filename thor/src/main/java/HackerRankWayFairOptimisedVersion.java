import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class HackerRankWayFairOptimisedVersion {



    //https://carloarg02.medium.com/my-favorite-coding-question-to-give-candidates-17ea4758880c

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        List<String> logfile1 = new ArrayList<String>();
        List<String> logfile2 = new ArrayList<String>();
        
        String pageVisit = br.readLine();
        while (pageVisit != null) {
            if (pageVisit.startsWith("logfile_1")) {
                logfile1.add(pageVisit.replace("logfile_1,", ""));
            } else if (pageVisit.startsWith("logfile_2")) {
                logfile2.add(pageVisit.replace("logfile_2,", ""));
            }
            pageVisit = br.readLine();
        }
        
        // Write your code here
        
        // Use PrintWiter out to print results, expected output... list of loyal customerid delimited by line separator.



        TreeMap<String , Set<String>> customerAuditForDay1 =new TreeMap();
        for(String log1 : logfile1){
        populateUserTrackingInfo(customerAuditForDay1 , log1);
        
        }

        TreeMap<String , Set<String>> customerAuditForDay2 =new TreeMap();
        for(String log2 : logfile2){ 
        populateUserTrackingInfo(customerAuditForDay2 , log2);
        }
        


        for(Map.Entry<String , Set<String>> customer : customerAuditForDay1.entrySet()){
            
            if( customerAuditForDay2.containsKey(customer.getKey()) ) {
                Set<String> productsVisitedOnDay1 = customer.getValue(); 
                Set<String> productsVisitedOnDay2 = customerAuditForDay2.get(customer.getKey());
                
                Set<String> totalUniqueProducts = new HashSet();
                totalUniqueProducts.addAll(productsVisitedOnDay1);
                totalUniqueProducts.addAll(productsVisitedOnDay2);
                  
                if(totalUniqueProducts.size() >= 2)
                {
                    System.out.println(customer.getKey());
                }
            }
        }
    
        
        out.flush();
        out.close();
    }
    
    
    private static void populateUserTrackingInfo(TreeMap<String , Set<String>> map
    , String log){
    String[] userTrackingInfo = log.split(",");
        if( !map.containsKey(userTrackingInfo[1]) ){
            Set<String> set = new HashSet();
            set.add(userTrackingInfo[2]);
            map.put(userTrackingInfo[1] , set);
        }
        else{
            Set<String> set = map.get(userTrackingInfo[1]);
            set.add(userTrackingInfo[2]);
        }
    }



}