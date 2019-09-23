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
        $('.j_form').slideToggle();
        $('.l_form').slideUp();
      })
      $('.j_textbox').click(function(){
        $(this).val('').focus()
      })
      $('.l_textbox').click(function(){
        $(this).val('').focus()
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
    });//jQuery end
});
})();
