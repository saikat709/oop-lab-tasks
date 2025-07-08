package employee;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private Double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, Integer socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
        this.baseSalary = 5000.0;
    }

    public void increaseBaseSalaryByPercentage(Integer percentage){
        this.baseSalary += baseSalary * percentage / 100;
    }

    @Override
    public double earnings() {
        return baseSalary + super.earnings();
    }

    @Override
    public String toString() {
        return "BasePlusCommissionEmployee{" +
                "firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", socialSecurityNumber=" + this.getSocialSecurityNumber() +
                '}';
    }
}
