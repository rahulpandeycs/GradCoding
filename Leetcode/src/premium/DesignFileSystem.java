package src.premium;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {

    Map<String, Integer> pathMap;
    public DesignFileSystem() {
        pathMap = new HashMap<>();
    }

    public boolean createPath(String path, int value) {

        int idx = path.lastIndexOf('/');
        String parent = path.substring(0,idx);

        if(!pathMap.containsKey(parent)) return false;
        pathMap.putIfAbsent(path, value);
        return true;
    }

    public int get(String path) {
        return pathMap.getOrDefault(path, -1);
    }
}
