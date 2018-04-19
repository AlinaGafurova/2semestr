package repository;

import java.util.ArrayList;


@org.springframework.stereotype.Repository
public class RepositoryImpl implements Repository {

    ArrayList<Double> list = new ArrayList<>();


    @Override
    public void cleanRepo() {
        list.clear();
    }

    @Override
    public ArrayList<Double> getDigits() {
        return list;
    }

    @Override
    public void addDigit(Double digit) {
        list.add(digit);
    }

}
