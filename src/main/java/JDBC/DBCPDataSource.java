package JDBC;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPDataSource {
    /**
     * JDBC参数
     */
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONNECTION = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "dengzefeng";
    private static final String PASSWORD = "deng123";

    private static BasicDataSource jdbcConnectionPool;

    static {
        //初始化数据源
        jdbcConnectionPool = new BasicDataSource();
        jdbcConnectionPool.setDriverClassName(JDBC_DRIVER);
        jdbcConnectionPool.setUrl(CONNECTION);
        jdbcConnectionPool.setUsername(USER);
        jdbcConnectionPool.setPassword(PASSWORD);

        //连接池设置

        jdbcConnectionPool.setInitialSize(5);//初始创建连接
        jdbcConnectionPool.setMaxTotal(20);//最大连接数
        jdbcConnectionPool.setMinIdle(2);//最小空闲连接，通过创建连接保证
    }

    public static Connection getConnection(){
        try {
            //JDBC进行处理，通过JDBC的链接close其实就是直接归还,不断开连接
            return jdbcConnectionPool.getConnection();
        }catch (SQLException e){
            System.out.println("获取连接出错");
            e.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet rs, Statement stmt,Connection con){
        closeResultSet(rs);
        closeStatement(stmt);
        closeConnection(con);

    }

    public static void closeResultSet(ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement stmt){
        try{
            if(stmt != null){
                stmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection con){
        try{
            if(con != null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
