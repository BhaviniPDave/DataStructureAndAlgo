package strings.GuessTheWord;

import strings.GuessTheWord.Master;

public class MasterImpl implements Master {
    @Override
    public int guess(String word) {
        String secret = "acckzz";
        int match = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == secret.charAt(i)) {
                match++;
            }
        }
        return match;
    }
}
