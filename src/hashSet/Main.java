package hashSet;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> conjunto = new HashSet<>();

        conjunto.add(10);
        conjunto.add(20);
        conjunto.add(30);
        conjunto.add(40);
        conjunto.add(50);

        System.out.println(conjunto.contains(10));
        System.out.println(conjunto.contains(100));

        System.out.println(conjunto);
    }
}
