package service;

import bean.Users;
import utils.LiteSql;

import java.util.List;

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
        int id = user.getId();
        String pwd = user.getPwd();
        List<String> list = LiteSql.getInstance().querySqlRL();
       if (null != list && list.size() > 0){

           System.out.println(list.size());
//        if ("100".equals(id + "") && "123456".equals(pwd)){
            user.setName(list.get(1));
            user.setEmail(list.get(3));
            user.setGrade(Integer.parseInt(list.get(5)));
            return true;
        }else {
            return false;
        }
    }
}
