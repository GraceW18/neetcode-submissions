class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] col = new HashSet[9];
        Set<Character>[] box = new HashSet[9];
        for (int i = 0; i < 9; i++) { // 9x9 board
            // overlapping parts such that duplicates can be checked
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') {
                    continue; // skipping empty cells
                }
                int boxIndex = (r / 3) * 3 + (c / 3); // note, starting at 0
                // checking if ANY of sets has value (dupe)
                if (!row[r].add(val) || !col[c].add(val) || !box[boxIndex].add(val)) {
                    return false;
                }
            }
        }
        return true;
    }
}
