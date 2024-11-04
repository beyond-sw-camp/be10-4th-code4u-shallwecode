package com.shallwecode.backend.problem.domain.service;

import com.shallwecode.backend.problem.application.dto.ProblemReqDTO;
import com.shallwecode.backend.problem.application.dto.ProblemResDTO;
import com.shallwecode.backend.problem.domain.aggregate.Problem;
import com.shallwecode.backend.problem.domain.aggregate.Testcase;
import com.shallwecode.backend.problem.domain.repository.ProblemRepository;
import com.shallwecode.backend.problem.domain.repository.TestcaseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProblemDomainService {

    private final ProblemRepository repository;
    private final TestcaseRepository testCaseRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void saveProblem(ProblemReqDTO newProblem) {

        Problem problem = modelMapper.map(newProblem, Problem.class);
        repository.save(problem);

        // 연관된 테스트 케이스 저장
        newProblem.getTestcases().forEach(testcaseReqDTO -> {
            Testcase testcase = modelMapper.map(testcaseReqDTO, Testcase.class);
            testcase.setProblem(problem); // 문제와 테스트 케이스 연결
            testCaseRepository.save(testcase);
        });

    }

    @Transactional
    public void updateProblem(Long id, ProblemReqDTO updateProblem) {

        // 문제를 조회하고 제목, 내용, 난이도 업데이트
        Problem foundProblem = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 id에 맞는 문제가 존재하지 않습니다."));
        foundProblem.updateProblemTitle(updateProblem.getTitle());
        foundProblem.updateProblemContent(updateProblem.getContent());
        foundProblem.updateProblemProblemLevel(updateProblem.getProblemLevel());

        // 기존 테스트 케이스 삭제 후 새로운 테스트 케이스 추가
        testCaseRepository.deleteByProblem_ProblemId(id);
        updateProblem.getTestcases().forEach(testcaseReqDTO -> {
            Testcase testcase = modelMapper.map(testcaseReqDTO, Testcase.class);
            testcase.setProblem(foundProblem); // 문제와 테스트 케이스 연결 설정
            testCaseRepository.save(testcase);
        });


    }

    @Transactional
    public void deleteProblem(Long problemId) {

        // 문제와 연관된 테스트 케이스 모두 삭제 후 문제 삭제
        testCaseRepository.deleteById(problemId);
        repository.deleteById(problemId);
    }




}