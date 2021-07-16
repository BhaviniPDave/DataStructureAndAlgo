package dp;

public class SentenceScreenFittingG {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int N = sentence.length;
        int[] lengths = new int[N];
        int[] memo = new int[N];

        for (int i = 0; i < N; ++i) {
            lengths[i] = sentence[i].length();
        }

        int cur = 0;

        for (int row = 0; row < rows; ++row) {
            if (memo[cur % N] == 0) {
                int temp = cur % N;
                int col = 0;

                while (col + lengths[cur % N] <= cols) {
                    col += (lengths[cur % N] + 1);
                    ++cur;
                    ++memo[temp];
                }
            } else {
                cur += memo[cur % N];
            }
        }

        return cur / N;
    }
    public static void main(String[] args) {
        SentenceScreenFittingG obj = new SentenceScreenFittingG();
        String[] sentence = {"a","bcd","e"};
        int rows = 3;
        int cols = 6;
        System.out.println(obj.wordsTyping(sentence,rows,cols));
    }
}
