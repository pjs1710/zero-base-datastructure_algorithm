package dev.challenge.algorithm.task;

public class Example {

    public static String checkNumbers(int[] answer, int[] input) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (input[i] == answer[i]) {
                strike++;
            } else if (input[i] == answer[0] || input[i] == answer[1] || input[i] == answer[2]) {
                ball++;
            }
        }

        return strike + "스트라이크 " + ball + "볼";
    }

    public static void main(String[] args) {
        int[] answer = {4, 2, 7};
        int[] input = {1, 2, 3};
        System.out.println(checkNumbers(answer, input));
    }
}
