package dev.programmers.week_13;

import java.io.*;
import java.util.*;

/**
 * '제로링'은 게임을 클리어하기 위해 반드시 클리어해야 하는 필수 보스와, 그렇지 않은 선택형 보스가 있다.
 * 선택형 보스는 반드시 클리어할 필요는 없지만, 선택형 보스를 클리어하면 공격력을 강화해 다른 보스와 전투하는 시간을 단축할 수 있다.
 * 캐릭터의 초기 공격력은 1이며, 보스를 물리칠 때마다 강화된다.
 * 각 보스를 물리쳤을 때 상승하는 공격력은 reward 배열에 주어진다.
 * 각 보스의 체력은 health 배열에 주어진다.
 * 보스를 공격하면 캐릭터의 공격력만큼 체력이 감소하며, 체력을 0이하로 만들면 보스를 물리친다.
 * 선택형 보스인지 여부는 optional 배열로 주어지며, 필수 보스인 경우 0, 선택형 보스인 경우 1로 표현된다.
 * 보스는 총 N개체가 있으며, 반드시 순서대로 물리쳐야 한다.
 * 공격 횟수 1회당 1초의 시간이 소요되며, 시간을 소요하는 다른 요소는 없다.
 *
 * 주어진 입력에 대해 최선의 선택을 하여 게임을 클리어하는 경우, 총 몇초의 시간이 소요되는지 구하시오.
 *
 * reward = 4 2 2 0 3 5
 * health = 10 20 20 20 40 30
 * optional = 1 0 1 0 0 0
 *
 * return = 26
 */

public class Num_9 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}
