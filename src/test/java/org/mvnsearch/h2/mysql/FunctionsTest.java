package org.mvnsearch.h2.mysql;

import org.apache.commons.io.IOUtils;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.Test;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        List<String> sentences = getSQLSentences("/testing.sql");
        for (String sentence : sentences) {
            statement.executeQuery(sentence);
            System.out.println("Succeeded:"+sentence);
        }
        statement.close();
    }

    private JdbcDataSource dataSource() throws Exception {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:public");
        dataSource.setUser("sa");
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        List<String> sentences = getSQLSentences("/db/migration/h2/V0__functions.sql");
        for (String sentence : sentences) {
            statement.execute(sentence);
        }
        statement.close();
        return dataSource;
    }

    private List<String> getSQLSentences(String resourcePath) throws Exception {
        List<String> sqlSentences = new ArrayList<>();
        List<String> lines = IOUtils.readLines(this.getClass().getResourceAsStream(resourcePath), Charset.defaultCharset());
        for (String line : lines) {
            line = line.trim();
            if (!line.isEmpty() && !line.startsWith("--")) {
                if (line.endsWith(";")) {
                    line = line.substring(0, line.length() - 1);
                }
                sqlSentences.add(line);
            }
        }
        return sqlSentences;
    }
}
