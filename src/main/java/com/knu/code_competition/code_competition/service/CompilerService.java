package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.model.CompilerModel;

public interface CompilerService {
    String executeCode(CompilerModel compilerModel, String stdin);
}
