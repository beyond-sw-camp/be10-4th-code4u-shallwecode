package com.shallwecode.backend.problem.application.service;

import com.shallwecode.backend.problem.application.dto.try$.FindMyTryResDTO;
import com.shallwecode.backend.problem.application.dto.try$.FindTryResDTO;
import com.shallwecode.backend.problem.application.dto.try$.SaveTryReqDTO;
import com.shallwecode.backend.problem.domain.service.TryDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TryService {

    private final TryDomainService tryDomainService;

    public void saveTry(Long userId, Long problemId, SaveTryReqDTO saveTryReqDTO) {

        tryDomainService.save(userId, problemId, saveTryReqDTO);
    }

    public void deleteTry(Long userId, Long problemId, Long tryId) {

        FindTryResDTO findTry = tryDomainService.findById(tryId);

        if(!Objects.equals(findTry.getUserId(), userId)) {
            throw new IllegalArgumentException();
        }

        if(!Objects.equals(findTry.getProblemId(), problemId)) {
            throw new IllegalArgumentException();
        }

        tryDomainService.delete(tryId);
    }

    public List<FindMyTryResDTO> findAllMyTry(Long userId, Long problemId) {

        return tryDomainService.findAllMyTry(userId, problemId);
    }

    public FindTryResDTO findTry(Long tryId) {

        return tryDomainService.findById(tryId);
    }
}
