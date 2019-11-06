function memberReg(){
	document.location="join_testPro.do";
}
function loginCheck(){
	var joinForm = document.contactForm;
	var id = joinForm.id;
	var pw = joinForm.pw;
	var pw2 = joinForm.pw2;
	var loc = joinForm.loc;
	var both = joinForm.both;
	var gender = joinForm.both;
	var phone = joinForm.phone;
	
	if(!id || !pw || !pw2 || !loc || !both || !gender || !phone){
		alert("모든 칸을 채워주세요");
	}else{
		loginForm.submit();
	}
}
function maxLengthCheck(e){
    if(e.value.length > e.maxLength){
        e.value = e.value.slice(0, e.maxLength);
    }
}