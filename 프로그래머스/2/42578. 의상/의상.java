import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        // 1) 의상 종류별로 몇 개씩 있는지 세기 위한 맵
        //    key: 종류(예: "face", "outer"), value: 그 종류의 의상 개수
        Map<String, Integer> cnt = new HashMap<>();

        // clothes의 각 행은 [의상 이름, 의상 종류]
        for (String[] c : clothes) {
            // c[1] = 의상 종류
            // 해당 종류 개수를 +1 (없으면 0에서 시작)
            cnt.put(c[1], cnt.getOrDefault(c[1], 0) + 1);
        }

        // 2) 경우의 수 계산
        //    종류별로 입는 경우 + 안 입는 경우(1)를 합쳐서 곱한다.
        //    예: face가 2개면 선택지는 (2개 중 1개 착용) + (안 착용) = 3가지 => 2 + 1
        int ans = 1;

        // 종류별 의상 개수들만 순회
        for (int c : cnt.values()) {
            // 해당 종류에서 고르는 방법 수는 (c + 1)
            // 전체 조합은 종류별 선택지를 곱한 값
            ans *= (c + 1);
        }

        // 3) 문제 조건: 하루에 최소 1개는 입어야 함
        //    위에서 계산한 ans에는 모든 종류를 안 입는 경우(=아무것도 안 입음)가 1개 포함됨
        //    그 1개를 빼서 반환
        return ans - 1;
    }
}