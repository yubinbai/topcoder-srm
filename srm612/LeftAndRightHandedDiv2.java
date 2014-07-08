package topcoder;

public class LeftAndRightHandedDiv2 {
    public int count(String S) {
        return S.length() - S.replaceAll("RL", " ").length();
    }
}
