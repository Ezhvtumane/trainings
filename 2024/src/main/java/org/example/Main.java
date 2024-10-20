package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        statistics();
    }

    public static void statistics() {
        double[] patients = new double[1000001];
        int arrCount = 0;
        Double sum = 0.0;
        String[] inputLine = null;
        String input = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in),16)) {
            input = reader.readLine();
            if (input.equals("!")) {
                return;
            }

            while (!input.equals("!")) {
                inputLine = input.split(" ");
                switch (inputLine[0]) {
                    case "+":
                        double new1 = Double.parseDouble(inputLine[2]);
                        patients[Integer.parseInt(inputLine[1])] = new1;
                        sum += new1;
                        arrCount++;
                        break;
                    case "~":
                        int patNum = Integer.parseInt(inputLine[1]);
                        double new2 = Double.parseDouble(inputLine[2]);
                        sum -= patients[patNum];
                        patients[patNum] = new2;
                        sum = sum + new2;
                        break;
                    case "-":
                        int patNum1 = Integer.parseInt(inputLine[1]);
                        sum -= patients[patNum1];
                        patients[patNum1] = 0.0;
                        arrCount--;
                        break;
                    case "?":
                        System.out.printf("%.9f", sum / arrCount);
                        System.out.println();
                        break;
                }
                input = reader.readLine();
            }
        } catch (IOException e) {
            //
        }
    }
}