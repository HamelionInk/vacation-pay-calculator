package com.nikitin.vacationpaycalculator.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VacationPayCalculatorServiceImpl implements VacationPayCalculatorService {

    //TODO - Справочник без использования БД, здесь учитываются праздничные дни, сделано для тест варианта
    // в сокращенном ввиде, обычные выходные дни не учитываются, как и рабочие в выходные, value в маппе должно обозначать 0 обычный выходной день,
    // 1 Праздничный день, -1 рабочий день в выходные
    Map<String, String> holidays;

    public VacationPayCalculatorServiceImpl() {
        holidays = new HashMap<>();
        holidays.put("01.01.2022", "1");
        holidays.put("02.01.2022", "1");
        holidays.put("03.01.2022", "1");
        holidays.put("04.01.2022", "1");
        holidays.put("05.01.2022", "1");
        holidays.put("06.01.2022", "1");
        holidays.put("07.01.2022", "1");
        holidays.put("08.01.2022", "1");
        holidays.put("23.02.2022", "1");
        holidays.put("08.03.2022", "1");
        holidays.put("01.05.2022", "1");
        holidays.put("09.05.2022", "1");
        holidays.put("12.06.2022", "1");
        holidays.put("04.11.2022", "1");
    }

    @Override
    public double calculateVacationPay(double averageSalaryPerYear, int vacationDays) {
        return (averageSalaryPerYear / 317) * vacationDays;
    }

    @Override
    public double calculateVacationPay(double averageSalaryPerYear, int vacationDays, Optional<String> vacationDate) throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
        Calendar instance = Calendar.getInstance();
        for (int i = 0; i <= vacationDays; i++) {
            instance.setTime(formatDate.parse(vacationDate.get()));
            for (String stringDate : holidays.keySet()) {
                Date date = formatDate.parse(stringDate);
                if (date.equals(instance.getTime())) {
                    vacationDays = vacationDays - 1;
                }
            }
            instance.add(Calendar.DAY_OF_MONTH, 1);
            vacationDate = Optional.of(formatDate.format(instance.getTime()));
        }
        return (averageSalaryPerYear / 317) * vacationDays;
    }
}
