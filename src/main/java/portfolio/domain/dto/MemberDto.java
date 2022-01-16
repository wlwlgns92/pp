package portfolio.domain.dto;


import lombok.*;
import portfolio.domain.entity.memberentity.MemberEntity;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MemberDto {

    private String mId;
    private String mPw;
    private String mName;
    private String mSex;
    private String mPhone;
    private String mEmail;
    private String mAddress;
    private int mPoint;

    public MemberEntity toentity () {
        return MemberEntity.builder()
                .mId(this.mId)
                .mPw(this.mPw)
                .mName(this.mName)
                .mSex(this.mSex)
                .mPhone(this.mPhone)
                .mEmail(this.mEmail)
                .mAddress(this.mAddress)
                .mPoint(this.mPoint)
                .build();
    }
}
