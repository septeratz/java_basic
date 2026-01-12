package view;

import controller.DeptController;
import model.domain.DeptDTO;

/* 
 * 1. insert 로직 완성
 * 2. 코드 AI 통해서 리팩토링
 * 3. 리뷰
 */

public class DeptStartView {

	public static void main(String[] args) {
		// Controller 객체 생성 (static 제거 했으므로)
        DeptController controller = new DeptController();

        System.out.println("=== 1. 모든 부서 검색 ===");
        controller.getAllDepts();

        System.out.println("\n=== 2. 부서 추가 ===");
        // 데이터는 View(사용자 입력단)에서 생성해서 넘기는 것이 맞습니다.
        DeptDTO newDept = new DeptDTO(80, "정보작전과", "구로");
        controller.insertDept(newDept);

        System.out.println("\n=== 3. 부서 수정 ===");
        controller.updateDept(70, "일산");
    }

}
