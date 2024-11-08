package com.shallwecode.backend.oauth2;

import com.shallwecode.backend.user.domain.aggregate.AuthType;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
public class CustomOAuth2User extends DefaultOAuth2User {

    private final Long userId;
    private final AuthType auth;

    public CustomOAuth2User(Collection<? extends GrantedAuthority> authorities,
                            Map<String, Object> attributes, String nameAttributeKey,
                            Long userId, AuthType auth) {
        super(authorities, attributes, nameAttributeKey);
        this.userId = userId;
        this.auth = auth;
    }
}