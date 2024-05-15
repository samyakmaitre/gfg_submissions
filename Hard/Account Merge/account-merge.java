//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] par;

    // Function to merge accounts
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        // Step 1: Map each email to an account index
        Map<String, Integer> emailToAccountMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAccountMap.containsKey(email)) {
                    int existingAccountIndex = emailToAccountMap.get(email);
                    union(i, existingAccountIndex);
                } else {
                    emailToAccountMap.put(email, i);
                }
            }
        }

        // Step 2: Aggregate emails for each root account
        Map<Integer, TreeSet<String>> rootToEmailsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i);
            List<String> account = accounts.get(i);
            rootToEmailsMap.computeIfAbsent(root, k -> new TreeSet<>())
                           .addAll(account.subList(1, account.size()));
        }

        // Step 3: Prepare the result
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, TreeSet<String>> entry : rootToEmailsMap.entrySet()) {
            int root = entry.getKey();
            TreeSet<String> emails = entry.getValue();
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(root).get(0)); // Add the name
            mergedAccount.addAll(emails);
            result.add(mergedAccount);
        }

        return result;
    }

    static int find(int idx) { // Path compression
        if (idx != par[idx]) {
            par[idx] = find(par[idx]);
        }
        return par[idx];
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            par[rootY] = rootX;
        }
    }
}
     