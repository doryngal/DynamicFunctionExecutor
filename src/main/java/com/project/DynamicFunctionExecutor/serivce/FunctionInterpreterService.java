package com.project.DynamicFunctionExecutor.serivce;



import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Service
public class FunctionInterpreterService {
    public static String functionInterpreter(String function, String arguments) {
        if (function == null || function.trim().isEmpty()) {
            return "Error: function is not specified.";
        }
        if (arguments == null || arguments.trim().isEmpty()) {
            return "Error: no arguments are given.";
        }

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        try {
            // Попытка выполнить функцию
            engine.eval(function);
            Object result = engine.eval(arguments);
            return "Result: " + result.toString();
        } catch (ScriptException e) {
            // Отлавливаем и анализируем исключение
            if (e.getMessage().contains("ReferenceError")) {
                return "Error: function or arguments are not correct." + e.getMessage();
            } else {
                return "Error during script execution:" + e.getMessage();
            }
        }
    }
}
