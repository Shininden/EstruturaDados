package EstruturaDados.Listas;

public class Employees 
{
    private String id;
    private String name;
    private Double salary;

    public Employees(String id, String name, double salary) 
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void raiseSalary(double percentage)    {
        this.salary += (this.salary * percentage) / 100;
    }

    @Override
    public String toString() {
        return getId() + ", " + getName() + ", " + String.format("%.1f", getSalary());
    }
}