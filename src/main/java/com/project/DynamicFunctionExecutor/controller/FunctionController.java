package com.project.DynamicFunctionExecutor.controller;

import com.project.DynamicFunctionExecutor.dto.FuncRequest;
import com.project.DynamicFunctionExecutor.serivce.FunctionInterpreterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class FunctionController {

    @PostMapping("/func-interpreter")
    public String funcInterpreter(@RequestBody FuncRequest funcRequest) {
        return FunctionInterpreterService.functionInterpreter(funcRequest.getFunction(),
                                                                            funcRequest.getArguments()
        );
    }
}
