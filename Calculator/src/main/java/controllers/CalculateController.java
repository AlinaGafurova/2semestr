package controllers;

import model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.CalculatorService;
import service.CalculatorServiceImpl;
import validate.FormValidator;


@Controller
//@SessionAttributes(types = Calculator.class)
public class CalculateController {

    private FormValidator validator = new FormValidator();

    private CalculatorService calculatorService = new CalculatorServiceImpl();

    //GET
    @RequestMapping(value = "/calc",method = RequestMethod.GET)
    public ModelAndView test(@ModelAttribute("calc") Calculator calculator) {
        calculator.setDigit(0.0);
        return new ModelAndView("index", "calculator", new Calculator());
    }

    //POST
    @RequestMapping(value = "/calc",method = RequestMethod.POST)
    public ModelAndView test1(@ModelAttribute("calc") Calculator calculator, BindingResult bindingResult, @RequestParam("oper")String oper){
        ModelAndView mav = new ModelAndView();
        validator.validate(calculator, bindingResult);
        if (bindingResult.hasErrors()) {
            calculator.setMessage("Некорректное значение");
            mav.addObject("message", calculator.getMessage());
            mav.setViewName("index");
            return mav;
        }
        else {
            calculatorService.addDigit(calculator.getDigit());
            Calculator calc = calculatorService.calculate(oper);
            mav.addObject("digit",calc.getDigit());
            mav.addObject("operation", calc.getOperation());
            mav.addObject("message", calc.getMessage());
//            calculatorService.clean();
            mav.setViewName("index");
//            mav.addObject(calculator);
            return mav;
        }

    }
}