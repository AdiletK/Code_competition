package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.model.CompilerModel;
import com.knu.code_competition.code_competition.model.CompilerResponseModel;
import org.json.JSONObject;

public interface CompilerService {
    String executeCode(CompilerModel compilerModel);
}
