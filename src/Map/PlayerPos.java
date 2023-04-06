package Map;
import Game.RandomEvents;
import Main.Main;

import java.util.stream.IntStream;

public class PlayerPos {


    public static int maxX = Main.mapSize-1;
    public static int maxY = Main.mapSize-1;
    public static int x = maxX/2;
    public static int y = maxY/2;
    public static int minX = maxX-maxX;
    public static int minY = maxY-maxY;
    public static int newX;
    public static int newY;
    public static int oldX;
    public static int oldY;
    public static int oldTile;
    public static int tileInfo;
    public static Map map;
    public static int[][] mapArrayOriginal;
    public static int[] blockedTiles = {2, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};

    public void setMap(Map map) {
        this.map = map;
        this.mapArrayOriginal = map.mapArrayOriginal;
    }

    public PlayerPos(Map map) {
        this.map = map;
    }


    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }


    public static void setX(int x) {
        if (PlayerPos.x >= maxX) {
            PlayerPos.x = maxX;
        } else if (PlayerPos.x < minX) {
            PlayerPos.x = minX;
        } else {
            PlayerPos.x += x;
        }
    }

    public static void setY(int y) {
        if (PlayerPos.y > maxY) {
            PlayerPos.y = maxY;
        } else if (PlayerPos.y < minY) {
            PlayerPos.y = minY;
        } else {
            PlayerPos.y += y;
        }
    }


    public static void move(String input) {
        char direction = input.charAt(0);

        switch (direction) {
            case 's':
                for (int row = 0; row < map.mapArrayOriginal.length; row++) {
                    for (int col = 0; col < map.mapArrayOriginal[row].length; col++) {
                        if (map.mapArrayOriginal[row][col] == 8) {
                            newY = row + 1;

                        }
                    }
                }


                if (newY > maxY-1) {
                    y = maxY-1;
                    return;
                } else if (IntStream.of(blockedTiles).anyMatch(i -> mapArrayOriginal[newY][getX()] == i)) {
                    setY(0);
                } else {
                    setY(1);
                    RandomEvents.generateEvent();
                    RandomEvents.monsterSpawnChance ++;
                    RandomEvents.chestSpawnChance ++;
                }
                break;
            case 'w':
                oldY = y;

                for (int row = 0; row < map.mapArrayOriginal.length; row++) {
                    for (int col = 0; col < map.mapArrayOriginal[row].length; col++) {
                        if (map.mapArrayOriginal[row][col] == 8) {
                            newY = row - 1;
                        }
                    }
                }

                if (newY < minY+1) {
                    y = minY+1;
                    return;
                } else if (IntStream.of(blockedTiles).anyMatch(i -> mapArrayOriginal[newY][getX()] == i)) {
                    setY(0);
                } else {
                    setY(-1);
                    RandomEvents.generateEvent();
                    RandomEvents.monsterSpawnChance ++;
                    RandomEvents.chestSpawnChance ++;
                }
                break;


            case 'a':
                for (int row = 0; row < map.mapArrayOriginal.length; row++) {
                    for (int col = 0; col < map.mapArrayOriginal[row].length; col++) {
                        if (map.mapArrayOriginal[row][col] == 8) {
                            newX = col - 1;
                        }
                    }
                }
                if (newX < minX+1) {
                    x = minX+1;
                    return;
                } else if (IntStream.of(blockedTiles).anyMatch(i -> mapArrayOriginal[getY()][newX] == i)) {
                    setX(0);
                } else {
                    setX(-1);
                    RandomEvents.generateEvent();
                    RandomEvents.monsterSpawnChance ++;
                    RandomEvents.chestSpawnChance ++;
                }
                break;
            case 'd':
                for (int row = 0; row < map.mapArrayOriginal.length; row++) {
                    for (int col = 0; col < map.mapArrayOriginal[row].length; col++) {
                        if (map.mapArrayOriginal[row][col] == 8) {
                            newX = col + 1;
                        }
                    }
                }
                if (newX > maxX-1) {
                    x = maxX-1;
                    return;
                } else if (IntStream.of(blockedTiles).anyMatch(i -> mapArrayOriginal[getY()][newX] == i)) {
                    setX(0);
                } else {
                    setX(1);
                    RandomEvents.generateEvent();
                    RandomEvents.monsterSpawnChance ++;
                    RandomEvents.chestSpawnChance ++;
                }
                break;
            default:
                System.out.println("Invalid direction: " + direction);
        }
    }
}
