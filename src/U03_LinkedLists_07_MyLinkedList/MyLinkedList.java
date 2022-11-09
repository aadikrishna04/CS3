package U03_LinkedLists_07_MyLinkedList;

public class MyLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
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

    public MyLinkedList(int val) {
        this.head = new ListNode(val);
        this.size = 1;
    }

    public void add(int newVal) {
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

    public boolean contains(int target) {
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

    public int indexOf(int target) {
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

    public int get(int index) {
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
        return -1;
    }

    public void set(int newVal, int index) {
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

    public int remove(int index) {
        if (size == 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode curr = head;
        ListNode last = null;

        if (index == 0) {
            int val = head.val;
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

        int val = curr.val;

        if (tail == curr) {
            tail = last;
        }

        last.next = curr.next;
        size--;
        return val;
    }

    public void add(int newVal, int index) {
        if (index > size)
            throw new IndexOutOfBoundsException();
        if (index == size) {
            add(newVal);
            return;
        }
        ListNode node = head, prev = null;
        if (index == 0) {
            ListNode n = new ListNode(newVal);
            n.next = head;
            head = n;
            return;
        }
        for (int i = 0; i < index; i++) {
            prev = node;
            node = node.next;
        }
        ListNode n = new ListNode(newVal);
        n.next = node;
        prev.next = n;
        size++;
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