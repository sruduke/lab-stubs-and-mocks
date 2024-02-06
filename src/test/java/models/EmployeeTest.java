package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    public Address stubAddress() {
        return new Address("1234 Main St", "Los Angeles");
    }

    @Test
    public void testCapitalName() {
        Address address = stubAddress();
        Employee employee = new Employee("johnny", 12345, 50000, address);
        assertEquals("Johnny", employee.getCapitalized());
    }
}
