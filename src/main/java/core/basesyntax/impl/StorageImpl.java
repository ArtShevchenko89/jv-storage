package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K[] keys = (K[]) new Object[MAX_ITEMS_NUMBER];
    private V[] values = (V[]) new Object[MAX_ITEMS_NUMBER];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            } else if (keys[i] == null && key == null) {
                values[i] = value; // оновлення для null ключа
                return;
            }
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
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            } else if (keys[i] == null && key == null) {
                return values[i];
            }
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
