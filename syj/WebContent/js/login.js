function memberReg(){
	document.location="join_testPro.do";
}
function loginCheck1(){
	var joinForm = document.contactForm;
	var id = joinForm.id;
	var pw = joinForm.pw;
	var pw2 = joinForm.pw2;
	var loc = joinForm.loc;
	var both = joinForm.both;
	var gender = joinForm.both;
	var phone = joinForm.phone;
	
	if(id.value == "" || pw.value == "" || pw2.value == "" || loc.value == "" || both.value == "" || gender.value == "" || phone.value == ""){
		alert("빈칸을 반드시 채워주세요");
	}else{
		loginForm.submit();
	}
}
function maxLengthCheck(e){
    if(e.value.length > e.maxLength){
        e.value = e.value.slice(0, e.maxLength);
    }
}