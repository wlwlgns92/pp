function login() {

    var loginmId = $("#loginmId").val();
    var loginmPw = $("#loginmPw").val();
//    var memberdto = {"loginmId": loginmId, "loginmPw": loginmPw};

    $.ajax({
        url : "/member/logincontroller",
//        data : JSON.stringify(memberdto),
        data : {"loginmId": loginmId, "loginmPw": loginmPw},
        method : "POST",
//        contentType : "application/json",
        success : function(result) {
            if(result == 1) {
                location.href="/";
            }else {
                $("#loginmsg").html("일치하는 정보가 없습니다.");
            }
        }
    });
}


function findid() {
alert("아이디찾기");
}

function findpw() {
alert("비밀번호 찾기");
}

