package ogs.myInterest.ecwid;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class AddCounter {

    /*
     * Дан простой текстовый файл с IPv4 адресами. Одна строка – один адрес, примерно так:
     *
     *        145.67.23.4
     *        8.34.5.23
     *        89.54.3.124
     *        89.54.3.124
     *        3.45.71.5
     *       ...
     *
     *    Файл в размере не ограничен и может занимать десятки и сотни гигабайт.
     *
     *  Необходимо посчитать количество уникальных адресов в этом файле,
     *  затратив как можно меньше памяти и времени.
     *
     *  Существует "наивный" алгоритм решения данной задачи (читаем строка за строкой, кладем строки в HashSet),
     *  желательно чтобы ваша реализация была лучше этого простого, наивного алгоритма.
     */

    /*
     *  BitSet:
     *    result: 1999555
     *    time: 564 ms
     *  HashSet<String>
     *    result: 1999555
     *    time: 581 ms
     */

    public static void main(String[] args) {
        final Path path = Paths.get("src/resources/test");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            final long start = Instant.now().toEpochMilli();
            naiveString(reader);
            final long finish = Instant.now().toEpochMilli();
            System.out.println("time: " + (finish - start) + " ms");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static int convertIpStringToInt(String ip) {
        try {
            return ByteBuffer.allocate(Integer.BYTES)
                .put(InetAddress.getByName(ip).getAddress())
                .rewind()
                .getInt();
        } catch (UnknownHostException unknownHostException) {
            throw new RuntimeException(unknownHostException);
        }
    }

    private static void naiveString(BufferedReader reader) {
        final Set<String> uniqIps = new HashSet<>();
        reader.lines().forEach(uniqIps::add);
        System.out.println("result: " + (uniqIps.size()));
    }

    private static void bitSet(BufferedReader reader) {
        final BitSet positiveSet = new BitSet(Integer.MAX_VALUE);
        final BitSet negativeSet = new BitSet(Integer.MAX_VALUE);
        reader.lines().forEach(line -> {
            int address = convertIpStringToInt(line);
            if (address >= 0) {
                positiveSet.set(address);
            } else {
                negativeSet.set(-address);
            }
        });
        System.out.println("result: " + (positiveSet.cardinality() + negativeSet.cardinality()));
    }
}
