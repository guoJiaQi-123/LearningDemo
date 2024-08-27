package com.bjsxt.dao.Impl;

import com.bjsxt.commons.JDBCUtils;
import com.bjsxt.dao.UserManagerDao;
import com.bjsxt.pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理持久层接口实现类
 */
public class UserManagerDaoImpl implements UserManagerDao {
    //向数据库表中插入用户
    @Override
    public void insertUser(Users users) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("insert into users values (default,?,?,?,?,?)");
            preparedStatement.setString(1,users.getUsername());
            preparedStatement.setString(2,users.getUserpwd());
            preparedStatement.setString(3,users.getUsersex());
            preparedStatement.setString(4,users.getPhonenumber());
            preparedStatement.setString(5,users.getQqnumber());
            preparedStatement.execute();
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            JDBCUtils.rollBack(conn);
        }finally {
            JDBCUtils.closeConnection(conn);
        }
    }
    /**
     * 查询用户
     * @param users 根据传入的用户数据从数据库中查询用户
     * @return 满足条件的用户集合
     */
    @Override
    public List<Users> selectUserByProperty(Users users) {
        Connection conn=null;
        List<Users> list=new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();

            String sql = this.creatSQL(users);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Users user=new Users();
                user.setUsername(resultSet.getString("username"));
                user.setUserid(resultSet.getInt("userid"));
                user.setUserpwd(resultSet.getString("userpwd"));
                user.setUsersex(resultSet.getString("usersex"));
                user.setPhonenumber(resultSet.getString("phonenumber"));
                user.setQqnumber(resultSet.getString("qqnumber"));
                list.add(user);
            }

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            JDBCUtils.closeConnection(conn);
        }
        return list;
    }

    /**
     * 预更新用户
     * @param userid
     * @return
     */
    @Override
    public Users selectUserByUserId(int userid) {
        Connection conn = null;
        Users users=null;
        try {
            conn=JDBCUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select * from users where userid = ?");
            preparedStatement.setInt(1,userid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                users=new Users();
                users.setUsername(resultSet.getString("username"));
                users.setUserid(resultSet.getInt("userid"));
                users.setUserpwd(resultSet.getString("userpwd"));
                users.setUsersex(resultSet.getString("usersex"));
                users.setPhonenumber(resultSet.getString("phonenumber"));
                users.setQqnumber(resultSet.getString("qqnumber"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            JDBCUtils.closeConnection(conn);
        }
        return users;
    }

    /**
     * 更新用户
     * @param users
     */
    @Override
    public void updateUserByUserId(Users users){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("update users set username = ? , usersex = ? ,phonenumber=?,qqnumber=? where userid=?");
            preparedStatement.setString(1,users.getUsername());
            preparedStatement.setString(2,users.getUsersex());
            preparedStatement.setString(3,users.getPhonenumber());
            preparedStatement.setString(4,users.getQqnumber());
            preparedStatement.setInt(5,users.getUserid());
            preparedStatement.execute();
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            JDBCUtils.rollBack(conn);
        }finally {
            JDBCUtils.closeConnection(conn);
        }
    }

    /**
     * 删除用户
     * @param userid
     */
    @Override
    public void deleteUserByUserId(int userid) {
        Connection conn = null;
        try {
            conn=JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("delete  from users where userid = ?");
            preparedStatement.setInt(1,userid);
            preparedStatement.execute();

            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            JDBCUtils.rollBack(conn);
        }finally {
            JDBCUtils.closeConnection(conn);
        }
    }

    /**
     * //拼接查询的 SQL 语句
     * @param users
     * @return
     */
    private String creatSQL(Users users) {
        StringBuffer stringBuffer = new StringBuffer("select * from users where 1=1 ");
        if(users.getPhonenumber()!=null&&users.getPhonenumber().length()>0){
            stringBuffer.append(" and phonenumber = "+users.getPhonenumber());
        }
        if(users.getUsername()!=null&&users.getUsername().length()>0){
            stringBuffer.append(" and username = '"+users.getUsername()+"'");
        }
        if(users.getUsersex()!=null&&users.getUsersex().length()>0){
            stringBuffer.append(" and usersex = "+users.getUsersex());
        }
        if(users.getQqnumber()!=null&&users.getQqnumber().length()>0){
            stringBuffer.append(" and qqnumber = "+users.getQqnumber());
        }
        return stringBuffer.toString();
    }
}
