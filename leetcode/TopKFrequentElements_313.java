package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequentElements_313 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num))
                counter.put(num, 1);
            else {
                counter.put(num, counter.get(num) + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>();
        entries.addAll(counter.entrySet());
        Collections.sort(entries,
                new Comparator<Map.Entry<Integer, Integer>>() {

                    @Override
                    public int compare(Entry<Integer, Integer> o1,
                            Entry<Integer, Integer> o2) {
                        // TODO Auto-generated method stub
                        return o1.getValue() - o2.getValue();
                    }

                });
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<k;i++){
            res.add(entries.get(i).getKey());
        }
        return res;
            
    }
}
