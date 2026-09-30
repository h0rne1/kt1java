public class Main {
    public static void main(String[] args) {
        Employee ivanov = new Employee("Иванов И.И.", "Разработчик", 90000);
        Employee petrov = new Employee("Петров П.П.", "Тестировщик", -5000);

        System.out.println(ivanov);
        System.out.println(petrov);

        ivanov.setSalary(ivanov.getSalary() + 10000);
        System.out.println("После повышения: " + ivanov);

        Employee sidorov = new Manager("Сидоров С.С.", "Руководитель отдела", 150000, 5);
        System.out.println(sidorov);

        System.out.printf("Премия %s: %.0f%n", ivanov.getName(), ivanov.calculateBonus());
        System.out.printf("Премия %s: %.0f%n", sidorov.getName(), sidorov.calculateBonus());

        System.out.println("Всего сотрудников: " + Employee.getEmployeeCount());

        Employee[] staff = {
                new Employee("Кузнецов А.В.", "Аналитик", 80000),
                new Manager("Смирнова Е.Н.", "Тимлид", 180000, 6),
                new Employee("Попова М.С.", "Дизайнер", 75000),
                new Manager("Волков Д.А.", "Директор по разработке", 250000, 12)
        };

        System.out.println();
        // Проверки типа не нужны благодаря полиморфизму: Manager переопределяет calculateBonus() и toString(),
        // а Java выбирает реализацию метода во время выполнения по реальному типу объекта, а не по типу переменной.
        // Поэтому вызов item.calculateBonus() для Manager выполнит код из Manager, а для обычного сотрудника — из Employee.
        for (Employee item : staff) {
            System.out.println(item);
            System.out.printf("  премия: %.0f%n", item.calculateBonus());
        }

        System.out.println();
        int managerCount = 0;
        for (Employee item : staff) {
            if (item instanceof Manager) {
                Manager manager = (Manager) item;
                managerCount++;
                System.out.println(manager.getName() + " — размер команды: " + manager.getTeamSize());
            }
        }
        System.out.println("Менеджеров в штате: " + managerCount);

        System.out.printf("Суммарный бюджет премий: %.0f%n", totalBonusBudget(staff));
    }

    public static double totalBonusBudget(Employee[] staff) {
        double total = 0;
        for (Employee item : staff) {
            total += item.calculateBonus();
        }
        return total;
    }
}
