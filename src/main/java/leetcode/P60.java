package leetcode;


public class P60 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sbs[i] = new StringBuilder();

        boolean down = true;
        int curRow = 0;

        char[] chs = s.toCharArray();
        for (char c : chs) {
            sbs[curRow].append(c);
            if (curRow < numRows - 1 && down) {
                curRow++;
            } else if (curRow > 0 && !down) {
                curRow--;
            } else if (curRow == numRows - 1 && down) {
                down = false;
                curRow = numRows - 2;
            } else if (curRow == 0 && !down) {
                down = true;
                curRow = 1;
            }
        }
        String res = "";
        for (int i = 0; i < numRows; i++) {
            res += sbs[i].toString();
        }

        System.out.println(res);
    }

}

