public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    @Override
    public String toString() {
        StringBuilder values = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            if (current != head) {
                values.append(", ");
            }
            values.append(current.num);
            current = current.next;
        }
        return values.append(']').toString();
    }

    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.num == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    
     //Inserts value only if it is not already in the list.
    
    public boolean insertIfAbsent(int value, int index) {
        if (contains(value)) {
            return false;
        }
        checkInsertIndex(index);

        Node inserted = new Node(value);
        if (size == 0) {
            head = inserted;
            tail = inserted;
        } else if (index == 0) {
            inserted.next = head;
            head.prev = inserted;
            head = inserted;
        } else if (index == size) {
            inserted.prev = tail;
            tail.next = inserted;
            tail = inserted;
        } else {
            Node next = nodeAt(index);
            Node previous = next.prev;
            inserted.prev = previous;
            inserted.next = next;
            previous.next = inserted;
            next.prev = inserted;
        }
        size++;
        return true;
    }

    
    //Removes the first matching value.
    public boolean deleteIfPresent(int value) {
        Node current = head;
        while (current != null && current.num != value) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }

        if (current.prev == null) {
            head = current.next;
        } else {
            current.prev.next = current.next;
        }
        if (current.next == null) {
            tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }
        size--;
        return true;
    }

    private Node nodeAt(int index) {
        if (index < size / 2) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }

        Node current = tail;
        for (int i = size - 1; i > index; i--) {
            current = current.prev;
        }
        return current;
    }

    private void checkInsertIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
