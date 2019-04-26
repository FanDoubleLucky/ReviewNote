package Foundation;

import java.util.HashSet;

public class MyHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(6);
        set.add(3);
        for (int i :
                set) {
            System.out.println(i);
        }

        HashSet<inner> s = new HashSet<>();
        s.add(new inner("Djie"));
        s.add(new inner("YG"));
        s.add(new inner("HML"));
        s.add(new inner("Djie"));
        for (inner in :
                s) {
            System.out.println(in.name);
        }
        inner n = new inner("Djie");
        inner m = new inner("Djie");
        System.out.println(m==n);
        System.out.println(m.equals(n));
    }

    private static class inner{
        private String name;
        private inner(String name){
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            inner ob = (inner)obj;
            return this.name==ob.name;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode();
        }
    }
}
