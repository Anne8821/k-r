import java.util.Objects;

public class Employee {

    private static int idGenerator = 1;

    private final String fullName;
    //private final String surnames;
    //private String patronymic;
    private int department;
    private int salary;
    private final int id;

    public Employee(String fullName, int department, int salary) {
        id = idGenerator++;
        this.fullName = fullName;
        //    this.surnames = surnames;
        //  this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getfullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary &&
                department == employee.salary &&
                id == employee.id &&
                Objects.equals(fullName, employee.fullName);
    }


    @Override
    public int hashCode() {
        return Objects.hash(fullName, salary, department, id);
    }

}