# vacation-pay-calculator
Есть один REST API - может получать 2 обязательных параметра averageSalaryPerYear(double), vacationDays(int) и один необязательный - vacationDate(String(01.02.2022)
Пример как можно использовать(vacationDate сделан только для 2022 года) -
http://localhost:8080/calculate?averageSalaryPerYear=400000&vacationDays=28&vacationDate=01.04.2022
http://localhost:8080/calculate?averageSalaryPerYear=400000&vacationDays=28
