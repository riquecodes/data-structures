public class TADList {
    private Nodo head, tail;
    private int size;

    public TADList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int length() {
        if (isEmpty()) {
            return size = 0;
        }
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertFinal(int element) {
        Nodo n = new Nodo(element);
        if (isEmpty()) {
            head = n;
        }
        else {
            n.prev = tail;
            tail.next = n;
        }
        tail = n;
        size++;
    }

    public void insertFirst(int element) {
        Nodo n = new Nodo(element);
        if (isEmpty()) {
            head = n;
        }
        else {
            n.prev = tail;
            tail.next = n;
        }
        tail = n;
        size++;
    }

    public void insert(int pos, int element) {
        Nodo aux = head;
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException();
        }

        if (isEmpty()) {
            Nodo n = new Nodo(element);
            head = n;
            tail = n;
            size++;
            return;
        }

        if (pos == 0) {
            insertFirst(element);
            return;
        }

        if (pos == size) {
            insertFinal(element);
            return;
        }

        for (int i = 0; i < pos; i++) {
            aux = aux.next;
        }

        Nodo n = new Nodo(element);
        n.prev = aux.prev;
        n.next = aux;

        aux.prev.next = n;
        aux.prev = n;

        size++;
    }

    public void printFirt2Last() {
        Nodo aux = head;

        while (aux != null) {
            System.out.println(aux.item);
            aux = aux.next;
        }
    }

    public void printLast2First() {
        Nodo aux = tail;

        while (aux != null) {
            System.out.println(aux.item);
            aux = aux.prev;
        }
    }

    public int access(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        Nodo aux = head;

        for (int i = 0; i < pos; i++) {
            aux = aux.next;
        }
        return aux.item;
    }

    public boolean search(int element) throws Exception {
        Nodo aux = head;
        if (isEmpty()) {
            throw new Exception("A lista está vazia");
        }

        for (int i = 0; i < size; i++) {
            aux = aux.next;
            if (aux.item == element) {
                return true;
            }
        }
        return false;
    }

    public void delete(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (pos == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
                size--;
                return;
            }
            tail = null;
            size--;
            return;
        }

        if (pos == size - 1) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
                size--;
                return;
            }
            head = null;
            size--;
            return;
        }

        Nodo aux = head;
        for (int i = 0; i < pos; i++) {
            aux = aux.next;
        }

        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        size--;
    }

    public void deleteLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("A lista está vazia");
        }

        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void deleteFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("A lista está vazia");
        }

        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        head = head.next;
        head.prev = null;
        size--;
    }

    public String listToString() {
        StringBuilder s = new StringBuilder();
        Nodo aux = head;

        s.append("[");
        while (aux != null) {
            s.append(aux.item);
            if (aux.next != null) {
                s.append(", ");
            }
            aux = aux.next;
        }
        s.append("]");
        return s.toString();
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

}
