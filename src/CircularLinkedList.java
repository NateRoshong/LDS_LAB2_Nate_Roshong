public class CircularLinkedList {
    private Node tail;
    private int size;

    public int size() {
        return size;
    }

    public Node getHead() {
        return tail == null ? null : tail.next;
    }

    @Override
    public String toString() {
        StringBuilder values = new StringBuilder("[");
        Node current = tail == null ? null : tail.next;
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                values.append(", ");
            }
            values.append(current.num);
            current = current.next;
        }
        return values.append(']').toString();
    }

    public boolean contains(int value) {
        if (tail == null) {
            return false;
        }

        Node current = tail.next;
        for (int i = 0; i < size; i++) {
            if (current.num == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    
     //Inserts value at the 0-based index only if it is not already in the list.
    
    public boolean insertIfAbsent(int value, int index) {
        if (contains(value)) {
            return false;
        }
        checkInsertIndex(index);

        Node inserted = new Node(value);
        if (tail == null) {
            inserted.next = inserted;
            tail = inserted;
        } else if (index == 0) {
            inserted.next = tail.next;
            tail.next = inserted;
        } else if (index == size) {
            inserted.next = tail.next;
            tail.next = inserted;
            tail = inserted;
        } else {
            Node previous = nodeAt(index - 1);
            inserted.next = previous.next;
            previous.next = inserted;
        }
        size++;
        return true;
    }

    
     //Removes the first matching value.

    public boolean deleteIfPresent(int value) {
        if (tail == null) {
            return false;
        }

        Node previous = tail;
        Node current = tail.next;
        for (int i = 0; i < size; i++) {
            if (current.num == value) {
                if (size == 1) {
                    tail = null;
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    private Node nodeAt(int index) {
        Node current = tail.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkInsertIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
