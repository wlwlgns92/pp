package portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.domain.dto.MemberDto;
import portfolio.domain.entity.memberentity.MemberEntity;
import portfolio.domain.entity.memberentity.MemberRepository;

import java.lang.reflect.Member;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public boolean signup(MemberDto memberDto) {
        memberRepository.save(memberDto.toentity());
        return true;
    }

    public boolean idcheck(String mId) {
        List<MemberEntity> memberEntities = memberRepository.findAll();

        for (MemberEntity memberEntity : memberEntities) {
            if (memberEntity.getMId().equals(mId)) {
                return true;
            }
        }
        return false;
    }

    public boolean emailcheck(String mEmail) {
        List<MemberEntity> memberEntities = memberRepository.findAll();

        for (MemberEntity memberEntity : memberEntities) {
            if (memberEntity.getMEmail().equals(mEmail)) {
                return true;
            }
        }
        return false;
    }

    public MemberDto login(MemberDto memberDto) {
        List<MemberEntity> memberEntities = memberRepository.findAll();

        for(MemberEntity memberEntity : memberEntities) {
            if(memberEntity.getMId().equals(memberDto.getMId()) && memberEntity.getMPw().equals(memberDto.getMPw())) {
                return MemberDto.builder()
                        .mId(memberEntity.getMId())
                        .mPw(memberEntity.getMPw())
                        .build();
            }
        }
        return null;
    }
}
