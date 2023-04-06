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
        drops.add(new Drops(5, "Sword", 5, 1, 1));
        drops.add(new Drops(6, "Shield", 5, 1, 1));
        drops.add(new Drops(7, "Potion", 15, 1, 3));
        drops.add(new Drops(8, "Arrow", 25, 10, 20));
        drops.add(new Drops(9, "Food", 30, 1, 5));
        drops.add(new Drops(10, "Gemstone", 5, 1, 1));
        drops.add(new Drops(11, "Gold Bar", 3, 1, 1));
        drops.add(new Drops(12, "Book", 10, 1, 3));
        drops.add(new Drops(13, "Key", 2, 1, 1));
        drops.add(new Drops(14, "Map", 8, 1, 1));
        drops.add(new Drops(15, "Hat", 15, 1, 1));
        drops.add(new Drops(16, "Boots", 20, 1, 1));
        drops.add(new Drops(17, "Gloves", 10, 1, 1));
        drops.add(new Drops(18, "Necklace", 5, 1, 1));
        drops.add(new Drops(19, "Ring", 7, 1, 1));
        drops.add(new Drops(20, "Amulet", 3, 1, 1));
        drops.add(new Drops(21, "Scroll", 15, 1, 3));
        drops.add(new Drops(22, "Mace", 5, 1, 1));
        drops.add(new Drops(23, "Helmet", 10, 1, 1));
        drops.add(new Drops(24, "Chainmail", 15, 1, 1));
        drops.add(new Drops(25, "Platebody", 7, 1, 1));
        drops.add(new Drops(26, "Battle Axe", 8, 1, 1));
        drops.add(new Drops(27, "Spear", 7, 1, 1));
        drops.add(new Drops(28, "Hammer", 10, 1, 1));
        drops.add(new Drops(29, "Dagger", 12, 1, 1));
        drops.add(new Drops(30, "Rapier", 3, 1, 1));
        drops.add(new Drops(31, "Longsword", 5, 1, 1));
        drops.add(new Drops(32, "Greatsword", 2, 1, 1));
        drops.add(new Drops(33, "Staff", 5, 1, 1));
        drops.add(new Drops(34, "Wand", 8, 1, 1));
        drops.add(new Drops(35, "Robe", 12, 1, 1));
        drops.add(new Drops(36, "Boots of Speed", 5, 1, 1));
        drops.add(new Drops(37, "Gloves of Strength", 10, 1, 1));
        drops.add(new Drops(38, "Cape of Invisibility", 1, 1, 1));
        drops.add(new Drops(39, "Ring of Fire Resistance", 3, 1, 1));
        drops.add(new Drops(40, "Ring of Ice Resistance", 3, 1, 1));
        drops.add(new Drops(41, "Ring of Poison Resistance", 3, 1, 1));
        drops.add(new Drops(42, "Ring of Lightning Resistance", 3, 1, 1));
        drops.add(new Drops(43, "Ring of Teleportation", 2, 1, 1));
        drops.add(new Drops(44, "Scroll of Summoning", 4, 1, 1));
        drops.add(new Drops(45, "Scroll of Fireball", 7, 1, 1));
        drops.add(new Drops(46, "Scroll of Ice Storm", 7, 1, 1));
        drops.add(new Drops(47, "Scroll of Poison Cloud", 7, 1, 1));
        drops.add(new Drops(48, "Scroll of Lightning Strike", 7, 1, 1));
        drops.add(new Drops(49, "Scroll of Healing", 12, 1, 1));
        drops.add(new Drops(50, "Potion of Invisibility", 5, 1, 1));
        drops.add(new Drops(51, "Potion of Fire Resistance", 15, 1, 1));
        drops.add(new Drops(52, "Potion of Ice Resistance", 15, 1, 1));
        drops.add(new Drops(53, "Potion of Poison Resistance", 15, 1, 1));
        drops.add(new Drops(54, "Potion of Lightning Resistance", 15, 1, 1));
        drops.add(new Drops(55, "Potion of Strength", 10, 1, 1));
        drops.add(new Drops(56, "Potion of Agility", 10, 1, 1));
        drops.add(new Drops(57, "Potion of Endurance", 10, 1, 1));
        drops.add(new Drops(58, "Potion of Intellect", 10, 1, 1));
        drops.add(new Drops(59, "Potion of Wisdom", 10, 1, 1));
        drops.add(new Drops(60, "Potion of Charisma", 10, 1, 1));
        drops.add(new Drops(61, "Potion of Flight", 2, 1, 1));
        drops.add(new Drops(62, "Food Ration", 25, 1, 1));
        drops.add(new Drops(63, "Water Flask", 25, 1, 1));
        drops.add(new Drops(64, "Torch", 20, 1, 1));
        drops.add(new Drops(65, "Rope", 15, 1, 1));
        drops.add(new Drops(66, "Grapple Hook", 5, 1, 1));
        drops.add(new Drops(67, "Lockpick", 10, 1, 1));
        drops.add(new Drops(68, "Crowbar", 5, 1, 1));
        drops.add(new Drops(69, "Sledgehammer", 3, 1, 1));
        drops.add(new Drops(70, "Pickaxe", 7, 1, 1));
        drops.add(new Drops(71, "Shovel", 10, 1, 1));
        drops.add(new Drops(72, "Fishing Rod", 7, 1, 1));
        drops.add(new Drops(73, "Gemstone Shard", 15, 1, 3));
        drops.add(new Drops(74, "Golden Chalice", 8, 1, 1));
        drops.add(new Drops(75, "Silver Plate", 12, 1, 1));
        drops.add(new Drops(76, "Bronze Figurine", 20, 1, 1));
        drops.add(new Drops(77, "Iron Anvil", 15, 1, 1));
        drops.add(new Drops(78, "Steel Ingot", 10, 1, 1));
        drops.add(new Drops(79, "Mithril Ore", 5, 1, 1));
        drops.add(new Drops(80, "Adamantite Bar", 3, 1, 1));
        drops.add(new Drops(81, "Obsidian Shard", 8, 1, 1));
        drops.add(new Drops(82, "Ruby", 5, 1, 1));
        drops.add(new Drops(83, "Sapphire", 5, 1, 1));
        drops.add(new Drops(84, "Emerald", 5, 1, 1));
        drops.add(new Drops(85, "Diamond", 2, 1, 1));
        drops.add(new Drops(86, "Topaz", 8, 1, 1));
        drops.add(new Drops(87, "Quartz Crystal", 12, 1, 1));
        drops.add(new Drops(88, "Peridot", 10, 1, 1));
        drops.add(new Drops(89, "Opal", 7, 1, 1));
        drops.add(new Drops(90, "Amber", 15, 1, 1));
        drops.add(new Drops(91, "Jade Figurine", 10, 1, 1));
        drops.add(new Drops(92, "Crystal Ball", 5, 1, 1));
        drops.add(new Drops(93, "Parchment Scroll", 20, 1, 1));
        drops.add(new Drops(94, "Empty Flask", 25, 1, 1));
        drops.add(new Drops(95, "Oil Flask", 20, 1, 1));
        drops.add(new Drops(96, "Enchanted Candle", 15, 1, 1));
        drops.add(new Drops(97, "Magic Dust", 10, 1, 1));
        drops.add(new Drops(98, "Enchanted Gemstone", 5, 1, 1));
        drops.add(new Drops(99, "Magical Amulet", 3, 1, 1));
        drops.add(new Drops(100, "Magical Ring", 3, 1, 1));
        drops.add(new Drops(101, "Enchanted Robe", 7, 1, 1));
        drops.add(new Drops(102, "Magical Staff", 5, 1, 1));
        drops.add(new Drops(103, "Crystal Wand", 8, 1, 1));
        drops.add(new Drops(104, "Enchanted Dagger", 10, 1, 1));
        drops.add(new Drops(105, "Magic Bow", 5, 1, 1));
        drops.add(new Drops(106, "Magical Arrows", 8, 1, 1));
        drops.add(new Drops(107, "Spell Book", 12, 1, 1));

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

        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("| %-8s | %-30s | %-12s | %-8s | %-8s |\n",
                "Drop ID", "Item Name", "Drop Chance", "Min Drop", "Max Drop");
        System.out.println("---------------------------------------------------------------------------------");

        while (resultSet.next()) {
            int dropId = resultSet.getInt("drop_Id");
            String itemName = resultSet.getString("item_Name");
            int dropChance = resultSet.getInt("drop_Chance");
            int minDrop = resultSet.getInt("min_Drop");
            int maxDrop = resultSet.getInt("max_Drop");

            System.out.printf("| %8d | %-30s | %12d%% | %8d | %8d |\n",
                    dropId, itemName, dropChance, minDrop, maxDrop);
        }

        System.out.println("---------------------------------------------------------------------------------");
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
        addDropsToDatabase(url, username, password);
        printDatabase(url, username, password);
    }

}
