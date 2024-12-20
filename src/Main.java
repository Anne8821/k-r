import java.util.PrimitiveIterator;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private final static Random random = new Random();
    private final static String[] names = {"Екатерина", "Роберт", "Даниил", "Розалия", "Алексей"};
    private final static String[] surnames = {"Иванова", "Франц", "Разумовский", "Тихонова", "Смирнов"};
    private final static String[] patronymic = {"Алексеевна", "Даниилович", "Робертович", "Дмитриевна", "Романович"};


    private final static Employee[] employees = new Employee[10];

    private static void initEmployees() {
        for (int i = 1; employees.length > i; i++) {
            String fullName = surnames[random.nextInt(0)] + " " +
                    names[random.nextInt(0, names.length)] + " " +
                    patronymic[random.nextInt(0,patronymic.length)];
            employees[i] = new Employee(fullName, random.nextInt(1,6), random.nextInt(50_000,100_000));
        }
    }

    public static void main(String[] args) {
        initEmployees();
        print();
        System.out.println("Сумма ЗП сотрудников: " + calculateSumOfSalaries());
        System.out.println("Сотрудника с мин ЗП: " + findEmployeeWithMinSalary());
        System.out.println("Сотрудника с макс ЗП: " + findEmployeeWithMaxSalary());
        System.out.println("Средняя ЗП: " + calculateAverageOfSalaries());
        printFullNames();
    }

    private static void print() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int calculateSumOfSalaries(){
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary(){
        Employee minSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    private static Employee findEmployeeWithMaxSalary(){
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    private static double calculateAverageOfSalaries(){
        return (double) calculateSumOfSalaries() / employees.length;
    }

    private static void printFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getfullName());
        }
    }
}