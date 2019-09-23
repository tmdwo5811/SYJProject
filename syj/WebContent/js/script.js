function maxLengthCheck(object){
  if (object.value.length > object.maxLength){
    object.value = object.value.slice(0, object.maxLength);
  }
}

(function() {
    var startingTime = new Date().getTime();
    // Load the script
    var script = document.createElement("SCRIPT");
    script.src = 'https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js';
    script.type = 'text/javascript';
    document.getElementsByTagName("head")[0].appendChild(script);

    // Poll for jQuery to come into existance
    var checkReady = function(callback) {
        if (window.jQuery) {
            callback(jQuery);
        }
        else {
            window.setTimeout(function() { checkReady(callback); }, 20);
        }
};
// Start polling...
checkReady(function($) {

    $(function() {
      $('.login_button').click(function(){ //로그인 버튼 클릭 이벤트
        $('.l_form').slideToggle();
        $('.j_form').slideUp();
      })
      $('.join_button').click(function(){ //회원가입 버튼 클릭 이벤트
        $('.j_form, .j_menual').slideToggle();
        $('.l_form').slideUp();
      })
      $('.j_textbox').click(function(){
        $(this).val('').focus()
      })
      $('.l_textbox').click(function(){
        $(this).val('').focus()
      })
      $('.loc_p_li').click(function(){ //지역청원 카테고리 클릭 이벤트
        $('.loc_p_li span').animate({'right':1000},300);
      })
      var ljtextbox = $('.j_textbox, .l_textbox');
      ljtextbox.on('focus',function(){
        $(this).siblings('label').fadeOut('fast');
      })
      ljtextbox.on('focusout',function(){
        if($(this).val()==""){
          $(this).siblings('label').fadeIn('fast');
        }
      })
      var selectTarget = $('.selectbox select');
      selectTarget.change(function(){
        var select_name = $(this).children('option:selected').text();
        $(this).siblings('label').text(select_name);
        $(this).siblings('label').css('color','#000');
      })
    });//jQuery end
});
})();
