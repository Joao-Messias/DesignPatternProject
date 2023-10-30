public class DatabaseFactory {
    public Database createDatabase(DatabaseType type) {
        switch (type) {
            case MYSQL:
                return new MySqlDatabase();
            case MONGODB:
                return new MongoDB();
            default:
                throw new IllegalArgumentException("Invalid Database Type");
        }
    }
}
