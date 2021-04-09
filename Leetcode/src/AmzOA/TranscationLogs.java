package src.AmzOA;

import java.util.*;

public class TranscationLogs {

    public static List<String> getUserIds(List<String> logs, int threshold) {
        HashMap<String, Integer> mp = new HashMap<>();
        for(String log : logs){
            String[] split = log.split(" ");
            mp.put(split[0], mp.getOrDefault(split[0],0) +1);
            if(!split[1].equals(split[0])){
                mp.put(split[1], mp.getOrDefault(split[1],0) +1);
            }
        }

        List<String> output = new ArrayList<>();
        for(String key : mp.keySet()){
            if(mp.get(key) >= threshold)
                output.add(key);
        }

        Collections.sort(output);
        return output;


    }

}
