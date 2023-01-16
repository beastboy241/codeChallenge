package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingStructureImpl implements ReportingStructureService {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @Autowired
    private EmployeeService employeeService;

    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Creating reporting structure employee's id [{}]", id);

        ReportingStructure reportingStructure = new ReportingStructure();
        Employee employee = employeeService.read(id);

        reportingStructure.setEmployee(employee);
        reportingStructure.setNumberOfReports(employeeService.getSumOfReports(employee.getEmployeeId()));



        return reportingStructure;
    }
}
