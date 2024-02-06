import java.util.ArrayList;
import java.util.List;

import models.Address;
import services.AddressService;
import services.SalaryService;

public class Utilities {

    public List<Address> getAddressesByCity(AddressService addressService, String city) {
        List<Address> addresses = addressService.getAllAddresses();
        List<Address> addressesByCity = new ArrayList<>();
        for (Address address : addresses) {
            if (address.getCity().equals(city)) {
                addressesByCity.add(address);
            }
        }
        return addressesByCity;
    }

    public List<Integer> getFilteredSalaries(SalaryService salaryService, Integer cutoff) {
        List<Integer> salaries = salaryService.getSalaries();
        List<Integer> filteredSalaries = new ArrayList<>();
        for (int salary : salaries) {
            if (salary > 50000) {
                filteredSalaries.add(salary);
            }
        }
        return filteredSalaries;
    }

}
