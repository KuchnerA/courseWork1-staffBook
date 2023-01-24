public class Main {

    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees = new Employee[]{
                new Employee("Маркин Олег Витальевич", 20_000, 5),
                new Employee("Акунин Борис Викторович", 25_000, 3),
                new Employee("Агеев Антон Александрович", 40_000, 2),
                new Employee("Рычков Артем Максимович", 17_000, 4),
                new Employee("Кузнецов Максим Антонович", 15_000, 4),
                new Employee("Янцик Алексей Владимирович", 83_000, 5),
                new Employee("Мракин Аскар Вазгенович", 64_000, 1),
        };

        printEmployees();
        System.out.println("Cумма затрат на зарплаты в месяц: " + amountOfWages());
        System.out.println("Сотрудник с минимальной зарплатой = " + findAnEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой = " + findAnEmployeeWithMaxSalary());
        System.out.println("Среднее значение зарплат = " + averageSalary());
        printFullName();

        //---Повышенная сложность---

        System.out.println("Cотрудник с минимальной зарплатой в отделе: " + findAnEmployeeWithMinSalaryOfDepartment(4));
        System.out.println("Cотрудник с максимальной зарплатой в отделе: " + findAnEmployeeWithMaxSalaryOfDepartment(4));
        System.out.println("Сумма затрат на зарплату по отделу: " + amountOfWagesOfDepartment(5));
        System.out.println("Средняя зарплата по отделу: " + averageSalaryOfDepartment(5));

        salaryIndexationOfDepartment(5, 3);

        System.out.println("Все сотрудники отдела 4:");
        printEmployeesOfDepartment(4);
        System.out.println("Все сотрудники с зарплатой меньше 50_000 руб.:");
        printEmployeesWithLessThanTheSalary(50_000);
        System.out.println("Все сотрудники с зарплатой больше 30_000 руб.:");
        printEmployeesWithHigherWages(30_000);
    }

    public static void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static int amountOfWages() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static Employee findAnEmployeeWithMinSalary() {
        Employee result = employees[0];
        int minSalary = result.getSalary();
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee findAnEmployeeWithMaxSalary() {
        Employee result = employees[0];
        int maxSalary = result.getSalary();
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static float averageSalary() {
        return amountOfWages() / Employee.getCounter();
    }

    public static void printFullName() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    //---Повышенная сложность---

    public static void salaryIndexation(int percent) {
        for (Employee employee : employees) {
            int currentSalary = employee.getSalary();
            employee.setSalary((int) (currentSalary * (percent / 100f + 1)));
        }
    }

    public static Employee findAnEmployeeWithMinSalaryOfDepartment(int department) {
        int minSalary = Integer.MAX_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }

            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee findAnEmployeeWithMaxSalaryOfDepartment(int department) {
        int maxSalary = Integer.MIN_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }

            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static int amountOfWagesOfDepartment(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && (employee.getDepartment() == department)) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static float averageSalaryOfDepartment(int department) {
        int membersCount = 0;
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && (employee.getDepartment() == department)) {
                sum += employee.getSalary();
                membersCount++;
            }
        }
        return sum / (float) membersCount;
    }

    public static void salaryIndexationOfDepartment(int department, int percent) {
        for (Employee employee : employees) {
            if (employee != null && (employee.getDepartment() == department)) {
                int currentSalary = employee.getSalary();
                employee.setSalary((int) (currentSalary * (percent / 100f + 1)));
            }
        }
    }

    public static void printEmployeesOfDepartment(int department) {
        for (Employee employee : employees) {
            if (employee != null && (employee.getDepartment() == department)) {
                System.out.println(employee.getId() + ", ФИО = " + employee.getFullName() + ", зарплата = " + employee.getSalary());
            }
        }
    }

    public static void printEmployeesWithLessThanTheSalary(int salary) {
        for (Employee employee : employees) {
            if (employee != null && (employee.getSalary() < salary)) {
                System.out.println(employee.getId() + ", ФИО = " + employee.getFullName() + ", зарплата = " + employee.getSalary());
            }
        }
    }

    public static void printEmployeesWithHigherWages(int salary) {
        for (Employee employee : employees) {
            if (employee != null && (employee.getSalary() >= salary)) {
                System.out.println(employee.getId() + ", ФИО = " + employee.getFullName() + ", зарплата = " + employee.getSalary());
            }
        }
    }
}
