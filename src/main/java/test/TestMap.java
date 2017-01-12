package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zgc on 2016/12/15.
 */
public class TestMap implements Runnable {

    private static Map<Character, Character> map = new HashMap<>();
    private static int index = 1;

    @Override
    public void run() {
        do {
            for (int i = 0; i < 26; i++) {
                map.put((char) ('a' + i), (char) ('a' + i));
                map.put((char) ('A' + i), (char) ('A' + i));
            }
        } while (index % 20 != 0);
        for (char key : map.keySet()) {
            if (key != map.get(key)) {
                System.out.println(key + ":" + map.get(key));
            }
        }
    }

    public static void main(String[] args) {
        TestMap testMap = new TestMap();
        for (; index <= 200; index++) {
            new Thread(testMap).start();
        }
    }
}

