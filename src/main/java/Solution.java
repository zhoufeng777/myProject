import java.util.Stack;

public class Solution {

//     #Stage 1
//    For a given string that only contains alphabet characters a-z, if 3 or more consecutive
//    characters are identical, remove them from the string. Repeat this process until
//    there is no more than 3 identical characters sitting besides each other.

    /**
     *
     * @param s  Input String
     * @param needReplace  active replaceChar function
     * @return
     */
    public String removeDuplicates(String s, boolean needReplace) {
        Stack<Pair> stack = new Stack<Pair>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().character == c) {
                stack.peek().count++;
            } else {
                //  remove the consecutively identical characters
                if (!stack.isEmpty() && stack.peek().count > 2) {
                    Pair p = stack.pop();
                    if (needReplace) {
                        //Stage 2 - advanced requirement
                        this.replaceChar(p, stack);
                    }
                    this.stackPushChar(c, stack);
                } else {
                    stack.push(new Pair(c, 1));
                }
            }
        }

        return this.printStack(stack);
    }


//    #Stage 2 - advanced requirement
//    Instead of removing the consecutively identical characters, replace them with a
//    single character that comes before it alphabetically.
    public void replaceChar(Pair p, Stack<Pair> stack) {
        char tempChar = p.character;
        if (p.character != 'a') {
            //replace them with a single character that comes before it alphabetically， except character 'a'
            tempChar = (char) (p.character - 1);
        }
        if (!stack.isEmpty() || p.character != 'a') {
            this.stackPushChar(tempChar, stack);
        }
    }



    public void stackPushChar(char c, Stack<Pair> stack) {
        if (!stack.isEmpty() && c == stack.peek().character) {
            stack.peek().count++;
        } else {
            stack.push(new Pair(c, 1));
        }
    }

    public String printStack(Stack<Pair> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            while (p.count > 0) {
                sb.append(p.character);
                p.count--;
            }
        }
        return sb.reverse().toString();
    }

    class Pair {
        char character;
        int count;

        Pair(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }

// //   (SolutionTest.java) unit test with 100% test coverage
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String inputStr = "aabcccbbad";
//        String result = solution.removeDuplicates(inputStr, true);
//        System.out.println(result);
//
//
//    }
}
