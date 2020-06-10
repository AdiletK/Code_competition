package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.Utils.RecordNotFoundException;
import com.knu.code_competition.code_competition.model.CompilerModel;
import com.knu.code_competition.code_competition.model.CompilerResponseModel;
import com.knu.code_competition.code_competition.model.TestModel;
import com.knu.code_competition.code_competition.service.CompilerService;
import com.knu.code_competition.code_competition.service.TestService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("api/v1/compiler")
@RestController
public class CodeCompilerController {

    private final CompilerService compilerService;
    private final TestService testService;

    public CodeCompilerController(CompilerService compilerService, TestService testService) {
        this.compilerService = compilerService;
        this.testService = testService;
    }


    @PostMapping("/execute")
    public CompilerResponseModel executeCode(@RequestBody CompilerModel compilerModel){
        String output = "";
        JSONObject jsonObject = null;
        System.out.println(compilerModel.getSourceCodeId());
        List<TestModel> testModels = testService.findAllBySourceCodeId(compilerModel.getSourceCodeId());
        if (!testModels.isEmpty()) {
            for (TestModel testModel : testModels) {
                String res = compilerService.executeCode(compilerModel, testModel.getInput());
                System.out.println(res);
                jsonObject = new JSONObject(res);
                output = jsonObject.get("output").toString().trim();
                String[] arr = output.split("\n");
                System.out.println(arr[arr.length - 1]);
                if (!arr[arr.length - 1].equals(testModel.getOutput())) {
                    return new CompilerResponseModel("Code not accepted");
                }
            }
        } else {
            throw new RecordNotFoundException("Tests not found");
        }
        System.out.println(output);

        return new CompilerResponseModel(
                jsonObject.get("output").toString(),
                jsonObject.get("memory").toString(),
                jsonObject.get("cpuTime").toString(),
                jsonObject.get("statusCode").toString(),
                "Code accepted"
        );
    }
}
