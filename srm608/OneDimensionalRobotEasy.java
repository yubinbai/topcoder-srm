public class OneDimensionalRobotEasy {
    public int finalPosition(String commands, int A, int B) {
        int curr = 0;
        for (int i = 0; i < commands.length(); i++) {
            if (commands.charAt(i) == 'L' && curr > A * -1)
                curr--;
            else if (commands.charAt(i) == 'R' && curr < B)
                curr++;
        }

        return curr;
    }
}
