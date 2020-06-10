package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.model.CheckTaskModel;

public interface CheckTaskService {
    CheckTaskModel checkTask(Long userId, Long comId);
}
