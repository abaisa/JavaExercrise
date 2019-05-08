import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class anything {
    PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
    List<Integer> arrayList = new CopyOnWriteArrayList<>();
    Set<Integer> set = new TreeSet<>();
    Iterator<Integer> iterator = arrayList.iterator();
    int a = iterator.next();
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    Iterator<Map.Entry<Integer, Integer>> iterator2 = treeMap.entrySet().iterator();
    NavigableMap<Integer, Integer> navigableMap = treeMap.descendingMap();
    Hashtable<Integer, Integer> hashtable = new Hashtable<>();
    Vector<Integer> vector = new Vector<>();
    Stack<Character> stack = new Stack<>();

    AtomicInteger atomicInteger = new AtomicInteger();
    AtomicReference atomicReference = new AtomicReference();
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    String s = "rqwerqwr";
    char[] chars = s.toCharArray();
}
