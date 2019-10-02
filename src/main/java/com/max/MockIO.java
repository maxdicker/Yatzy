package com.max;

import java.util.ArrayList;
import java.util.List;

public class MockIO implements IInputOutput{

    private String mockInput;
    private List<String> mockOutput = new ArrayList<>();

    public MockIO() {
    }

    public MockIO(String mockInput) {
        this.mockInput = mockInput;
    }

    @Override
    public String read() {
        return mockInput;
    }

    @Override
    public void write(String mockOutput) {
        this.mockOutput.add(mockOutput);
    }

    public List<String> getOutput() {
        return mockOutput;
    }
}