import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class m10Cmexpr {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new File("m10.txt"));
        int tests = scanner.nextInt();
        while (tests-- > 0) {
            String tree = scanner.next();
            TreeNode t = new TreeNode(tree, 0, tree.length() - 1);
            System.out.println(t.toStringInOrder());
        }
    }


    static class TreeNode {
        char root;
        TreeNode left;
        TreeNode right;

        TreeNode(String tree, int start, int stop) {

            // remove surrounding parentheses
            boolean mayHaveSurrParenthesis = true;
            while (tree.charAt(start) == '(' && mayHaveSurrParenthesis) {
                int nP = 1;
                int i = start + 1;
                while (nP > 0) {
                    if (tree.charAt(i) == '(') nP++;
                    if (tree.charAt(i) == ')') nP--;
                    i++;
                    // the number of ( and ) must be well-formed and thus nP will get to 0 eventually
                }
                if (i == stop + 1) {
                    start++;
                    stop--;
                } else mayHaveSurrParenthesis = false;
            }

            if (stop == start) {
                root = tree.charAt(start);
                return;
            }

            int opIndex = -1; // index of the operator of the tree
            for (int i = stop; i >= start; i--) {
                if (tree.charAt(i) == ')') {
                    // skip until the corresponding '('
                    int nP = 1;
                    i--;
                    while (nP > 0) {
                        if (tree.charAt(i) == ')') nP++;
                        if (tree.charAt(i) == '(') nP--;
                        i--;
                        // the number of ( and ) must be well-formed and thus nP will get to 0 eventually
                    }
                }
                if (i < start) {
                    // reached the beginning of the string, done
                    break;
                }
                if (tree.charAt(i) == '+' || tree.charAt(i) == '-') {
                    // this is what we are looking for
                    opIndex = i;
                    break;
                }
                if ((tree.charAt(i) == '*' || tree.charAt(i) == '/') && opIndex == -1) {
                    // this is the default candidate
                    opIndex = i;
                }
            }
            left = new TreeNode(tree, start, opIndex - 1);
            root = tree.charAt(opIndex);
            right = new TreeNode(tree, opIndex + 1, stop);
        }

        String toStringInOrder() {
            if (left == null) {
                // a leaf because the binary expression results in full binary trees
                return "" + root;
            }

            String s = "";
            if (left.left != null && precedence(left.root, root) > 0) {
                s += "(" + left.toStringInOrder() + ")";
            } else s += left.toStringInOrder();
            s += root;
            if (right.left != null && (
                    precedence(root, right.root) < 0 ||
                            (precedence(root, right.root) == 0 && (root == '/' || root == '-')))) {
                s += "(" + right.toStringInOrder() + ")";
            } else s += right.toStringInOrder();
            return s;
        }


        /**
         * Returns if the left operator evaluates first than the right
         * The operators can only be *, /, +, -.
         * The order is the typical operator precedence.
         */
        static boolean precedes(char left, char right) {
            if (left == '+' || left == '-') return right == '+' || right == '-';
            if (left == '*' || left == '/') return true;
            return true;
            // * is 42, and + is 43
//            throw new IllegalArgumentException("Must be an operator +, -, * or /, but got " + left + " and " + right);
        }

        /**
         * Lower precedence runs first.
         *
         * @param left
         * @param right
         * @return
         */
        static int precedence(char left, char right) {
            if (left == '+' || left == '-') return (right == '+' || right == '-') ? 0 : +1;
            if (left == '*' || left == '/') return (right == '*' || right == '/') ? 0 : -1;
            return 0;
            // * is 42, and + is 43
//            throw new IllegalArgumentException("Must be an operator +, -, * or /, but got " + left + " and " + right);
        }
    }
}
