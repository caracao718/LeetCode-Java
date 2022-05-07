import java.util.ArrayList;
import java.util.List;

public class WordSearchII212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode trieNode, List<String> res) {
        char c = board[i][j];
        if (c == '#' || trieNode.next[c - 'a'] == null)
            return;
        trieNode = trieNode.next[c - 'a'];
        if (trieNode.word != null) { // found one
            res.add(trieNode.word);
            trieNode.word = null;
        }
        // backtrack
        board[i][j] = '#'; // mark visited
        if (i > 0)
            dfs(board, i - 1, j, trieNode, res);
        if (j > 0)
            dfs(board, i, j - 1, trieNode, res);
        if (i < board.length - 1)
            dfs(board, i + 1, j, trieNode, res);
        if (j < board[0].length - 1)
            dfs(board, i, j + 1, trieNode, res);
        board[i][j] = c; // backtrack
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
