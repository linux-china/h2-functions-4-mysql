package org.mvnsearch.h2.mysql;

import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.h2.util.IOUtils;
import org.h2.util.StringUtils;
import org.junit.Test;

import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * functions test
 *
 * @author linux_china
 */
public class FunctionsTest {

    @Test
    public void testExecuteQuery() throws Exception {
        JdbcDataSource dataSource = dataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        Reader reader = IOUtils.getReader(this.getClass().getResourceAsStream("/testing.sql"));
        String content = IOUtils.readStringAndClose(reader, -1);
        String[] sentences = StringUtils.arraySplit(content, ';', true);
        for (String sentence : sentences) {
            if (sentence != null && !sentence.isEmpty() && !sentence.startsWith("--")) {
                ResultSet resultSet = statement.executeQuery(sentence);
                resultSet.next();
                System.out.println("Succeeded: " + sentence + " = " + resultSet.getString(1));
                resultSet.close();
            }
        }
        statement.close();
    }

    private JdbcDataSource dataSource() throws Exception {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:public");
        dataSource.setUser("sa");
        RunScript.execute(dataSource.getConnection(), IOUtils.getReader(this.getClass().getResourceAsStream("/db/migration/h2/V0__functions.sql")));
        return dataSource;
    }
}
