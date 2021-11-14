package tujia;

import java.util.*;

/**
 * @author Aidan
 * @createTime 2021/11/13 15:28
 * @GitHub github.com/huaxin0304
 * @Blog aidanblog.top
 */


public class GenerateCityTree {
    static class City {
        int ID, PID, level;
        String name;

        public City(int ID, int PID, int level, String name) {
            this.ID = ID;
            this.PID = PID;
            this.level = level;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<City> cityList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String str=scanner.nextLine();
            Scanner scannerStr = new Scanner(str);
            String[] strings = new String[4];
            for (int i = 0; i < 4; i++) {
                strings[i] = scannerStr.next();
            }
            City tempCity = new City(Integer.parseInt(strings[0]),
                    Integer.parseInt(strings[1]), Integer.parseInt(strings[2]), strings[3]);
            cityList.add(tempCity);
        }

        cityList.sort((o1, o2) -> {
            if (o1.level != o2.level) {
                return o1.level - o2.level;
            }
            return o1.ID - o2.ID;
        });

        /*for (City city : cityList) {
            System.out.println(city.getName());
        }*/

        for (City city : cityList) {
            if (city.level == 1) {
                System.out.println(city.name);
                dfs(cityList, city.level + 1, city.ID);
            }
        }

    }

    static void dfs(List<City> list, int level, int ID) {
        for (City city : list) {
            if (city.PID == ID && city.level == level) {
                outSpace(level);
                System.out.print(city.name);
                System.out.println();
                dfs(list, level + 1, city.ID);
            }
        }
        return;
    }

    static void outSpace(int level) {
        for (int i = 0; i < (level - 1) * 4; i++) {
            System.out.print(" ");

        }
    }
}
