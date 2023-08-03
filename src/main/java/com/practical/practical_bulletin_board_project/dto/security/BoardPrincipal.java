package com.practical.practical_bulletin_board_project.dto.security;

import com.practical.practical_bulletin_board_project.domain.UserAccount;
import com.practical.practical_bulletin_board_project.dto.UserAccountDto;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public record BoardPrincipal(
        String username,
        String password,
        Collection<? extends GrantedAuthority> authorities,
        String email,
        String nickname,
        String memo
) implements UserDetails {

    public static BoardPrincipal of(String username, String password, String email, String nickname, String memo) {
        Set<RoleType> roleTypes = Set.of(RoleType.USER);

        return new BoardPrincipal(
               username,
               password,
               roleTypes.stream()
                       .map(RoleType::getName)
                       .map(SimpleGrantedAuthority::new)
                       .collect(Collectors.toUnmodifiableSet()),
               email,
               nickname,
               memo
       );
    }
      public static BoardPrincipal from (UserAccountDto dto){
        return BoardPrincipal.of(
                dto.userId(),
                dto.userPassword(),
                dto.email(),
                dto.nickname(),
                dto.memo()
        );
      }

      public UserAccountDto toDto(){
        return UserAccountDto.of(
                username,
                password,
                email,
                nickname,
                memo
        );
      }


    @Override // 권한에 대한 부분 : 로그인 한 사용자가 어떤 권한 갖고 있냐
    public Collection<? extends GrantedAuthority> getAuthorities() {return authorities;}

    @Override public String getUsername() {return username;}
    @Override public String getPassword() {return password;}

    @Override public boolean isAccountNonExpired() {return true;} //만료됐는가
    @Override public boolean isAccountNonLocked() {return true;} //locked 됐는가
    @Override public boolean isCredentialsNonExpired() {return true;} //기한만료 됐는가
    @Override public boolean isEnabled() {return true;} //활성화된 유저인가


    public enum RoleType {
        USER("ROLE_USER");
        @Getter
        private final String name;
        RoleType(String name){
            this.name = name;
        }
    }
}