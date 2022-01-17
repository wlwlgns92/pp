$(function() {
    $("#mId").keyup(function() {
        var mId = $("#mId").val();
        var idj = /^[a-z0-9]{5,15}$/;

        if (!idj.test(mId)) {
            $("#idcheck").html("영소문자 5~15 글자로 가능합니다.");
            return false;
        } else {
            $.ajax({
                url: "/member/idcheck",
                method: "post",
                data: {
                    "mId": mId
                },
                success: function(result) {
                    if (result == 1) {
                        $("#idcheck").html("이미 사용중인 아이디 입니다.");
                        return false;
                    } else {
                        $("#idcheck").html("사용가능");
                    }
                }
            });
        }
    }); // idcheck end

    $("#mPw").keyup(function() {
        var mPw = $("#mPw").val();
        var pwj = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\d~!@#$%^&*()+|=]{8,16}$/

        if (!pwj.test(mPw)) {
            $("#pwcheck").html("비밀번는 '숫자' '문자' '특수문자' 1개 이상을 포함해야하며, 최소 8글자에서 16글자까지 가능합니다.");
            return false;
        } else {
            $("#pwcheck").html("사용가능");
        }
    }); // pwcheck end
    $("#mPwcon").keyup(function(){
        var mPw = $("#mPw").val();
        var mPwcon = $("#mPwcon").val();
        var pwj = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\d~!@#$%^&*()+|=]{8,16}$/

        if (!pwj.test(mPwcon)) {
            $("#pwcheck").html("비밀번는 '숫자' '문자' '특수문자' 1개 이상을 포함해야하며, 최소 8글자에서 16글자까지 가능합니다.");
            return false;
        } else if (mPw != mPwcon) {
            $("#pwcheck").html("비밀번호가 일치하지 않습니다.");
            return false;
        } else {
            $("#pwcheck").html("사용가능");
        }
    }); // pwcon end

    $("#mName").keyup(function() {
        var mName = $("#mName").val();
        var namej = /^[A-Aa-a가-힣]{1,10}$/;

        if (!namej.test(mName)) {
            $("#namecheck").html("이름은 '영어', '한글' 1~10글자로 가능합니다.");
            return;
        } else {
            $("#namecheck").html("사용가능");
        }
    }); // namecheck end

    $("#mPhone").keyup(function() {
        var mPhone = $("#mPhone").val();
        var phonej = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;

        if (!phonej.test(mPhone)) {
            $("#phonecheck").html("000-0000-0000 형식으로 입력해 주세요");
            return false;
        } else {
            $("#phonecheck").html("사용가능");
        }
    }); // phonecheck end

    $("#mEmail").keyup(function() {
        var mEmail = $("#mEmail").val();
        var emailj = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

        if (!emailj.test(mEmail)) {
            $("#emailcheck").html("이메일 형식으로 입력해 주세요");
            return;
        } else {

            $.ajax({
                url: "/member/emailcheck",
                data : {
                    "mEmail": mEmail
                },
                method: "post",
                success: function(result) {
                    if (result == 1) {
                        $("#emailcheck").html("이미 사용중인 이메일 입니다.");
                    } else {
                        $("#emailcheck").html("사용가능");
                    }
                }
            }); // email ajax end
        }
    }); // emailcheck end

    $("#sample3_postcode").keyup(function() {
        var address1 = $("#sample3_postcode").val();
        if (address1.indexOf("/") != -1) {
            $("#addresscheck").html("주소에 / 입력 불가");
            return;
        }
        if (address1 != null) {
            $("#addresscheck").html("사용가능");
        }
    });
    $("#sample3_address").keyup(function() {
        var address2 = $("#sample3_address").val();
        if (address2.indexOf("/") != -1) {
            $("#addresscheck").html("주소에 / 입력 불가");
            return;
        }
        if (address2 != null) {
            $("#addresscheck").html("사용가능");
        }
    });
    $("#sample3_detailAddress").keyup(function() {
        var address3 = $("#sample3_detailAddress").val();
        if (address3.indexOf("/") != -1) {
            $("#addresscheck").html("주소에 / 입력 불가");
            return;
        }
        if (address3 != null) {
            $("#addresscheck").html("사용가능");
        }
    });
    $("#sample3_extraAddress").keyup(function() {
        var address4 = $("#sample3_extraAddress").val();
        if (address4.indexOf("/") != -1) {
            $("#addresscheck").html("주소에 / 입력 불가");
            return;
        }
        if (address4 != null) {
            $("#addresscheck").html("사용가능");
        }
    });

    $("#formsubmit").click(function() {
        if ($("#mId").val == null) {
            alert("아이디를 입력해 주세요");
        } else if ($("#idcheck").html() != "사용가능") {
            alert("아이디를 확인해 주세요");
        } else if ( $("#mPw").val == null) {
            alert("비밀번호를 입력해 주세요");
        } else if ($("#pwcheck").html() != "사용가능") {
            alert("비밀번호를 확인해 주세요");
        } else if ($("#mName").val == null) {
            alert("이름을 입력해 주세요");
        } else if ($("#namecheck").html() != "사용가능") {
            alert("이름을 확인해 주세요");
        } else if ($("#mPhone").val == null) {
            alert("연락처를 입력해 주세요");
        } else if ($("#phonecheck").html() != "사용가능") {
            alert("연락처를 확인해 주세요");
        } else if ($("#mEmail").val == null) {
            alert("이메일을 입력해 주세요");
        } else if ($("#emailcheck").html() != "사용가능") {
            alert("이메일을 확인해 주세요");
        } else if ($("#mAddress").val == null) {
            alert("주소를 입력해 주세요");
        } else if ($("#addresscheck").html() != "사용가능") {
            alert("주소를 확인해 주세요");
        }
        else {
            $("form").submit();
        }
    });
}); // function end