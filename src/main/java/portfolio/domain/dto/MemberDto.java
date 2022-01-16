package portfolio.domain.dto;


import lombok.*;

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
}
