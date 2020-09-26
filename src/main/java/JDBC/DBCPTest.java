package JDBC;

import java.sql.*;
import java.util.logging.Logger;

public class DBCPTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            System.out.println("通过线程池连接数据库...");
            conn = DBCPDataSource.getConnection();
            // 执行查询
            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name FROM test";
            rs = stmt.executeQuery(sql);
            // 展开结果集
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print("姓名: " + name);
                System.out.print("\n");
            }
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            DBCPDataSource.close(rs,stmt,conn);
        }
        System.out.println("Goodbye!");
    }
}
