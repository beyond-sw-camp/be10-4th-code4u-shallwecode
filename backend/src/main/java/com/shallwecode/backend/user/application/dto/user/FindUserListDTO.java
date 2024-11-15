package com.shallwecode.backend.user.application.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindUserListDTO {

    private Long userId;
    private String email;
    private String nickname;
    private boolean isFriend;
}
