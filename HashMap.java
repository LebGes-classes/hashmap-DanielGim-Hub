package Hash;

public class HashMap<K, V> {
    private static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node<K, V>[] table;
    private int size;

    // Константа для начального размера таблицы
    private static final int CAPACITY = 16;

    public HashMap() {
        table = new Node[CAPACITY];
        size = 0;
    }

    // Метод добавления элемента в таблицу
    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> newNode = new Node<>(key.hashCode(), key, value, null);

        // Если в ячейке пусто, добавляем новый узел
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            //добавляем узел в конец списка
            Node<K, V> current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Метод для получения значения по ключу
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> current = table[index];

        // Ищем узел с соответствующим ключом в списке
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value; // ключ найден
            }
            current = current.next;
        }
        return null; // ключ не найден
    }

    // Метод для определения наличия ключа в хэш
    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> current = table[index];

        // Ищем узел с соответствующим ключом в списке
        while (current != null) {
            if (current.key.equals(key)) {
                return true; // ключ найден
            }
            current = current.next;
        }
        return false; // ключ не найден
    }
    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> current = table[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    public int size() {
        return size;
    }

    // Вспомогательный метод для вычисления индекса на основе ключа
    private int getIndex(K key) {
        if (key == null) {
            return 0; // Если ключ равен null возвращаем 0
        }
        int hash = key.hashCode();
        return Math.abs(hash % table.length);
    }
}
