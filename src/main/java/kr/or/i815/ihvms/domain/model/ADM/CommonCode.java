package kr.or.i815.ihvms.domain.model.ADM;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="ADM_COMMON_CODE")
public class CommonCode implements Serializable {

    @EmbeddedId
    private CommonCodeId commonCodeId;

    private String name;

    private String desc;
}