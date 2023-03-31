public class EmployeeDatabase {
    private Employee[] database;
    private int size;

    public EmployeeDatabase() {
        database = new Employee[8];
        size = 0;
    }

    public boolean add(Employee e) {
        if (contains(e)) {
            return false;
        }
        database[e.hashCode() % database.length] = e;
        size++;
        return true;
    }

    public boolean contains(Employee e) {
        for (int i = 0; i < database.length; i++) {
            if (database[i] != null) {
                if (e.hashCode() == database[i].hashCode()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean remove(Employee e) {
        if (!contains(e)) {
            return false;
        }

        for (int i = 0; i < database.length; i++) {
            if (database[i] != null && e.hashCode() == database[i].hashCode()) {
                Employee d = new Employee(e.name, e.ID);
                database[i] = null;
                add(d);
            } else {
                return false;
            }
        }
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < database.length; i++) {
            if (database[i] == null) {
                continue;
            } else {
                s += database[i].toString() + " ";
            }
        }
        return (s + "]").replace(" ]", "]");
    }
}
