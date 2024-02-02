package com.lxy.loj.judge;

import com.lxy.loj.model.vo.QuestionSubmitVO;
import com.lxy.loj.service.QuestionService;
import com.lxy.loj.service.QuestionSubmitService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JudgeServiceImpl implements JudgeService {

    @Autowired
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;


    @Override
    public QuestionSubmitVO doJudge(long questionSubmitId) {

        return null;
    }
}
