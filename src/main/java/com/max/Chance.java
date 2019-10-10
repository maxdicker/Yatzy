package com.max;

import java.util.List;
import java.util.Map;

public class Chance extends Calculation implements IScorecalculator {

    @Override
    public int calculateScore(List<Integer> values) {
        Map<Integer, Integer> frequenciesByValue = toFrequencyMap(values);
        return sum(frequenciesByValue);
    }

}
