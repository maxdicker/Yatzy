package com.max;

import java.util.List;
import java.util.Map;

public class SpecificNumber extends Calculation implements IScorecalculator {
    private int numberToSum;

    public SpecificNumber(int numberToSum) {
        this.numberToSum = numberToSum;
    }

    @Override
    public int calculateScore(List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        return (numberToSum * frequenciesByValue.getOrDefault(numberToSum, 0));
    }

}
