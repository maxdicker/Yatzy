package com.max;

import java.util.Random;

public class RealRandom implements IRandom {
    Random random;

    public RealRandom() {
        this.random = new Random();
    }


    @Override
    public int nextInt(int maxLimit) {
        return random.nextInt(maxLimit);
    }
}
