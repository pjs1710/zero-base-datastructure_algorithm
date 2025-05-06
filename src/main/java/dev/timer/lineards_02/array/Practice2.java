package dev.timer.lineards_02.array;

// 배열 arr에서 target에 해당하는 값의 인덱스를 출력
// 만약 해당 값이 여러 개인 경우 가장 큰 인덱스 출력

// 입출력 예시)
// 배열 arr : 1, 1, 100, 1, 1, 1, 100
// target : 100
// 결과 : 6
public class Practice2 {

    public static void main(String[] args) {
        int targetIndex = -1, targetData = 100;
        int arr[] = {1, 1, 100, 1, 1, 1, 100};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == targetData) {
                targetIndex = i;
            }
        }

        if (targetIndex >= 0) {
            System.out.println("결과 : " + targetIndex);
        } else {
            System.out.println("해당 데이터가 없습니다.");
        }
    }
}
