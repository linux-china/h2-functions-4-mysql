package org.mvnsearch.h2;

import org.h2.tools.RunScript;
import org.h2.util.IOUtils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * H2 functions loader
 *
 * @author linux_china
 */
public class H2FunctionsLoader {

    public static void loadMysqlFunctions(DataSource dataSource) {
        try {
            Connection conn = dataSource.getConnection();
            RunScript.execute(conn, IOUtils.getReader(H2FunctionsLoader.class.getResourceAsStream("/db/migration/h2/V0__functions.sql")));
            conn.close();
        } catch (Exception ignore) {

        }
    }
}
