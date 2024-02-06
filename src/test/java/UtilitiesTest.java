import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import models.Address;
import services.AddressService;
import services.SalaryService;

public class UtilitiesTest {

    @Test
    public void testCity() {
        // mock the AddressService Class
        AddressService addressService = mock(AddressService.class);

        // define the behavior of the mock
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("1234 Main St", "Los Angeles"));
        addresses.add(new Address("5678 Main St", "Los Angeles"));
        addresses.add(new Address("91011 Oak St", "Chicago"));
        // define the methods of the mock
        when(addressService.getAllAddresses()).thenReturn(addresses);
        
        List<Address> correctAddresses = new ArrayList<>();
        correctAddresses.add(new Address("1234 Main St", "Los Angeles"));
        correctAddresses.add(new Address("5678 Main St", "Los Angeles"));

        Utilities utility = new Utilities();

        List<Address> returnedAddresses = utility.getAddressesByCity(addressService, "Los Angeles");
        
        for (int i = 0; i < returnedAddresses.size(); i++) {
            assertEquals(correctAddresses.get(i).getCity(), returnedAddresses.get(i).getCity());
        }
    }

    @Test
    public void testSalary() {
        // mock the AddressService Class
        SalaryService salaryService = mock(SalaryService.class);

        List<Integer> salaries = new ArrayList<>();
        salaries.add(50000);
        salaries.add(60000);
        salaries.add(70000);
        when(salaryService.getSalaries()).thenReturn(salaries);

        List<Integer> correctSalaries = new ArrayList<>();
        correctSalaries.add(60000);
        correctSalaries.add(70000);

        Utilities utility = new Utilities();

        int cutoff = 50000;
        List<Integer> returnedSalaries = utility.getFilteredSalaries(salaryService, cutoff);
        
        for (int i = 0; i < returnedSalaries.size(); i++) {
            assertEquals(correctSalaries.get(i), returnedSalaries.get(i));
        }
    }
}
