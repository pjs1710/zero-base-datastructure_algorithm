package dev.programmers.first_week;

import java.io.*;
import java.util.*;

/**
 * 5주차 선택 과제 2번 :
 *
 * 컴퓨터에 여러가지 파일이 있다. 파일의 종류는 다음과 같다.
 * - music (확장자 : mp3, aac, flac)
 * - image (확장자 : jpg, bmp, gif)
 * - movie (확장자 : mp4, avi, mkv)
 * - other (위와 다른 확장자들, 예 : 7z, txt, zip)
 * 문자열로 예시 입력처럼 당신의 컴퓨터에 있는 파일명과 용량이 입력된다고 했을때 각 종류별로 용량을 계산하여 출력하라. 출력의 순서는 music > image > movie > other 순서이다.
 * 입력은 문자열 배열 strings이고, 각 문자열에는 파일명과 용량이 기록되어 있다.
 * 용량의 단위는 'b'이며, 파일명과 용량은 공백 ' '으로 구분한다.
 *
 * strings = "mv.song.mp3 11b", "greatSong.flac 1000b", "not3.txt 5b", "video.mp4 200b", "game.exe 100b", "mov1e.mkv 10000b"
 *          music                music                  other           movie              other            movie
 *          music 1011, image 0, movie 10200, other 105
 *
 * 반환값 -> 1011, 0, 10200, 105
 */
public class SelectiveTask2 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] file = br.readLine().split(", ");
        int[] result = solution(file);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] strings) {
        int musicSum = 0, imageSum = 0, movieSum = 0, otherSum = 0;

        for (String item : strings) {
            String[] data = item.split(" ");
            String[] s = data[0].split("\\.");
            int capacity = Integer.parseInt(data[1].replace("b", ""));
            String e = s[s.length - 1];

            if (e.equals("mp3") || e.equals("aac") || e.equals("flac")) { // music 확장자인 경우
                musicSum += capacity;
            } else if (e.equals("jpg") || e.equals("bmp") || e.equals("gif")) { // image 확장자인 경우
                imageSum += capacity;
            } else if (e.equals("mp4") || e.equals("avi") || e.equals("mkv")) { // movie 확장자인 경우
                movieSum += capacity;
            } else { // 다른 확장자
                otherSum += capacity;
            }
        }

        return new int[]{musicSum, imageSum, movieSum, otherSum};
    }
}
