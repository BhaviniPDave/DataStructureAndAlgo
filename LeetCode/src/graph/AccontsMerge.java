package graph;

import java.util.*;

public class AccontsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap();
        Map<String, Integer> emailToID = new HashMap();
        int id = 0;
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        Map<Integer, List<String>> ans = new HashMap();
        for (String email: emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index, x-> new ArrayList()).add(email);
        }
        for (List<String> component: ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0))); //Add Name at first index
        }
        return new ArrayList(ans.values());
    }

    public static void main (String[] args) {
        AccontsMerge obj = new AccontsMerge();
        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = new ArrayList<>();
        account1.add("John");
        account1.add("johnsmith@mail.com");
        account1.add("john_newyork@mail.com");

        List<String> account2 = new ArrayList<>();
        account2.add("John");
        account2.add("johnsmith@mail.com");
        account2.add("john00@mail.com");

        List<String> account3 = new ArrayList<>();
        account3.add("Mary");
        account3.add("mary@mail.com");

        List<String> account4 = new ArrayList<>();
        account4.add("John");
        account4.add("johnnybravo@mail.com");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);

        List<List<String>> results = obj.accountsMerge(accounts);
        for(List<String> result : results) {

        }

    }
}

class DSU {
    int[] parent;
    public DSU() {
        parent = new int[10001];
        for (int i = 0; i <= 10000; ++i)
            parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
