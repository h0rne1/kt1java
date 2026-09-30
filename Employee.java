public class Employee {
    private static int employeeCount = 0;

    private String name;
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary >= 0 ? salary : 0;
        employeeCount++;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary >= 0 ? salary : 0;
    }

    public double calculateBonus() {
        return salary * 0.1;
    }

    @Override
    public String toString() {
        return String.format("%s — %s, оклад %.0f", name, position, salary);
    }
}
