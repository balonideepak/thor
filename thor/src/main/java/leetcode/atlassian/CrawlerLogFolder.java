package leetcode.atlassian;

public class CrawlerLogFolder {

    public static void main(String[] args) {

        String[] logs = {"d1/","d2/","../","d21/","./"};

        int result1 = minOperations(logs);
        System.out.println(result1);

        int result2 = minOperations2(logs);
        System.out.println(result2);

    }


    public static int minOperations(String[] logs) {

        int res = 0;
        for (String log : logs) {

            if (log.equals("../")) {
                if (res > 0) {
                    res--;
                }
            } else if (!(log.equals("./"))) {
                res++;
            }
        }

        return res;

    }

    public static int minOperations2(String[] logs) {

        String path = "main";

        for (String logPattern : logs) {


            if (! ( logPattern.equalsIgnoreCase("../") || logPattern.equalsIgnoreCase("./" )) ) {
                int indeOflogPattern = logPattern.lastIndexOf("/");
                logPattern = logPattern.substring(0, indeOflogPattern);
            }


            if ("../".equalsIgnoreCase(logPattern)) {
                if (path.contains("/")) {
                    int indexOf = path.lastIndexOf("/");
                    path = path.substring(0, indexOf);
                }
            } else if ("./".equalsIgnoreCase(logPattern)) {
                //no change
            } else {
                path = path + "/" + logPattern;
            }
        }

        String[] pathArr = path.split("/");
        return pathArr.length-1;

    }
}
