package com.nikitin.vacationpaycalculator.service;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

public interface VacationPayCalculatorService {
    double calculateVacationPay(double averageSalaryPerYear, int vacationDays);
    double calculateVacationPay(double averageSalaryPerYear, int vacationDays, Optional<String> vacationDate) throws ParseException;
}
