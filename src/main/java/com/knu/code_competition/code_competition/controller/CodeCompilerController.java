package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.model.CompilerModel;
import com.knu.code_competition.code_competition.model.CompilerResponseModel;
import com.knu.code_competition.code_competition.service.CompilerService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("api/v1/compiler")
@RestController
public class CodeCompilerController {

    private final CompilerService compilerService;

    public CodeCompilerController(CompilerService compilerService) {
        this.compilerService = compilerService;
    }

    @PostMapping("/execute")
    public CompilerResponseModel executeCode(@RequestBody CompilerModel compilerModel){
        String res = compilerService.executeCode(compilerModel);
        System.out.println(res);
        JSONObject jsonObject = new JSONObject(res);
        CompilerResponseModel responseModel = new CompilerResponseModel();
        responseModel.setOutput(jsonObject.get("output").toString());
        responseModel.setMemory(jsonObject.get("memory").toString());
        responseModel.setCpuTime(jsonObject.get("cpuTime").toString());
        responseModel.setStatusCode(jsonObject.get("statusCode").toString());

        return responseModel;
    }
}
