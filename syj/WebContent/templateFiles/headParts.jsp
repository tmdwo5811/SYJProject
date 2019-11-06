<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<!--- basic page needs
    ================================================== -->
<meta charset="utf-8">
<title>Typerite</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- mobile specific metas
    ================================================== -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS
    ================================================== -->
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/vendor.css">
<link rel="stylesheet" href="css/main.css">

<!-- favicons
    ================================================== -->
<link rel="apple-touch-icon" sizes="180x180" href="apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="favicon-16x16.png">
<link rel="manifest" href="site.webmanifest">
<!-- view
    ================================================== -->
<link rel="stylesheet" href="css/vuestyle.css">
<link rel="stylesheet" href="css/faq.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/login.js"></script>
<script>
	function printClock() {

		var clock = document.getElementById("clock1234"); // 출력할 장소 선택
		var currentDate = new Date(); // 현재시간
		var calendar = currentDate.getFullYear() + "-"
				+ (currentDate.getMonth() + 1) + "-" + currentDate.getDate() // 현재 날짜
		var amPm = 'AM'; // 초기값 AM
		var currentHours = addZeros(currentDate.getHours(), 2);
		var currentMinute = addZeros(currentDate.getMinutes(), 2);
		var currentSeconds = addZeros(currentDate.getSeconds(), 2);

		if (currentHours >= 12) { // 시간이 12보다 클 때 PM으로 세팅, 12를 빼줌
			amPm = 'PM';
			currentHours = addZeros(currentHours - 12, 2);
		}

		if (currentSeconds >= 50) {// 50초 이상일 때 색을 변환해 준다.
			currentSeconds = '<span style="color:#de1951;">' + currentSeconds
					+ '</span>'
		}
		clock.innerHTML = currentHours + ":" + currentMinute + ":"
				+ currentSeconds + " <span style='font-size:20px;'>" + amPm
				+ "</span><br><span>실시간 청원</span>"; //날짜를 출력해 줌

		setTimeout("printClock()", 1000); // 1초마다 printClock() 함수 호출
	}

	function addZeros(num, digit) { // 자릿수 맞춰주기
		var zero = '';
		num = num.toString();
		if (num.length < digit) {
			for (i = 0; i < digit - num.length; i++) {
				zero += '0';
			}
		}
		return zero + num;
	}
</script>
</head>
