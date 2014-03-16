package topcoder;

import java.util.ArrayList;
import java.util.Collections;

public class Birthday {
    public String getNext(String date, String[] birthdays) {
        String[] d = date.split("/");
        ArrayList<String> a = new ArrayList<String>();
        for (String b : birthdays) {
            String[] t = b.split(" ");
            a.add(t[0]);
        }
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++)
            if (a.get(i).compareTo(d[0]) >= 0)
                return a.get(i);
        for (int i = 0; i < a.size(); i++)
            if (a.get(i).compareTo(d[0]) <= 0)
                return a.get(i);
        return "";
    }
}
