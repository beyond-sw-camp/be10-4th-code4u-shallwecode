package com.shallwecode.backend.user.domain.service;

import com.shallwecode.backend.user.application.dto.UserSaveDTO;
import com.shallwecode.backend.user.application.dto.UserUpdateDTO;
import com.shallwecode.backend.user.domain.aggregate.UserInfo;
import com.shallwecode.backend.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDomainService {
    private final UserRepository userRepository;

    // 회원 가입 시 유효성 검사
    public void validateNewUser(UserInfo userInfo) {
        if (userRepository.existsByEmail(userInfo.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 사용자 email 입니다.");
        }
    }

    // 회원 닉네임 수정
    public void updateUser(UserInfo userInfo, UserUpdateDTO userUpdateDTO) {
        userInfo.updateUser(userUpdateDTO.getNickName());
    }

    // 회원 삭제
    public void deleteUser(Long userId){
        UserInfo userInfo = userRepository.findById(userId).orElseThrow(()->new UsernameNotFoundException("user not found " + userId));
        userRepository.delete(userInfo);
    }

}
