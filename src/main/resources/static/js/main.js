function login() {

    var loginmId = $("#loginmId").val();
    var loginmPw = $("#loginmPw").val();
    var memberdto = {"loginmId": loginmId, "loginmPw": loginmPw};
    alert(loginmId);
    alert(loginmPw);

    $.ajax({
        url : "",
        data : JSON.stringify(memberdto),
        method : "POST",
        contentType : "application/json",
        success : function(result) {
            if(reusult == 1) {
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

