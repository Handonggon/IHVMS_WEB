package kr.or.i815.ihvms.dto;

import kr.or.i815.ihvms.domain.model.ADM.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDto {

    private Long userNo;

    private String userNm;

    private String userId;

    private String userPw;

    public UserDto(User entity){
        this.userNo = entity.getUserNo();
        this.userNm = entity.getUserNm();
        this.userId = entity.getUserId();
        this.userPw = entity.getUserPw();
    }

    public User toEntity(){
        return User.builder()
                         .userNo(this.userNo)
                         .userNm(this.userNm)
                         .userId(this.userId)
                         .userPw(this.userPw)
                         .build();
    }
}