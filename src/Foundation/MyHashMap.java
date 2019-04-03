package Foundation;


import java.util.Collection;
import java.util.Map;
import java.util.Set;


public class MyHashMap<K, V> implements Map<K, V>{

    transient int size;

    transient static Entry[] DEFAULT_EMPTY = {};

    private int DEFAULT_LENGTH = 16;

    private static int MAX_DEFAULT = 1024;

    private Entry[] table;

    private static int flag = 0;

    int threshold;//HashMap在进行扩容时需要参考threshold

    final float loadFactor;//负载因子，代表了table的填充度有多少，默认是0.75

    transient int modCount;

    /**HashMap的构造函数，在HashMap的构造函数中，并没有给table分配内存空间，在真正put时才会构建table***/
    public MyHashMap(int initCapacity, float loadFactor){
        if (initCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initCapacity);

        initCapacity = Math.min(initCapacity, MAX_DEFAULT);
        threshold = initCapacity;
        if(loadFactor<0||Float.isNaN(loadFactor)){
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        }
        this.loadFactor = loadFactor;
    }

    /****inflateTable是为table分配内存，之后依据key算出桶下标：key---------->hash---------------->index，查看table[inedx]处是否已经存在Key为key的Entry，此处要用到hashCode对比和key之间的equals，这里也是为什么重写equals要重写hashCode的原因之一，如果存在就更新Value，不存在的话就addEntry*/
    /*                                                        hash(key)    indexFor(hash,len)     */
    /*                                                     key.hashCode()     hash&(len-1)        */
    /*put过程包括put() inflateTable(), roundUpToPowerOf2(), hash(), indexFor(), addEntry()*/
    public V put(K k, V v){
        if(table == DEFAULT_EMPTY){
            inflateTable(threshold);
        }

        int hash = hash(k);
        int i = indexFor(hash, table.length);

        for(Entry e = table[i]; e!=null; e = e.next){
            Object key = k;
            if(e.hash == hash&&(key == e.key||key.equals(e.key))){
                V oldValue = (V) e.value;
                e.value = v;
                return oldValue;
            }
        }
        addEntry(hash, k, v, i);

        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    private void addEntry(int hash, K k, V v, int index){

    }

    private void inflateTable(int toSize){
        int capacity = roundUpToPowerOf2(toSize);

        table = new Entry[capacity];

    }

    private static int roundUpToPowerOf2(int number){

        return number>=MAX_DEFAULT?MAX_DEFAULT
                :(number>1)?Integer.highestOneBit((number-1)<<1):1;//将number向上置为最近的2次幂，如number=17，会被置为32，highestOneBit(i)是将i的二进制数除最高位的1剩下的全置为0
    }


    private int indexFor(int hash, int len){
        return hash&(len-1);//有些版本是用hash值对table length取模值，但是效率不如位运算，位运算快
    }

    /*****用了很多的异或，移位等运算，对key的hashcode进一步进行计算以及二进制位的调整等来保证最终获取的存储位置尽量分布均匀***/
    private int hash(K k){
        int h = k.hashCode();

        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    /*根据key查找Entry，根据key求hash，hash求index，index找到table[index]处，在table[index]的链表上用hash，key查找Entry*/
    /*整个get包含 get(), getEntry()*/
    public V get(Object key){
        Entry<K,V> entry = getEntry(key);
        return null == entry ? null : entry.getValue();
    }

    Entry getEntry(Object key){
        if (size == 0) {
            return null;
        }

        int hash = (key == null) ? 0 : hash((K) key);
        int i = indexFor(hash, table.length);

        /*这个过程和put函数中的查找是否已经存在oldKey oldValue的过程一样*/
        for (Entry<K,V> e = table[i];
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    private class innerClass{
        //private static int innerFlag = 0;  ERROR! 内部非静态类不能有静态成员
        private int innerFlag = 0;
    }

    private static class innerStaticClass{
        private static int innerFlag = 0;//内部静态类可以有静态成员
    }

    static class Entry<K, V> implements Map.Entry<K, V>{

        final K key;
        V value;
        Entry<K, V> next;
        int hash;

        Entry(K k, V v, Entry<K, V> n, int h){
            key = k;
            value = v;
            next = n;
            hash = h;
        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }



}
