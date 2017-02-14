package model;

/**
 * Created by wangchaohu on 2017/2/14.
 */
public class SendMail {

    //发送的邮件内容
    private String mailBody = "<meta http-equiv=Content-Type content=text/html; charset=utf-8>"
            + "<div align=center><h1 color=red> 我是王朝虎，,,,</h1></div>";

    //指定让哪个smtp转发（搜狐）
    sendMail theMail = new sendMail("smtp.sohu.com");

    //校验身份
    theMail.setNeedAuth(true);

//    邮件标题
    if (theMail.setSubject("测试") == false){
        return ;
    }

//    将要发送的，内容放入邮件体
    if (theMail.setBody(mailBody) == false){
        return;
    }

//    发送到哪里
    if (theMail.setTo("red_ddd.com") == false){
        return;
    }

//    谁发送的
    if (theMail.setFrom("") == false){
        return;
    }

//    添加附件
    if (theMail.addFileAffix("文件路径") == false){
        return;
    }

//    邮箱名和密码
    theMail.setNamePass("", "");

//    发送
    if (theMail.sendOut() == false){
        return ;
    }
}
