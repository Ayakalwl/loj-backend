package com.lxy.loj.judge.strategy;

import com.lxy.loj.model.dto.questionsubmit.JudgeInfo;

public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}