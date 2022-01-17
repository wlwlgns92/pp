package portfolio.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import portfolio.domain.dto.MemberDto;
import portfolio.domain.entity.memberentity.MemberRepository;
import portfolio.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    HttpServletRequest request;

    // 회원가입 페이지 이동
    @GetMapping("/member/signup")
    public String signup() {
        return "member/signup";
    }

    // 회원가입
    @ResponseBody
    @PostMapping("/member/signupcontroller")
    public String signupcontroller(MemberDto memberDto,
                                   @RequestParam("address1") String address1,
                                   @RequestParam("address2") String address2,
                                   @RequestParam("address3") String address3,
                                   @RequestParam("address4") String address4) {
        memberDto.setMAddress(address1 + "/" + address2 + "/" + address3 + "/" + address4);
        memberService.signup(memberDto);
            return "redirect:/";

    } // 회원가입 end

    // 아이디 중복 체크
    @ResponseBody
    @PostMapping("/member/idcheck")
    public String idcheck(@RequestParam("mId") String mId) {
        boolean result = memberService.idcheck(mId);
        if (result) {
            return "1";
        } else {
            return "2";
        }
    } // 아이디 중복체크 end

    //이메일 중복 체크
    @ResponseBody
    @PostMapping("/member/emailcheck")
    public String emailcheck(@RequestParam("mEmail") String mEmail) {
        boolean result = memberService.emailcheck(mEmail);
        if (result) {
            return "1";
        } else {
            return "2";
        }
    } // 이메일 중복체크 end

    @ResponseBody
    @PostMapping("/member/logincontroller")
    public String logincontroller(@RequestBody MemberDto memberDto) {
        MemberDto loginDto = memberService.login(memberDto);
        if(loginDto != null ) {
            HttpSession session = request.getSession();
            session.setAttribute("loginDto" , loginDto);
            return "1";
        }else {
            return "2";
        }
    }
}
