package topcoder;

import java.util.HashMap;

public class CeyKaps {
    public String decipher(String typed, String[] switches) {
        HashMap<Character, Character> m = new HashMap<Character, Character>();
        for (int i = 0; i < 26; i++) {
            Character a = (char) (65 + i);
            m.put(a, a);
        }

        for (String s : switches) {
            char from = s.charAt(0);
            char to = s.charAt(2);
            Character a = m.get(from), b = m.get(to);
            m.put(from, b);
            m.put(to, a);
        }
        HashMap<Character, Character> m2 = new HashMap<Character, Character>();
        for(Character c : m.keySet()) {
            m2.put(m.get(c), c);
        }

        char[] t = typed.toCharArray();
        for (int i = 0; i < t.length; i++) {
            t[i] = m2.get(t[i]);
        }
        return String.valueOf(t);
    }
}
