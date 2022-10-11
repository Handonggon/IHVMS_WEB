package kr.or.i815.ihvms.dto;

import kr.or.i815.ihvms.domain.model.ADM.CommonCode;
import kr.or.i815.ihvms.domain.model.ADM.CommonCodeId;
import lombok.*;

@Getter
@NoArgsConstructor
public class CommonCodeDto {

    private String mainCode;

    private String subCode;

    private String name;

    private String desc;

    public CommonCodeDto(CommonCode entity){
        this.mainCode = entity.getCommonCodeId().getMainCode();
        this.subCode = entity.getCommonCodeId().getSubCode();
        this.name = entity.getName();
        this.desc = entity.getDesc();
    }

    public CommonCode toEntity(){
        return CommonCode.builder()
                         .commonCodeId(new CommonCodeId(this.mainCode, this.subCode))
                         .name(this.name)
                         .desc(this.desc)
                         .build();
    }
}