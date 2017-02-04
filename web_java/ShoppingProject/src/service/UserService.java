package service;

import bean.Users;

/**
 * Created by wangchaohu on 2017/2/4.
 *
 *
 * 专门用于处理业务逻辑的类
 *
 * 处理与User表相关的业务逻辑
 */
public class UserService {

    //检查用户是否合法
    public boolean checkUser(Users user){
        String sql = "select * from ";
        int id = user.getId();
        String pwd = user.getPwd();

        if ("100".equals(id + "") && "123456".equals(pwd)){
            user.setName("wangchao");
            user.setEmail("123456.qq.com");
            user.setGrade(5);
            return true;
        }else {
            return false;
        }
    }
}
