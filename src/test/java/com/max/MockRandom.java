package com.max;

public class MockRandom implements IRandom{

    @Override
    public int nextInt(int maxLimit) {
        return 2;
    }
}
