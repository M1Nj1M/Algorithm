import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {

        // 1) 각 귤 크기가 몇 개 있는지 세기 위한 Map
        //    key = 귤 크기, value = 그 크기의 개수(빈도)
        Map<Integer, Integer> cnt = new HashMap<>();

        // tangerine 배열을 돌면서 크기별 개수를 누적
        for (int x : tangerine) {
            // x 크기가 이미 있으면 기존 값 +1, 없으면 0에서 시작해서 +1
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }

        // 2) 크기별 개수들만 뽑아서 리스트로 만들기
        //    예: {1=1, 2=2, 3=2, 5=2} -> freqs = [1,2,2,2]
        List<Integer> freqs = new ArrayList<>(cnt.values());

        // 3) 개수가 많은 크기부터 담는 게 종류 수 최소가 됨
        //    그래서 빈도(개수)를 내림차순 정렬
        freqs.sort(Collections.reverseOrder()); // 큰 개수부터

        // 4) 큰 묶음부터 k개를 채워나가며 사용한 종류 수를 세기
        int types = 0;

        for (int f : freqs) {
            // f = 어떤 크기의 귤이 몇 개 있는지(빈도)
            // 그 크기의 귤을 전부 담는다고 생각하고 k에서 빼기
            k -= f;

            // 이 크기 1종류를 사용했으니 종류 수 +1
            types++;

            // k개 이상 채웠으면(=k가 0 이하가 됐으면) 끝
            if (k <= 0) break;
        }

        // 5) k개를 담기 위해 필요한 최소 "서로 다른 크기 종류 수" 반환
        return types;
    }
}