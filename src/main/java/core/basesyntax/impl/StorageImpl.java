package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final K[] keys;
    private final V[] values;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ITEMS_NUMBER];
        this.values = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return i;
            } else if (keys[i] == null && key == null) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        if (indexOfKey(key) != -1) {
            values[indexOfKey(key)] = value;
            return;
        }

        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && values[i] == null) {
                keys[i] = key;
                values[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        if (indexOfKey(key) != -1) {
            return values[indexOfKey(key)];
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && values[i] != null) || (keys[i] != null && values[i] != null)) {
                size++;
            }
        }
        return size;
    }
}
