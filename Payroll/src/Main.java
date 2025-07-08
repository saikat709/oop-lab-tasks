import employee.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SalariedEmployee a = new SalariedEmployee("Abc", "Asj", 10282);
        System.out.println(a);

        HourlyEmployee b = new HourlyEmployee("Abc", "Asj", 10282);
        b.setHoursWorked(45.0);

        CommissionEmployee c = new CommissionEmployee("Abc", "Asj", 10282);
        c.setGrossSales(4500.0);

        BasePlusCommissionEmployee d = new BasePlusCommissionEmployee("Abc", "Asj", 10282);
        d.setGrossSales(200.0);
        d.increaseBaseSalaryByPercentage(10);

        Employee[] employees = { a, b, c, d };

        System.out.println();
        for( Employee e: employees){
            System.out.println(e.toString());
            System.out.println("Earning: " + e.earnings());
        }
    }
}