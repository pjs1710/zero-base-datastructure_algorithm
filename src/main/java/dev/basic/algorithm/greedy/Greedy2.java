package dev.basic.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 회의실 배정
 *
 * 한 회의실에 희망하는 정보의 개수와 시작 - 종료 시간을 모두 받습니다.
 * 이 중 수용할 수 있는 최대 예약 건을 출력하세요.
 */

public class Greedy2 {

    public static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting other) { // end 기준으로 오름차순
            if (this.end == other.end) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }

        @Override
        public String toString() {
            return String.format("[%s, %s]", this.start, this.end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            int start = Integer.parseInt(data[0]);
            int end = Integer.parseInt(data[1]);
            meetings.add(new Meeting(start, end));

            System.out.println(meetings.get(i));
        }

        for (Meeting m : meetings) {
            System.out.println(m);
        }

        Collections.sort(meetings); // compareTo

        for (Meeting meeting : meetings) {
            System.out.println(meeting);
        }

        int cnt = 0;
        int lastEndTime = 0;

        for (Meeting m : meetings) {
            if (m.start >= lastEndTime) {
                cnt++;
                lastEndTime = m.end;
            }
        }
        System.out.println(cnt);
    }
}
