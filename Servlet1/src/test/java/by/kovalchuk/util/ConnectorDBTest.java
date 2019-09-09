package by.kovalchuk.util;


import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class ConnectorDBTest {

    @Test
    public void testGetConnection() {
        Connection connection = ConnectorDB.getConnection();

        Assert.assertNotNull(connection);

    }
}
