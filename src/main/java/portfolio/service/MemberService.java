package portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import portfolio.domain.dto.MemberDto;
import portfolio.domain.entity.memberentity.MemberRepository;

public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public boolean signup (MemberDto memberDto) {
        memberRepository.save(memberDto.toentity());
    }
}
