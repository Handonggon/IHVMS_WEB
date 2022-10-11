package kr.or.i815.ihvms.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSearchDto {

    private Long userNo;

    private String userNm;

    private String userId;

    private String userPw;
}