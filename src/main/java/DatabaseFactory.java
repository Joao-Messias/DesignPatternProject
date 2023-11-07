public abstract class DatabaseFactory {
    private static DatabaseFactory instanceMySQL;
    private static DatabaseFactory instanceMongoDB;

    public static DatabaseFactory getMySQLInstance() {
        if (instanceMySQL == null) {
            instanceMySQL = new MySqlDatabaseFactory();
        }
        return instanceMySQL;
    }

    public static DatabaseFactory getMongoDBInstance() {
        if (instanceMongoDB == null) {
            instanceMongoDB = new MongoDBFactory();
        }
        return instanceMongoDB;
    }

    public abstract IDatabase createDatabase();
}
