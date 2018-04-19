package service;

import model.Calculator;

public interface CalculatorService {

    Calculator calculate(String oper);

    void clean();
    void addDigit(Double digit);
}
