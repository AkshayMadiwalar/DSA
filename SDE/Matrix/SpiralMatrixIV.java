package SDE.Matrix;

public class SpiralMatrixIV {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int tr = 0;
        int br = m - 1;
        int lc = 0;
        int rc = n - 1;

        int[][] mat = new int[m][n];

        while (tr < br && lc < rc) {

            for (int i = lc; i <= rc; i++) {
                mat[tr][i] = head == null ? -1 : head.val;
                if (head != null)
                    head = head.next;
            }

            for (int i = tr + 1; i <= br; i++) {
                mat[i][rc] = head == null ? -1 : head.val;
                if (head != null)
                    head = head.next;
            }

            for (int i = rc - 1; i >= lc; i--) {
                mat[br][i] = head == null ? -1 : head.val;
                if (head != null)
                    head = head.next;
            }

            for (int i = br - 1; i > tr; i--) {
                mat[i][lc] = head == null ? -1 : head.val;
                if (head != null)
                    head = head.next;
            }

            tr++;
            br--;
            lc++;
            rc--;
        }

        if (tr == br) {
            for (int i = lc; i <= rc; i++) {
                mat[tr][i] = head == null ? -1 : head.val;
                if (head != null)
                    head = head.next;
            }
            lc++;
            rc--;
        }

        if (lc == rc) {
            for (int i = tr; i <= br; i++) {
                mat[i][lc] = head == null ? -1 : head.val;
                if (head != null)
                    head = head.next;
            }
        }

        return mat;
    }
}



class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}