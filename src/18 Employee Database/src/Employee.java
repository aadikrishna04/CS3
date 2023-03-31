public class Employee {
    String name;
    int ID;

    public Employee(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    @Override
    public int hashCode() {
        int sum = 0;
        for (char c : name.toCharArray()) {
            sum += (int) (c);
        }

        return sum * ID;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        String s = String.format("%s %s", name, "" + ID);
        return s;
    }
}
