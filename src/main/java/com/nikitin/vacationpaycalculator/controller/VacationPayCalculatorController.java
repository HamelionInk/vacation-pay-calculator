package com.nikitin.vacationpaycalculator.controller;

import com.nikitin.vacationpaycalculator.service.VacationPayCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Optional;

@RestController
public class VacationPayCalculatorController {

    private final VacationPayCalculatorService vacationPayCalculatorService;

    @Autowired
    public VacationPayCalculatorController(VacationPayCalculatorService vacationPayCalculatorService) {
        this.vacationPayCalculatorService = vacationPayCalculatorService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<?> calculate(@RequestParam double averageSalaryPerYear,
                                       @RequestParam int vacationDays,
                                       @RequestParam Optional<String> vacationDate) throws ParseException {
        if(vacationDate.isPresent()) {
            return new ResponseEntity<>(
                    vacationPayCalculatorService.calculateVacationPay(averageSalaryPerYear, vacationDays, vacationDate),
                    HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                    vacationPayCalculatorService.calculateVacationPay(averageSalaryPerYear, vacationDays),
                    HttpStatus.OK);
        }
    }
}
