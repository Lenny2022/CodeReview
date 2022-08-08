import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: lenny
 * @Date: 2022/7/24 18:10
 * @Description:
 */
public class Application {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringConfiguration.xml");
        druidDemo(ctx);
        //System.out.println("dataSource:" + dataSource);


    }

    private static void druidDemo(ApplicationContext ctx) throws SQLException {
        // 1.通过bean容器获取数据源对象
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");

        // 2. Druid获取数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println("connection:" + connection);

        // 3. Druid执行sql语句
        String sql = "select * from person";

        // 4. 执行sql语句，并返回结果集
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + "\t" + resultSet.getString("name") + "\t" + resultSet.getString("age"));
        }

        // 5. 关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
