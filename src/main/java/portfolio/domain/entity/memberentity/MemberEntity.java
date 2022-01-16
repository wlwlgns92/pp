package portfolio.domain.entity.memberentity;

import lombok.*;
import portfolio.domain.entity.BasetimeEntity;

import javax.persistence.*;

@Entity
@Table(name="member")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberEntity extends BasetimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mNo;
    @Column(name="mId")
    private String mId;
    @Column(name="mpw")
    private String mPw;
    @Column(name="mName")
    private String mName;
    @Column(name="mPhone")
    private String mPhone;
    @Column(name="mSex")
    private String mSex;
    @Column(name="mEmail")
    private String mEmail;
    @Column(name="mAddress")
    private String mAddress;
    @Column(name="mPoint")
    private int mPoint;

}
