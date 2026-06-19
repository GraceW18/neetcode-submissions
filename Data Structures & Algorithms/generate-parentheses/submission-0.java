class Solution {
    public List<String> generateParenthesis(int n) {
        // valid parentheses have sam num of open + closed
        List<String> answer = new ArrayList<>();
        StringBuilder stack = new StringBuilder(); // keeping track of open + close
        backtrack(0, 0, n, answer, stack);
        return answer;
    }
    private void backtrack(int open, int closed, int n, List<String> ans, StringBuilder stack) {
        if (open == closed && open == n) {
            ans.add(stack.toString());
            return;
        }
        if (open < n) {
            stack.append('(');
            backtrack(open + 1, closed, n, ans, stack);
            stack.deleteCharAt(stack.length() - 1); // stack is lifo
        }
        if (closed < open) {
            stack.append(')');
            backtrack(open, closed + 1, n, ans, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
