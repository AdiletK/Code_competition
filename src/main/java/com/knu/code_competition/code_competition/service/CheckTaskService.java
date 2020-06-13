package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.model.CheckTaskModel;
import com.knu.code_competition.code_competition.model.ResponseCheckModel;

import java.util.List;

public interface CheckTaskService {
    ResponseCheckModel checkAll();

    List<ResponseCheckModel> checkByCompetitionId(Long compId);

    List<ResponseCheckModel> checkByUserId(Long userId);

    List<ResponseCheckModel> checkByUserAndCompetitionId(Long userId, Long compId);

    CheckTaskModel checkTask(Long userId, Long comId);
}
