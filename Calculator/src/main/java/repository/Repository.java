package repository;

import java.util.ArrayList;


public interface Repository {

    void cleanRepo();

    ArrayList<Double> getDigits();

    void addDigit(Double digit);
}
