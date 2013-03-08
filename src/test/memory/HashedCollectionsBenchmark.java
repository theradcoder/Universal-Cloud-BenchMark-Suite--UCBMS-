
package test.memory;

import framework.SimpleBenchmark;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * How do the various hash maps compare?
 */
public class HashedCollectionsBenchmark extends SimpleBenchmark
{
    public void timeHashMapGet(int reps) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("hello", "world");
        for (int i = 0; i < reps; ++i) {
            map.get("hello");
        }
    }
    public void timeHashMapGet_Synchronized(int reps) {
        HashMap<String, String> map = new HashMap<String, String>();
        synchronized (map) {
            map.put("hello", "world");
        }
        for (int i = 0; i < reps; ++i) {
            synchronized (map) {
                map.get("hello");
            }
        }
    }
    public void timeHashtableGet(int reps) {
        Hashtable<String, String> map = new Hashtable<String, String>();
        map.put("hello", "world");
        for (int i = 0; i < reps; ++i) {
            map.get("hello");
        }
    }
    public void timeLinkedHashMapGet(int reps) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("hello", "world");
        for (int i = 0; i < reps; ++i) {
            map.get("hello");
        }
    }
    public void timeConcurrentHashMapGet(int reps) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
        map.put("hello", "world");
        for (int i = 0; i < reps; ++i) {
            map.get("hello");
        }
    }
}
