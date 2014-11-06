package com.ff.server.db;

import java.sql.Connection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import com.jolbox.bonecp.BoneCPDataSource;

/**
 * @ClassName: DbClientFactory
 * @Description: 数据库连接工厂类
 * @author fengjiuchen
 * @date 2014年7月21日 下午5:43:54
 * @version 1.0
 */
public class DbClientFactory {
    
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/newsbeing";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /**
     * @Title: getTemplate 
     * @Description: 获得JdbcTemplate
     * @date 2014年7月30日 下午2:43:37 
     * @return JdbcTemplate 
     * @throws
     */
    public static JdbcTemplate getTemplate() {

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl(MYSQL_URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        return jdbcTemplate;
    }

    /**
     * @Title: getBonecpConnection 
     * @Description: 获得BonecpConnection
     * @date 2014年7月30日 下午2:51:20 
     * @return Connection 
     * @throws
     */
    public static Connection getBonecpConnection() {

        Connection connection = null;
        BoneCPDataSource dataSource = new BoneCPDataSource();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl(MYSQL_URL);
            dataSource.setUsername(USERNAME);
            dataSource.setPassword(PASSWORD);
            dataSource.setMaxConnectionsPerPartition(10);
            dataSource.setMinConnectionsPerPartition(5);
            dataSource.setIdleConnectionTestPeriodInMinutes(60);
            dataSource.setIdleMaxAgeInMinutes(240);
            dataSource.setAcquireIncrement(5);
            connection = dataSource.getConnection();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            dataSource.close();
        }
        
        return connection;
    }
}
