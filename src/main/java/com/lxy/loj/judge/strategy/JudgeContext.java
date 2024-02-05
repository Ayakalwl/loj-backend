package com.lxy.loj.judge.strategy;

import com.lxy.loj.model.dto.question.JudgeCase;
import com.lxy.loj.judge.codesandbox.model.JudgeInfo;
import com.lxy.loj.model.entity.Question;
import com.lxy.loj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}