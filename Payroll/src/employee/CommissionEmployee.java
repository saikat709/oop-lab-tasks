package employee;

public class CommissionEmployee extends Employee {
    private Double grossSales;
    private Double commissionRate;

    public CommissionEmployee(String firstName, String lastName, Integer socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
        this.grossSales = 0.0;
        this.commissionRate = 0.08; // 8%
    }

    public void setGrossSales(Double grossSales) {
        this.grossSales = grossSales;
    }

    @Override
    public double earnings() {
        return commissionRate * grossSales;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", socialSecurityNumber=" + this.getSocialSecurityNumber() +
                '}';
    }
}
