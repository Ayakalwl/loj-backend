package com.lxy.loj.judge;

import com.lxy.loj.judge.strategy.DefaultJudgeStrategy;
import com.lxy.loj.judge.strategy.JavaLanguageJudgeStrategy;
import com.lxy.loj.judge.strategy.JudgeContext;
import com.lxy.loj.judge.strategy.JudgeStrategy;
import com.lxy.loj.judge.codesandbox.model.JudgeInfo;
import com.lxy.loj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}