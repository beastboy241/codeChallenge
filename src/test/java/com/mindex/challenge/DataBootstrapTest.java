package com.mindex.challenge;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBootstrapTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompensationRepository compensationRepository;

    @Test
    public void test() {
        Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Lennon", employee.getLastName());
        assertEquals("Development Manager", employee.getPosition());
        assertEquals("Engineering", employee.getDepartment());
    }

    @Test
    public void testCompensation() {
        Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        Compensation expectedCompensation = new Compensation();
        expectedCompensation.setEmployee(employee);
        expectedCompensation.setSalary("85000");
        expectedCompensation.setEffectiveDate(new Date());
        compensationRepository.insert(expectedCompensation);

        Compensation testCompensation = compensationRepository.findByEmployee(employee);
        assertNotNull(testCompensation);
        assertNotNull(testCompensation.getEmployee());
        assertEquals(expectedCompensation.getEmployee().getFirstName(), testCompensation.getEmployee().getFirstName());
        assertEquals(expectedCompensation.getEmployee().getLastName(), testCompensation.getEmployee().getLastName());
        assertEquals(expectedCompensation.getEmployee().getPosition(), testCompensation.getEmployee().getPosition());
        assertEquals(expectedCompensation.getEmployee().getDepartment(), testCompensation.getEmployee().getDepartment());
        assertEquals(expectedCompensation.getSalary(), testCompensation.getSalary());
        assertEquals(expectedCompensation.getEffectiveDate(), testCompensation.getEffectiveDate());

    }
}