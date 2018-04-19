package service;

import model.Calculator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("singleton")
public class CalculatorServiceImpl implements CalculatorService {

    Double [] digits = new Double[2];

    @Override
    public Calculator calculate(String oper) {
        Calculator calculator = new Calculator();
        calculator.setOperation(oper);
        Double result = null;
        if (oper.equals("*")){
            result = digits[0] * digits[1];
        }
        else if (oper.equals("/")){
            if (digits[1] != 0.0)
            result = digits[0] / digits[1];
            else{
                calculator.setMessage("You can not divide by zero");
                clean();
                return calculator;
            }
        }
        else if (oper.equals("+")){
            result = digits[0] + digits[1];
        }
        else if (oper.equals("-")){
            result = digits[0] - digits[1];
        }
        else if (oper.equals("=")){
            result = digits[0];
            clean();
        }
        else System.out.println("Invalid operation");
        calculator.setDigit(result);
        digits[0] = result;

        return calculator;
    }

    @Override
    public void clean() {
        digits[0] = 0.0;
        digits[1] = 0.0;
    }

    @Override
    public void addDigit(Double digit) {
        digits[1] = digit;
    }

    public CalculatorServiceImpl() {
        digits[0] = 0.0;
    }
}
