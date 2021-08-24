package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length)
            return false;

        Map<String,String> map = new HashMap<>();
        for(List<String> pair: similarPairs){
            map.putIfAbsent(pair.get(0),pair.get(1));
            map.putIfAbsent(pair.get(1),pair.get(0));
        }

        for(int i=0;i<sentence1.length;i++) {
            if(sentence1[i].equals(sentence2[i]))
                continue;
            if(!map.containsKey(sentence1[i]))
                return false;
            if(!map.get(sentence1[i]).equals(sentence2[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SentenceSimilarity obj = new SentenceSimilarity();

//        ["an","extraordinary","meal"]
//["one","good","dinner"]
//[["great","good"],["extraordinary","good"],["well","good"],["wonderful","good"],["excellent","good"],["fine","good"],["nice","good"],["any","one"],["some","one"],["unique","one"],["the","one"],["an","one"],["single","one"],["a","one"],["truck","car"],["wagon","car"],["automobile","car"],["auto","car"],["vehicle","car"],["entertain","have"],["drink","have"],["eat","have"],["take","have"],["fruits","meal"],["brunch","meal"],["breakfast","meal"],["food","meal"],["dinner","meal"],["super","meal"],["lunch","meal"],["possess","own"],["keep","own"],["have","own"],["extremely","very"],["actually","very"],["really","very"],["super","very"]]

        String[] sentence1 = {"great","acting","skills"};
        String[] sentence2 = {"fine","drama","talent"};
        List<List<String>> similarPairs = new ArrayList<>();
        List<String> pair1 = new ArrayList<>();
        pair1.add("great");
        pair1.add("fine");
        similarPairs.add(pair1);
        List<String> pair2 = new ArrayList<>();
        pair2.add("acting");
        pair2.add("drama");
        similarPairs.add(pair2);
        List<String> pair3 = new ArrayList<>();
        pair3.add("skills");
        pair3.add("talent");
        similarPairs.add(pair3);

        System.out.println(obj.areSentencesSimilar(sentence1,sentence2,similarPairs));
    }
}
