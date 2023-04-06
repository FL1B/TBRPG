package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Drops {
    private int dropId;
    private String itemName;
    private int dropChance;
    private int minDrop;
    private int maxDrop;
    static List<Drops> drops = new ArrayList<>();

    public Drops(int dropId, String itemName, int dropChance, int minDrop, int maxDrop) {
        this.dropId = dropId;
        this.itemName = itemName;
        this.dropChance = dropChance;
        this.minDrop = minDrop;
        this.maxDrop = maxDrop;


    }

    public int getDropId() {
        return dropId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getDropChance() {
        return dropChance;
    }

    public int getMinDrop() {
        return minDrop;
    }

    public int getMaxDrop() {
        return maxDrop;
    }
    public static void addDropsToArray() throws SQLException {

        drops.add(new Drops(1, "Slime", 20, 1, 3));
        drops.add(new Drops(2, "Coins", 50, 5, 10));
        drops.add(new Drops(3, "Scale", 10, 1, 2));
        drops.add(new Drops(4, "Bone", 30, 2, 5));

        //
    }

    public static void addDropsToDatabase(String url, String username, String password) throws SQLException {

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(Query.dropTableQuery);
        statement.executeUpdate(Query.createTableQuery);
        PreparedStatement preparedStatement = connection.prepareStatement(Query.insertIntoTable);

        for (Drops drops : drops) {
            preparedStatement.setInt(1, drops.getDropId());
            preparedStatement.setString(2, drops.getItemName());
            preparedStatement.setInt(3, drops.getDropChance());
            preparedStatement.setInt(4, drops.getMinDrop());
            preparedStatement.setInt(5, drops.getMaxDrop());
            preparedStatement.executeUpdate();
        }

        System.out.println("Updated droptable with: " + drops.size() + " drops.");
        //printDatabase(url, username, password);
    }

    public static void printDatabase(String url, String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement2 = connection.prepareStatement(Query.selectAllQuery);
        ResultSet resultSet = preparedStatement2.executeQuery();

        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("| %-8s | %-20s | %-12s | %-8s | %-8s |\n",
                "Drop ID", "Item Name", "Drop Chance", "Min Drop", "Max Drop");
        System.out.println("-------------------------------------------------------------------------");

        while (resultSet.next()) {
            int dropId = resultSet.getInt("drop_Id");
            String itemName = resultSet.getString("item_Name");
            int dropChance = resultSet.getInt("drop_Chance");
            int minDrop = resultSet.getInt("min_Drop");
            int maxDrop = resultSet.getInt("max_Drop");

            System.out.printf("| %8d | %-20s | %12d%% | %8d | %8d |\n",
                    dropId, itemName, dropChance, minDrop, maxDrop);
        }

        System.out.println("-------------------------------------------------------------------------");
    }
    public static void addDropToArrayFromConsole(String url, String username, String password) throws SQLException {
        addDropsToArray();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("ID is set automatically. Current id = " + (drops.size()+1) + "\nType 'exit' to finish, or press Enter to add a new drop: ");

            String input = scanner.nextLine().trim();
            if (input.equals("exit")) {
                break;
            }

            int dropId = drops.size() + 1;

            System.out.print("Enter item name: ");
            String itemName = scanner.nextLine();

            System.out.print("Enter drop chance (%): ");
            int dropChance = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter minimum drop: ");
            int minDrop = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter maximum drop: ");
            int maxDrop = scanner.nextInt();
            scanner.nextLine();

            Drops newDrop = new Drops(dropId, itemName, dropChance, minDrop, maxDrop);
            drops.add(newDrop);

            System.out.println("Drop added: " + newDrop.itemName);
            addDropsToDatabase(url, username, password);

        }
        printDatabase(url, username, password);
    }

}
