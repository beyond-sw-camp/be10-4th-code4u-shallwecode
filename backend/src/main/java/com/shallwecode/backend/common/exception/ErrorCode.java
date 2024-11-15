package com.shallwecode.backend.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    NOT_SAVED_FRIEND(HttpStatus.CONFLICT, "친구 신청 실패"),
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "회원 조회 실패"),
    NOT_ADMIN_DELETE_USER(HttpStatus.FORBIDDEN, "관리자만 회원을 삭제할 수 있습니다."),
    NOT_ADMIN_DELETE_ADMIN(HttpStatus.FORBIDDEN, "다른 관리자를 삭제할 수 없습니다."),
    SENDED_FRIEND(HttpStatus.CONFLICT, "이미 존재하는 친구 초대 요청"),
    DUPLICATED_FRIEND_USER(HttpStatus.BAD_REQUEST, "자신에게 친구 요청을 보낼 수 없습니다."),
    NOT_FOUND_FRIEND(HttpStatus.NOT_FOUND, "해당 친구 요청을 찾을 수 없습니다."),
    NOT_CHANGED_FRIEND(HttpStatus.BAD_REQUEST, "친구 수락, 거절하는데 오류가 발생했습니다."),
    NOT_DELETED_FRIEND(HttpStatus.BAD_REQUEST, "친구 삭제 과정에서 오류가 발생했습니다."),
    NOT_FOUND_NOTI(HttpStatus.NOT_FOUND, "해당 알림은 존재하지 않습니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "인가 실패"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "인증 실패"),
    SOCIAL_LOGIN_FAIL(HttpStatus.UNAUTHORIZED, "소셜 로그인 실패"),
    OVERLAPPING_SAVED_USER(HttpStatus.CONFLICT, "이미 존재하는 회원입니다."),
    GUEST_SOLVED_FILTER_FORBIDDEN(HttpStatus.FORBIDDEN, "비회원은 해결 여부 필터링 기능을 사용할 수 없습니다."),

    // 문제 등록, 수정, 삭제시 관리자 권한 확인
    NOT_ADMIN_SAVE_PROBLEM(HttpStatus.FORBIDDEN, "관리자만 문제를 등록할 수 있습니다."),
    NOT_ADMIN_UPDATE_PROBLEM(HttpStatus.FORBIDDEN, "관리자만 문제를 수정할 수 있습니다."),
    NOT_ADMIN_DELETE_PROBLEM(HttpStatus.FORBIDDEN, "관리자만 문제를 삭제할 수 있습니다."),

    // 코딩방 및 협업 친구
    DUPLICATED_COOP_USER(HttpStatus.CONFLICT, "이미 코딩방에 존재하는 사람을 초대 할 수 없습니다."),
    NOT_INVITE_FRIEND(HttpStatus.CONFLICT, "친구만 코딩방에 초대할 수 있습니다."),
    NOT_HOST(HttpStatus.NOT_FOUND, "호스트가 아닙니다."),
    NOT_FIRED_SELF(HttpStatus.BAD_REQUEST, "자기 자신을 강퇴할 수 없습니다."),
    NOT_GUEST_COOP_USER(HttpStatus.NOT_FOUND, "해당 게스트 유저가 존재하지 않습니다."),
    NOT_HOST_COOP_USER(HttpStatus.NOT_FOUND, "코딩방에 존재하지 않는 유저입니다. 해당 코딩방의 다른 유저를 강퇴할 수 없습니다. "),
    NOT_AUTH_HOST(HttpStatus.BAD_REQUEST, "코딩방 게스트 유저는 강퇴 기능을 사용할 수 없습니다."),
    TOO_MANY_REQUESTS_ROOM(HttpStatus.TOO_MANY_REQUESTS, "해당 코딩방의 인원이 가득 찼습니다."),
    NOT_UPATED_CODE(HttpStatus.BAD_REQUEST, "코드가 코딩방에 저장 실패했습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
