
public class Database {
  private Plutus plutus;
  private String path = "jbdc:sqlite:database.db";
  private DriverManager connection = DriverManager.getConnection(path);
  
  public Database(Plutus plutus) {
    this.plutus = plutus;
    this.path = path;
  }
  public final static void createDB() {
    try (connection) {
      if (connection != null) {
        var meta = connection.getMetaData();
          plutus.getLogger().info("Driver established:" + meta);
          plutus.getLogger().info("A new database has been created.");
      }
    } catch (SQLException e) {
      plutus.getLogger().info(e.getMessage());
    }
  }
  public static void createTable() {
    String table = "CREATE TABLE if not EXISTS items (" +
                   "id INTEGER PRIMARY KEY," +
                   "material text NOT NULL," +
                   "cost INTEGER NOT NULL," +
                   "elasticity INTEGER," +
                   "support INTEGER )";
    try (connection);
    var statement = connection.createStatement()) {
      statement.execute(table);
    } catch (Exception e) {
      plutus.getLogger().info("Exception e, failed to create table." + e);
    }
  }
  public static String getPath() {
    return this.path;
  }
  public final static DriverManager getConnection() {
    return this.connection;
  }
}
