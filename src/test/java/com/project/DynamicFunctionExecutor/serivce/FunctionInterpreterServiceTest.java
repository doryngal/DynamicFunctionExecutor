package com.project.DynamicFunctionExecutor.serivce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class FunctionInterpreterServiceTest {

    @Test
    public void testFunctionInterpreter(){
        String function = "function multiply(x, y) { return x * y; }";
        String arguments = "multiply(10, 5);";
        assertEquals("Result: 50.0", FunctionInterpreterService.functionInterpreter(function, arguments));


        String wrongFunction = "function multiply(x, y) { retur x * y; }";
        String wrongArguments = "multiply(11, 5);";
        String subStr =  FunctionInterpreterService.functionInterpreter(wrongFunction, wrongArguments);
        assertEquals("Error", subStr.substring(0, 5));


        String noFunction = "";
        String noArguments = "multiply(11, 5);";
        assertEquals("Error: function is not specified.", FunctionInterpreterService.functionInterpreter(noFunction, noArguments));
    }
}