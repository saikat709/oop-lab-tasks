package employee;

public class SalariedEmployee extends Employee {
    private Double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, Integer socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = 2500.0;
    }

    @Override
    public double earnings() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", socialSecurityNumber=" + this.getSocialSecurityNumber() +
                '}';
    }
}
