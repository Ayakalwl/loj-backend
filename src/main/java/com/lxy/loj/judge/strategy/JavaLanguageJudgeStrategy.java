package com.lxy.loj.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.lxy.loj.model.dto.question.JudgeCase;
import com.lxy.loj.model.dto.question.JudgeConfig;
import com.lxy.loj.judge.codesandbox.model.JudgeInfo;
import com.lxy.loj.model.entity.Question;
import com.lxy.loj.model.enums.JudgeInfoMessageEnum;

import java.util.List;

/**
 * 默认判题策略
 */
public class JavaLanguageJudgeStrategy implements JudgeStrategy{
    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        Long memory = judgeInfo.getMemory();
        Long time = judgeInfo.getTime();
        List<String> inputList = judgeContext.getInputList();
        List<String> outputList = judgeContext.getOutputList();
        Question question = judgeContext.getQuestion();
        List<JudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();
        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.ACCEPTED;
        JudgeInfo judgeInfo1Response = new JudgeInfo();
        judgeInfo1Response.setMemory(memory);
        judgeInfo1Response.setTime(time);


        // 先判断沙箱执行的结果输出数量是否和预期输出数量相等
        if (outputList.size() != inputList.size()) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
            judgeInfo1Response.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfo1Response;
        }
        // 依次判断每一项输出和预期输出是否相等
        for (int i = 0; i < judgeCaseList.size(); i++) {
            JudgeCase judgeCase = judgeCaseList.get(i);
            if (!judgeCase.getOutput().equals(outputList.get(i))) {
                judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
                judgeInfo1Response.setMessage(judgeInfoMessageEnum.getValue());
                return judgeInfo1Response;
            }
        }
        // 判断题目限制
        String judgeConfigStr = question.getJudgeConfig();
        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);
        Long needMemoryLimit = judgeConfig.getMemoryLimit();
        Long needTimeLimit = judgeConfig.getTimeLimit();
        if (memory > needMemoryLimit) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.MEMORY_LIMIT;
            judgeInfo1Response.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfo1Response;
        }
        // Java 程序本身需要额外执行 10 秒钟
        long JAVA_PROGRAM_TIME_COST = 10000L;
        if ((time - JAVA_PROGRAM_TIME_COST) > needTimeLimit) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
            judgeInfo1Response.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfo1Response;
        }
        judgeInfo1Response.setMessage(judgeInfoMessageEnum.getValue());
        return judgeInfo1Response;
    }
}
