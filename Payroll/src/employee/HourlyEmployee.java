package employee;

public class HourlyEmployee extends Employee {
    private Double hourlyWage;
    private Double hoursWorked;

    public HourlyEmployee(String firstName, String lastName, Integer socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
        this.hourlyWage = 300.0;
        this.hoursWorked = 0.0;
    }

    public void setHoursWorked(Double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double earnings() {
        if ( hoursWorked <= 40 ) {
            return hourlyWage * hoursWorked;
        } else {
            return 40 * hourlyWage  + 1.5 * hourlyWage * ( hoursWorked - 40 );
        }
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", socialSecurityNumber=" + this.getSocialSecurityNumber() +
                '}';
    }
}
