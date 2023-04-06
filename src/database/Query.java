package database;

public class Query {

    public static String createTableQuery = "CREATE TABLE IF NOT EXISTS `droptable` (" +
            "`drop_Id` int NOT NULL AUTO_INCREMENT, " +
            "`item_Name` varchar(200) DEFAULT NULL, " +
            "`drop_Chance` float DEFAULT NULL, " +
            "`min_Drop` int DEFAULT NULL, " +
            "`max_Drop` int DEFAULT NULL, " +
            "PRIMARY KEY (`drop_Id`)) " +
            "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

    public static String dropTableQuery = "DROP TABLE IF EXISTS `droptable`;";

    public static String insertIntoTable = "INSERT INTO `trpg`.`droptable` " +
            "(`drop_Id`, `item_Name`, `drop_Chance`, `min_Drop`, `max_Drop`) " +
            "VALUES (?, ?, ?, ?, ?)";

    public static String selectAllQuery = "SELECT * FROM `droptable`;";

}
