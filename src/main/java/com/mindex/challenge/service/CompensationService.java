package com.mindex.challenge.service;
import com.mindex.challenge.data.Compensation;

public interface CompensationService {
    // Create 2 REST endpoints:  create and read
    Compensation create(Compensation compensation);
    Compensation read(String id);
}
