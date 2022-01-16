package portfolio.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import portfolio.domain.dto.MemberDto;
import portfolio.domain.entity.memberentity.MemberRepository;
import portfolio.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    // 회원가입 페이지 이동
    @GetMapping("/member/signup")
    public String signup() {
        return "member/signup";
    }

    @PostMapping("/member/signupcontroller")
    public String signupcontroller(MemberDto memberDto,
                                   @RequestParam("address1") String address1,
                                   @RequestParam("address2") String address2,
                                   @RequestParam("address3") String address3,
                                   @RequestParam("address4") String address4) {
        memberDto.setMAddress(address1 + "/" + address2 + "/" + address3 + "/" + address4);
        boolean result = memberService.signup(memberDto);
        if(result) {
            return "1";
        }else {
            return "2";
        }

    }
}
