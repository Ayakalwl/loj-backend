package com.lxy.loj.judge;

import com.lxy.loj.model.entity.QuestionSubmit;
import com.lxy.loj.model.vo.QuestionSubmitVO;

/**
 * 判题服务
 */
public interface JudgeService {
    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmitVO doJudge(long questionSubmitId);

}
