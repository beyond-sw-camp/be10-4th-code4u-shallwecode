package com.shallwecode.backend.problem.application.dto;

import com.shallwecode.backend.problem.domain.aggregate.TryLanguage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CodingRoomReqDTO {

    private Long problemId;  // 외래 키로 문제 ID를 참조
    private TryLanguage tryLanguage; // ENUM 타입의 언어
    private String codeContent;
    private boolean isOpen;

}
