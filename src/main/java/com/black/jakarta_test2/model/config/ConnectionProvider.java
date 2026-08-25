package com.black.jakarta_test2.model.config;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider {
    private final static BasicDataSource BASIC_DATA_SOURCE = new BasicDataSource();

    static {
        BASIC_DATA_SOURCE.setDriverClassName("org.h2.Driver");
        BASIC_DATA_SOURCE.setUrl("jdbc:h2:file:c:/root/db/sample_db");
        BASIC_DATA_SOURCE.setUsername("sa");
        BASIC_DATA_SOURCE.setPassword("");
        BASIC_DATA_SOURCE.setMinIdle(5);
        BASIC_DATA_SOURCE.setMaxTotal(20);
    }

    public Connection getConnection() throws SQLException {
        return BASIC_DATA_SOURCE.getConnection();

    }
}
