
public class Database {
  private Plutus plutus;
  private String path = "jbdc:sqlite:database.db";
  
  public Database(Plutus plutus) {
    this.plutus = plutus;
  }
  public final static void createDB() {
    try (var connection = DriverManager.getConnection(path)) {
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
                   "name text NOT NULL," +
                   ")";
  }
}
