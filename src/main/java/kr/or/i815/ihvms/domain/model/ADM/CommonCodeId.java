package kr.or.i815.ihvms.domain.model.ADM;

import java.io.Serializable;

import javax.persistence.Embeddable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CommonCodeId implements Serializable {

    public String mainCode;

    public String subCode;
}