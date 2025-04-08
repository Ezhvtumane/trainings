package ogs.leetcode.a07042025.containerwithwater;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    /*
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.
    * */
    public static void main(String[] args) throws Exception {
        String content = Files.readString(Path.of("C:\\Users\\georgy\\IdeaProjects\\trainings\\src\\ogs\\leetcode\\a07042025\\containerwithwater\\heights"), StandardCharsets.UTF_8);

        List<Integer> k = Arrays.stream(content.split(","))
                .map(Integer::valueOf)
                .toList();
        int[] arr = new int[k.size()];
        for (int i = 0; i < k.size(); i++) {
            arr[i] = k.get(i);
        }
        int[] z = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        //System.out.println(maxAreaByTwo(arr));
        Instant s = Instant.now();
        System.out.println(maxArea(arr));
        Instant e = Instant.now();
        System.out.println(e.toEpochMilli() - s.toEpochMilli());
    }

    public record Point(
            int startIndex,
            int endIndex
    ) {
    }
    //fun multy-pulty
    public static int maxArea(int[] height) {
        List<Point> p = new ArrayList<>();
        int divider = height.length / (height.length < 10 ? 2 : height.length / 10);
        if (divider == 1 || divider == 0) {
            divider = 2;
        }
        int startIndex = 0;
        int endIndex = divider;
        do {
            p.add(new Point(startIndex, endIndex));
            startIndex = endIndex;
            endIndex = endIndex * 2;
            if (endIndex > height.length) {
                endIndex = height.length;
                p.add(new Point(startIndex, endIndex));
                break;
            }
        } while (endIndex < height.length);
        System.out.println("p: " + p.size());
        final List<Future<Integer>> futures = new ArrayList<>();
        int res = 0;
        try (ExecutorService ex = Executors.newFixedThreadPool((p.size() / 2) == 0 ? 1 : (p.size() / 2))) {
            for (Point point : p) {
                futures.add(ex.submit(() -> maxAreaBy(height, point.startIndex(), point.endIndex())));
            }
            for (Future<Integer> f : futures) {
                int r = f.get();
                res = Math.max(res, r);
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public static int maxAreaBy(int[] height, int startIndex, int endIndex) {
        int res = 0;
        for (int i = startIndex; i < endIndex; i++) {
            for (int j = startIndex + 1; j < height.length; j++) {
                if (i == j) {
                    continue;
                }
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }

    public static int maxAreaByTwo(int[] height) {
        Instant startT = Instant.now();

        try (ExecutorService ex = Executors.newFixedThreadPool(2)) {
            Future<Integer> submitOne = ex.submit(() -> maxArea1(height, 3));
            Future<Integer> submitTwo = ex.submit(() -> maxArea2(height, 3));

            int first = submitOne.get();
            int second = submitTwo.get();
            Instant endT = Instant.now();
            System.out.println(endT.toEpochMilli() - startT.toEpochMilli());
            return Math.max(first, second);
        } catch (InterruptedException | ExecutionException executionException) {
            return 0;
        }
    }

    public static int maxArea1(int[] height, int divider) {
        int res = 0;
        for (int i = 0; i < height.length / divider; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (i == j) {
                    continue;
                }
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }

    public static int maxArea2(int[] height, int divider) {
        int res = 0;
        for (int i = height.length / divider; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (i == j) {
                    continue;
                }
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }
}
/*
        Instant startT = Instant.now();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (i == j) {
                    continue;
                }
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        Instant endT = Instant.now();
        System.out.println((endT.toEpochMilli() - startT.toEpochMilli()));
        return res;
*/
                /*
                Instant startT = Instant.now();
                Instant endT = Instant.now();
        System.out.println((endT.toEpochMilli() - startT.toEpochMilli()) / 1000);
                System.out.println(
                        "startH: " + start + ", endH: " + end +
                                ", length: " + containerLength + ", height: " + containerHeight + ", w:" + water);
*/