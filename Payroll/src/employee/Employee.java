package employee;

public abstract class Employee {
    private String firstName, lastName;
    private Integer socialSecurityNumber;

    public Employee(String firstName, String lastName, Integer socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public abstract double earnings();

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", socialSecurityNumber=" + socialSecurityNumber +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
}
