package U00_Review_00_NumberList;

public class NumberList {
    private Integer[] list;
    private int size;

    public NumberList() {
        list = new Integer[2];
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        String returnable = "[";

        for (Integer i = 0; i < size; i++) {
            returnable += list[i] + ", ";
        }

        returnable += "]";

        if (returnable.indexOf(", null") != -1) {
            returnable = returnable.replace(", null", "");
        }

        if (returnable.indexOf(", ]") != -1) {
            returnable = returnable.replace(", ]", "]");
        }

        if (returnable.equals("[null]")) {
            returnable = "[]";
        }

        return returnable;
    }

    private void doubleCapacity() {
        Integer[] nList = new Integer[list.length * 2];

        for (Integer i = 0; i < list.length; i++) {
            nList[i] = list[i];
        }

        list = new Integer[nList.length];
        list = nList;
    }

    public void add(int index, Integer value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (list[list.length - 1] != null) {
            doubleCapacity();
        }

        for (int i = index; i < list.length; i++) {
            if (value == null) {
                break;
            } else {
                Integer temp = list[i];
                list[i] = value;
                value = temp;
            }
        }

        size++;
    }

    public boolean add(Integer value) {
        add(this.size, value);
        return true;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            return list[index];
        }
    }

    public void set(Integer index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        list[index] = element;
    }

    public int remove(Integer index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Integer num = list[index];

        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        list[size - 1] = null;
        size--;
        return num;
    }
}
