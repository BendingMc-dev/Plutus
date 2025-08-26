package me.ryandusty.plutus.db;

import me.ryandusty.plutus.Plutus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
  private final Plutus plutus;
  private final String path = "jdbc:sqlite:database.db";
  private Connection connection;

  public Database(Plutus plutus) {
    this.plutus = plutus;
    try {
      this.connection = DriverManager.getConnection(path);
      var meta = connection.getMetaData();
      plutus.getLogger().info("Driver established: " + meta.getDriverName());
      plutus.getLogger().info("A new database has been created or connected to.");
    } catch (SQLException e) {
      plutus.getLogger().severe("Failed to connect to the database: " + e.getMessage());
    }
  }

  public void createTable() {
    String table = "CREATE TABLE IF NOT EXISTS items (" +
            "id INTEGER PRIMARY KEY," +
            "material TEXT NOT NULL," +
            "cost INTEGER NOT NULL," +
            "elasticity INTEGER," +
            "support INTEGER)";
    try (Statement statement = connection.createStatement()) {
      statement.execute(table);
    } catch (SQLException e) {
      plutus.getLogger().severe("Exception e, failed to create table: " + e.getMessage());
    }
  }

  public String getPath() {
    return this.path;
  }

  public Connection getConnection() {
      return connection;
  }

  public void closeConnection() {
    try {
      if (this.connection != null && !this.connection.isClosed()) {
        this.connection.close();
      }
    } catch (SQLException e) {
      plutus.getLogger().severe("Failed to close database connection: " + e.getMessage());
    }
  }
}