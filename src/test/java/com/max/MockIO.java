package com.max;

import java.util.ArrayList;
import java.util.List;

public class MockIO implements IO {
    private String mockInput;
    private String secondMockInput;
    private int readCount;

    private List<String> mockOutput = new ArrayList<>();

    public MockIO() {
        this.mockInput = "";
        this.secondMockInput = "";
        this.readCount = 0;
    }

    public MockIO(String mockInput) {
        this.mockInput = mockInput;
    }

    public MockIO(String mockInput, String secondMockInput) {
        this.mockInput = mockInput;
        this.secondMockInput = secondMockInput;
    }

    @Override
    public String read() {
        readCount++;
        return readCount == 1 ? mockInput : secondMockInput;
    }

    @Override
    public void write(String mockOutput) {
        this.mockOutput.add(mockOutput);
    }

    public List<String> getOutput() {
        return mockOutput;
    }
}
