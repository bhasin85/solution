package com.company.dao;

import org.junit.Test;

import java.io.FileNotFoundException;

import static junit.framework.TestCase.assertEquals;

public class FileHandlerTest {

    @Test
    public void inputsCount() {
        // assert statements
        assert FileHandler.readEmployees("input1.txt").size() == 6;
        assert FileHandler.readEmployees("input2.txt").size() == 6;
        assert FileHandler.readEmployees("input3.txt").size() == 1;
        assert FileHandler.readEmployees("input4.txt").size() == 0;
    }
}
