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
        Compensation compensation = compensationRepository.findCompensationByEmployeeId("b7839309-3348-463b-a7e3-5de1c168beb3");
        assertNotNull(compensation);
        assertEquals("Paul", compensation.getEmployee().getFirstName());
        assertEquals("McCartney", compensation.getEmployee().getLastName());
        assertEquals("Developer I", compensation.getEmployee().getPosition());
        assertEquals("Engineering", compensation.getEmployee().getDepartment());
        assertEquals(85000, compensation.getSalary());
        assertEquals("01/16/2023", compensation.getEffectiveDate());

    }
}