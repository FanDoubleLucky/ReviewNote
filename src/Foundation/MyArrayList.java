package Foundation;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.util.*;

public class MyArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable, Iterable<E> {

    private static final Object[] DEFAULT_EMPTYDATA = {};

    private static final int DEFAULT_CAPACITY = 10;

    transient private E[] element_data;

    private int size;

    private static final int MAX_DEFAULTCAPACITY = 100;

    public E get(int index){
        return (E) this.element_data[index];
    }

    public int size(){
        return this.size;
    }

    public MyArrayList(int capacity){
        super();
        this.element_data = (E[]) new Object[capacity];
    }

    public MyArrayList(){
        super();
        this.element_data = (E[]) DEFAULT_EMPTYDATA;
    }

    public boolean add(E e) {
        ensureCapacity(size+1);//扩容机制
        element_data[size++] = e;
        return true;
    }

    /***** ensureCapacity, ensureExplicitCapacity, grow, hugeCapacity 这四个过程构成了ArrayList的扩容机制****/
    private void ensureCapacity(int minCapacity){
        if(element_data==DEFAULT_EMPTYDATA){
            minCapacity = Math.max(minCapacity, DEFAULT_CAPACITY);
        }
        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity){

        if(minCapacity - element_data.length>0){
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity){
        int oldCapacity = element_data.length;
        int newCapacity = oldCapacity + oldCapacity>>1;
        if(newCapacity - minCapacity<0){
            newCapacity = minCapacity;//此处是应用于当element_data为空的时候，此时element_data.length为0，newCapacity也为0，所以直接用minCapacity作为newCapacity，正常的话此时minCapacity应该是DEFAULT_CAPACITY=10
        }
        if(newCapacity - MAX_DEFAULTCAPACITY>0){
            newCapacity = hugeCapacity(minCapacity);
        }
        element_data = Arrays.copyOf(element_data, newCapacity);
    }

    private static int hugeCapacity(int minCapacity){
        if(minCapacity<0){//overflow
            throw new OutOfMemoryError();
        }
        //现在已知1.5倍的minCapacity比MAX_DEFAULTCAPACITY大，如果1倍的minCapacity不比MAX_DEFAULTCAPACITY大，那就扩容到MAX_DEFAULTCAPACITY，如果1倍的minCapacity就比MAX_DEFAULTCAPACITY大了，就只能扩容到MaxInteger了
        return (minCapacity>MAX_DEFAULTCAPACITY)?Integer.MAX_VALUE:MAX_DEFAULTCAPACITY;
    }

    public void add(int index, E e){
        checkForAddIndex(index);
        ensureCapacity(size+1);
        System.arraycopy(element_data, index, element_data, index+1, size-index);
        element_data[index] = e;
        size++;
    }

    private void checkForAddIndex(int index){
        if(index>size||index<0){
            throw new IndexOutOfBoundsException();
        }
    }

    public E remove(int index){
        checkForAddIndex(index);
        E e = element_data[index];
        int numNeedMove = size - index - 1;
        if(numNeedMove>0){
            System.arraycopy(element_data, index+1, element_data, index, numNeedMove);
        }
        element_data[size--] = null;
        return e;
    }

    public void clear(){
        for (int i = 0; i <size; i++) {
            element_data[i] = null;
        }
    }



    public Iterator<E> iterator(){
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<E>{
        private int i = size;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public E next() {
            return element_data[--i];
        }
    }
}
