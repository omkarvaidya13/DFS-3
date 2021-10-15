public class Main {  
    
    // Time Complexity: O(5^N)
    // Space Complexity: O(1)
    
    private static HashMap<Integer, Integer> map;
    private static int count = 0;
    
    public static int confusingNumberII(int n) {
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        
        dfs(n, 0);
        return count;
    }
    
    private static void dfs(int n, long curr){
        if(isValid(curr))
            count++;
        
        for(int num : map.keySet()){
            long next = curr * 10 + num;
            if(next <= n && next != 0)
                dfs(n, next);
        }
    }
    
    private static boolean isValid(long curr){
        long original = curr;
        long ans = 0;
        
        while(curr > 0){
            ans = ans * 10 + (map.get((int) curr % 10));
            curr = curr / 10;
        }
        return original != ans;
    }
    
    public static void main(String[] args) {       
        int n = 20;
        int result = confusingNumberII(n);
        System.out.println(result);
    }
}