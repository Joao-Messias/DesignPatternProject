public class MongoDBFactory extends DatabaseFactory {
    @Override
    public IDatabase createDatabase() {
        return new MongoDB();
    }

}