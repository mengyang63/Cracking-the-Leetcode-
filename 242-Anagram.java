// Leetcode 242
// Java solution:

//  Sort Solution: Running time 0(nlogn)
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
            return false;
    }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
}

// Table Solution: Running time O(n)

public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
            return false;
    }
    int[] count = new int[26];
    for(int i = 0；i < s.length(); i++) {
        count[s.charAt(i) - 'a']++;
        count[t.charAt(i) - 'a']--;
    }
    for(int i : count) {
        if (i != 0) {
            return false;
        }
    }
    return true;
}

// Hashmap Solution: Running time O(n)

public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
                return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char str: s.toCharArray()){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        for(char str:t.toCharArray()){
            map.put(str,map.getOrDefault(str,0)-1);

            if(map.get(str)==0){ map.remove(str);break;}
            if(map.get(str)==-1) return false;
        }
        return true;
    }