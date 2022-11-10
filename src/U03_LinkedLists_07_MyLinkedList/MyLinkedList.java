package U03_LinkedLists_07_MyLinkedList;

public class MyLinkedList<T> {
    public class ListNode {
        public T val;
        public ListNode next;

        public ListNode(T val) {
            this.val = val;
            this.next = null;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public MyLinkedList(T val) {
        this.head = new ListNode(val);
        this.size = 1;
    }

    @SuppressWarnings("unchecked")
    public MyLinkedList(T... vals) {
        this();
        for (T t : vals) {
            add(t);
        }
    }

    public void add(T newVal) {
        if (size == 0) {
            head = new ListNode(newVal);
            size++;
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new ListNode(newVal);
            size++;
        }
    }

    public boolean contains(T target) {
        ListNode curr = head;
        int count = 0;
        while (count < size) {
            if (curr.val == target) {
                return true;
            } else {
                curr = curr.next;
            }
            count++;
        }
        return false;
    }

    public int indexOf(T target) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            if (curr.val == target) {
                return count;
            } else {
                count++;
                curr = curr.next;
            }
        }
        return -1;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            int count = 0;
            ListNode curr = head;

            while (curr != null) {
                if (count == index) {
                    return curr.val;
                }

                count++;
                curr = curr.next;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public void set(T newVal, int index) {
        ListNode curr = head;
        int count = 0;

        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        while (count < index) {
            curr = curr.next;
            count++;
        }

        curr.val = newVal;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T remove(int index) {
        if (size == 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode curr = head;
        ListNode last = null;

        if (index == 0) {
            T val = head.val;
            head = head.next;
            size--;
            return val;
        }
        int count = 0;
        while (count < index) {
            last = curr;
            curr = curr.next;
            count++;
        }

        T val = curr.val;

        if (tail == curr) {
            tail = last;
        }

        last.next = curr.next;
        size--;
        return val;
    }

    public void add(T newVal, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size) {
            add(newVal);
        } else if (index == 0) {
            ListNode curr = head;
            head = new ListNode(newVal);
            head.next = curr;
            size++;
        } else {
            ListNode curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            ListNode node = curr.next;
            curr.next = new ListNode(newVal);
            curr.next.next = node;
            size++;
        }
    }

    @Override
    public String toString() {
        if (size() == 0)
            return "[]";
        String toString = "[";
        ListNode curr = head;
        while (curr != null) {
            toString += curr.val + ", ";
            curr = curr.next;
        }
        return toString.substring(0, toString.lastIndexOf(",")) + "]";
    }
}