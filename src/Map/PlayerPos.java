package Map;
import Game.RandomEvents;
import Main.Main;

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
    public static int[][] mapArray;

    public void setMap(Map map) {
        this.map = map;
        this.mapArray = map.mapArray;
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
                for (int row = 0; row < map.mapArray.length; row++) {
                    for (int col = 0; col < map.mapArray[row].length; col++) {
                        if (map.mapArray[row][col] == 8) {
                            newY = row + 1;

                        }
                    }
                }


                if (newY > maxY-1) {
                    y = maxY-1;
                    return;
                } else if (mapArray[newY][getX()] == 2) {
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

                for (int row = 0; row < map.mapArray.length; row++) {
                    for (int col = 0; col < map.mapArray[row].length; col++) {
                        if (map.mapArray[row][col] == 8) {
                            newY = row - 1;
                        }
                    }
                }

                if (newY < minY+1) {
                    y = minY+1;
                    return;
                } else if (mapArray[newY][getX()] == 2) {
                    setY(0);
                } else {
                    setY(-1);
                    RandomEvents.generateEvent();
                    RandomEvents.monsterSpawnChance ++;
                    RandomEvents.chestSpawnChance ++;
                }
                break;


            case 'a':
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                for (int row = 0; row < map.mapArray.length; row++) {
                    for (int col = 0; col < map.mapArray[row].length; col++) {
                        if (map.mapArray[row][col] == 8) {
                            newX = col - 1;
                        }
                    }
                }
                if (newX < minX+1) {
                    x = minX+1;
                    return;
                } else if (mapArray[getY()][newX] == 2) {
                    setX(0);
                } else {
                    setX(-1);
                    RandomEvents.generateEvent();
                    RandomEvents.monsterSpawnChance ++;
                    RandomEvents.chestSpawnChance ++;
                }
                break;
            case 'd':
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                for (int row = 0; row < map.mapArray.length; row++) {
                    for (int col = 0; col < map.mapArray[row].length; col++) {
                        if (map.mapArray[row][col] == 8) {
                            newX = col + 1;
                        }
                    }
                }
                if (newX > maxX-1) {
                    x = maxX-1;
                    return;
                } else if (mapArray[getY()][newX] == 2) {
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
