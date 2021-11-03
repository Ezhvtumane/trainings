package ogs.yandexcontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class YaContest {
    public static void main(String[] args) throws IOException {
        final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        final List<Integer> data = Arrays.stream(r.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int taskNumber = data.get(0);
        int numberOfDaysForRobotReminder = data.get(1);
        int maxRemimders = data.get(2);
        final List<Integer> deadLines = Arrays.stream(r.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        final Set<Integer> deadlinesForTasks = new HashSet<>();

        for (int i = 0; i < taskNumber; i++) {
            int deadLineForTask = deadLines.get(i);
            for (int j = 0; j < maxRemimders; j++) {
                deadlinesForTasks.add(deadLineForTask + numberOfDaysForRobotReminder*j);
            }
        }

        int x3 = deadlinesForTasks.stream().sorted().collect(Collectors.toList()).get(maxRemimders-1);

        System.out.println(x3);


        /*int numberOfDrivers = Integer.parseInt(r.readLine());
        final List<Integer> ratings = new ArrayList<>();
        for (int i = 0; i < numberOfDrivers; i++) {
            ratings.add(Integer.parseInt(r.readLine()));
        }
        int minRating = ratings.stream().min(Integer::compareTo).orElse(0);
        int maxRating = ratings.stream().max(Integer::compareTo).orElse(4095);

        //int baseSum = numberOfDrivers * 500;
        int sumByRat = ratings.stream().map(rat -> rat * 500).reduce(Integer::sum).orElse(0);
        System.out.println(sumByRat);

        final HashMap<Integer, Integer> sums = new HashMap<>();

        for (int i = 0; i < numberOfDrivers; i++ ) {

        }*/


    }
/*
    static class Graph {
        private Queue<Integer> queue;
        private List<City> cities;
        private int numOfCities;
        private int[][] matrix;
        private int maxLength;
        private int firstCityNum;
        private int secondCityNum;

        private void init(BufferedReader r) throws IOException {
            queue = new PriorityQueue<>(); //Это наша очередь, хранящая номера вершин
            cities = new ArrayList<>();
            numOfCities = Integer.parseInt(r.readLine());
            for (int i = 0; i < numOfCities; i++) {
                String[] coordinates = r.readLine().split(" ");
                cities.add(new City(i, Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));

            }
            maxLength = Integer.parseInt(r.readLine());
            final String[] startAndFinishCitiesNumbers = r.readLine().split(" ");
            firstCityNum = Integer.parseInt(startAndFinishCitiesNumbers[0]) - 1;
            secondCityNum = Integer.parseInt(startAndFinishCitiesNumbers[1]) - 1;

            matrix = new int[numOfCities][numOfCities];//матрица, хранящая информацию о смежности вершин

            for (int i = 0; i < numOfCities; i++) {
                for (int j = 0; j < numOfCities; j++) {
                    if (Math.abs(cities.get(i).x - cities.get(j).x) + Math.abs(cities.get(i).y - cities.get(j).y) <= maxLength) {
                        matrix[i][j] = 1;
                    }
                }
            }
        }

        private int calculate() {
            cities.get(firstCityNum).wasVisited = true;//стартовый город номер -1
            queue.add(firstCityNum);
            int v2;

            while (!queue.isEmpty()) {
                int v = queue.remove();
                //System.out.println("v: " + v + ". far: " + cities.get(v).howFarWeWent);
                while ((v2 = getAdjUnvisitedVertex(v)) != -1) {// цикл будет работать, пока все смежные вершины не будут найденны, и не будут добавлены в очередь
                    cities.get(v2).wasVisited = true;
                    cities.get(v2).howFarWeWent = cities.get(v).howFarWeWent + 1;
                    queue.add(v2);
                    if (v2 == secondCityNum) {
                        //System.out.println("v2: " + v2  + ". far: " + cities.get(v2).howFarWeWent);
                        return cities.get(v2).howFarWeWent;
                    }
                }
            }
            return -1;
        }

        private int getAdjUnvisitedVertex(int v) {
            for (int j = 0; j < numOfCities; j++) {
                if (matrix[v][j] == 1 && cities.get(j).wasVisited == false) {
                    return j; //возвращает первую найденную вершину
                }
            }
            return -1;
        }
    }

    static class City {
        int howFarWeWent;
        boolean wasVisited;
        int number;
        int x;
        int y;

        City(int number, int x, int y) {
            howFarWeWent = 0;
            wasVisited = false;
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }


    private static int anagram_E(BufferedReader r) throws IOException {
        String str1 = r.readLine();//"aaabbbcctri";//r.readLine();
        String str2 = r.readLine();//"tiraaaccbbb";//r.readLine();

        if (str1.length() != str2.length()) {
            //System.out.println(0);
            return 0;
        }
        final Map<String, Integer> kek = new TreeMap<>();

        Arrays.stream(str1.split(""))
                .forEach(str -> {
                    Integer count = kek.get(str);
                    if (count == null) {
                        kek.put(str, 1);
                    } else {
                        kek.put(str, ++count);
                    }
                });

        Arrays.stream(str2.split("")).forEach(str -> {
                    Integer count = kek.get(str);
                    if (count != null) {
                        kek.put(str, --count);
                    }
                });
        boolean isNotAnagram = kek.entrySet().stream().anyMatch(entry -> entry.getValue() != 0);
        //System.out.println(isNotAnagram ? 0 : 1);
        //kek.forEach((s, integer) -> System.out.println(s + " " + integer));
        return isNotAnagram ? 0 : 1;
    }

    private static void delDup_C(BufferedReader r) throws IOException {
        int arrayLength = Integer.parseInt(r.readLine());
        if (arrayLength == 0) return;
        int lastI = Integer.parseInt(r.readLine());
        System.out.println(lastI);
        for (int i = 0; i < arrayLength - 1; i++) {
            int currentI = Integer.parseInt(r.readLine());
            if (lastI < currentI) {
                lastI = currentI;
                System.out.println(lastI);
            }
        }
    }

    private static int serialOnes_B(BufferedReader r) throws IOException {
        int arrayLength = 13;//Integer.valueOf(r.readLine());//
        int counter = 0;
        int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};//int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int biggestRes = 0;
        int res = 0; //=0
        boolean isNull = false;
        boolean isOne = false;
        while (counter < arrayLength) {
            int currentI = a[counter]; //Integer.valueOf(r.readLine());//
            if (currentI == 1) {
                isOne = true;
                res++;
            } else {
                isNull = true;
                if (biggestRes < res) {
                    biggestRes = res;
                }
                res = 0;
            }
            counter++;
        }
        if (isOne && !isNull) {
            System.out.println(res);
            return res;
        } else if (!isOne && isNull) {
            System.out.println(0);
            return 0;
        } else {
            if (biggestRes < res) {
                System.out.println(res);
                return res;
            } else {
                System.out.println(biggestRes);
                return biggestRes;
            }
        }
    }

    private static long jemsAndStones_A(BufferedReader r) throws IOException {
        String jems = r.readLine(); //"ab";//
        String stones = r.readLine(); //"aabbccd";//
        long i = stones.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .filter(stone -> jems.contains(stone))
                .count();
        System.out.println(i);
        return i;
    }
*/
}