package com;


public class LinearAddressHashMap<K, V> {

    int capacity;
    int size;

    class Node<K, V> {
        K key;
        V value;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    Node<K, V>[] nodes;

    LinearAddressHashMap(int capacity){
        this.capacity = capacity;
        this.nodes = new Node[capacity];
    }
    public V get(K key){

        //线性地址法
        for (int i=0;i<capacity;i++){
            if (nodes[(key.hashCode()+i)%capacity]==null)return null;
            else if (nodes[(key.hashCode()+i)%capacity].key==key){
                return nodes[(key.hashCode()+i)%capacity].value;
            }
        }

        return null;
    }

    public void put(K key, V value){
        for (int i=0;i<capacity;i++){
            if (nodes[(key.hashCode()+i)%capacity] == null){
                nodes[(key.hashCode()+i)%capacity] = new Node(key, value);
                size++;
                return;
            }
            if (nodes[(key.hashCode()+i)%capacity].key == key ) {
                nodes[(key.hashCode()+i)%capacity].value = value;
                return;
            }
        }
        resize();
        put(key, value);
    }
    public int size(){
        return size;
    }
    private void resize(){
        int oldCapacity = capacity;
        capacity *=2;
        Node[] oldNodes = nodes;
        nodes = new Node[capacity];
        for (int i=0;i<oldCapacity;i++) {
            put((K)oldNodes[i].key, (V)oldNodes[i].value);
        }
    }
}
