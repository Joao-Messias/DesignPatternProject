public class MySqlDatabaseFactory extends DatabaseFactory {
    @Override
    public IDatabase createDatabase() {
        return new MySqlDatabase();
    }

}
