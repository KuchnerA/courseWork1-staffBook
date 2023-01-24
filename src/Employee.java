public class Employee {

    private static int counter = 0;
    private final String fullName;
    public int id;
    private int salary;
    private int department;

    public Employee(String fullName, int salary, int department) {
        this.fullName = fullName;
        this.id = counter++;
        this.salary = salary;
        this.department = department;
    }

    public static int getCounter() {
        return counter;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Сотрудник {" + "id = " + id +
                ", ФИО = " + fullName +
                ", Зарплата = " + salary +
                ", Отдел = " + department +
                "};";
    }
}
