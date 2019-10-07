package com.max;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MockIO implements IO {
    private List<String> mockInput;

    private int readCount;

    private List<String> mockOutput = new ArrayList<>();

    public MockIO() {
        this.readCount = 0;
    }

    public MockIO(String mockInput) {
        this.mockInput = new ArrayList<>(Collections.singletonList(mockInput));
    }

    public MockIO(List<String> mockInput) {
        this.mockInput = new ArrayList<>(mockInput);
    }

    @Override
    public String read() {
        return mockInput.get(readCount++);
    }

    @Override
    public void write(String mockOutput) {
        this.mockOutput.add(mockOutput);
    }

    public List<String> getOutput() {
        return mockOutput;
    }
}
