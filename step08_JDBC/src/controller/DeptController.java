package controller;

import java.sql.SQLException;

import model.domain.DeptDTO;
import model.service.DeptService;
import view.DeptFailView;
import view.DeptSuccessView;


public class DeptController {
	// 모든 요청 받고 요청 구분 후 출력 view 지정
	/* 출력 view 지정 시
	 * - 정상: 정상 view 실행 위임
	 * - 비정상: 예외 발생시 예외처리 view 실행 위임
	 * 
	 * Dept table:
	 * 	deptno: 부서 번호는 절대 중복 불가, 정수여야만 함, null 불허
	 * 	dname: 부서명, 문자열, null 허용을 불허로 재편집(schema 문서 자체) 
	 * 	loc: 지역, 문자열, null 허용
	 * 
	 */
	
	private DeptService service = new DeptService();
	// 1. 모든 부서 검색
    public void getAllDepts() {
        try {
            DeptSuccessView.allDeptView(service.getAllDepts());
        } catch (SQLException e) {
            DeptFailView.printMsg("모든 부서 검색 재 시도 요망");
            e.printStackTrace();
        }
    }

    // 2. 부서 추가 (데이터를 파라미터로 받음)
    public void insertDept(DeptDTO newDept) {
        try {
            if (service.registerDept(newDept)) {
                DeptSuccessView.successView(newDept.getDeptno() + "번 부서 입력 성공");
            } else {
                DeptFailView.printMsg("부서 입력 실패");
            }
        } catch (Exception e) {
            DeptFailView.printMsg(e.getMessage());
            e.printStackTrace();
        }
    }

    // 3. 부서 수정
    public void updateDept(int deptno, String loc) {
        try {
            if (service.modifyDeptLoc(deptno, loc)) {
                DeptSuccessView.successView(deptno + "번 부서 수정 성공");
            } else {
                DeptSuccessView.successView("존재하지 않는 부서입니다.");
            }
        } catch (Exception e) {
            DeptFailView.printMsg(e.getMessage());
            e.printStackTrace();
        }
    }
	
}
