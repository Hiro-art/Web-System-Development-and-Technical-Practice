$(document).ready(function(){
    // your js starts here

    function get_contact_form_info(){
        var email = $("#email").val();
        var message = $("#message").val();

        if(email.match(/^\w+@\w+\.\w+$/i)){
            // 下 面代码将返回值赋值给HTML中的指定对象并且输出
        document.getElementById("out-input").innerHTML = "Your email is " + email + " and your message is " + message;
        }
        else{
            // 下面代码将返回值赋值给HTML中的指定对象并且输出
        document.getElementById("out-input").innerHTML = "The wrong mailbox format";
        }
        
    }

    $("#submit-button").click(function(){
        get_contact_form_info();
    });
});
