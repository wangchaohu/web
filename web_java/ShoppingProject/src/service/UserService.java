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
        List<String[]> list = LiteSql.getInstance().querySqlRL("select * from users where id = 100");
       if (null != list && !list.isEmpty()){

           System.out.print(list.size());
           for (int i = 0; i < list.size(); i++) {
               String[] strings = list.get(i);
               //对user二次封装
               user.setName(strings[1]);
               user.setEmail(strings[3]);
               user.setGrade(Integer.parseInt(strings[5]));
           }
            return true;
        }else {
            return false;
        }
    }
}
