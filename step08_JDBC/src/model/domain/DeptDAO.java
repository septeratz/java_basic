/* 구현 단계
 * 1. driver 로딩 -> db 종류선택,ip,id,pw 로 접속 
 * 	  -> sql 작업 -> sql 문장 실행 -> 실행한 결과 활용 
 * 	  -> db 접속 해제 	
 * 2. 프로그램 관점
 * 	 driver 로딩(db driver 내장, 로딩된 driver는 DriverManager 관리)
 *   -> db 종류선택,ip,id,pw 로 접속(DrirverManager에서 정보 제공 후 해당 db의 Connection객체 받음) 
 * 	 -> sql 작업(Statement, 특정 db에 이미 접속된 상태의 sql문장 실행 객체, Connection 으로 부터 제공)
 *   -> sql 문장 실행(Statement 내부에서 DML? DDL? DQL? 메소드 보유) 
 *   -> 실행한 결과 활용 (DQL : table형식으로 검색, DML : 영향을 미친 행수 반환)
 * 	 -> db 접속 해제(검색객체 -> 문장객체 -> 접속객체 순으로 반환, close()) 
 * 3. 모든 DB연동 기능의 메소드들이 공통적으로 사용되는 코드 별도로 분리
 * 	- 재사용성 고려
 * 	- 주의사항: 의미없는 중복 실행 금지(코드와 설정 둘 다)
 * 		: DB 연동 Driver는 1회성으로 서버에 실행
 * 	- DB설정 정보를 별도 설정 파일로 분리
 * 		- java 소스사에서 1바이트단위로 read해서 사용함
 * 		- DB URL/id/pw 등의 다수 데이터가 명확히 구분되어야 함
 * 		-> key와 value 구조의 설정 권장(properties)
 */

package model.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBUtil;

public class DeptDAO {
	/* 검색된 데이터는 반드시 반환
	 * 최종 html 또는 jsp에서 client 에게 응답
	 * 
	 * 	select * from dept: 검색시 row가 동적으로 가변적
	 *  이상적인 java 객체 구조화?
	 */
	public ArrayList<DeptDTO> deptAll() throws SQLException {
        ArrayList<DeptDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM dept";

        // try ( ... ) 안에 선언된 자원은 자동으로 close 됩니다.
        try (Connection con = DBUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                list.add(new DeptDTO(rs.getInt("deptno"), 
                                     rs.getString("dname"), 
                                     rs.getString("loc")));
            }
        } 
        return list;
    }
	// insert
	/* 발생가능한 경우의 수
	 * 경우의 수1: 정상 저장(부서번호 미중복 등 모든 조건 ok)
	 * 경우의 수2: 비정상 실행
	 * 	- 실행 중지 없이 유연하게 재시도 유도
	 * 	- 예외처리로 실행 유지
	 * 		(DB 자체의 예외 -> java에선 SQLException이 일괄 처리)
	 * 
	 * MyBatis & JPA(String data JPA) framework에서 실제 사용하는 API
	 * - SQL 문장 실행 시 value값은 동적 데이터
	 * - 데이터 부분은 모르쇠 표시, 단 실제 실행 직전에 값 대입
	 * - 사전에 문장 구성, 단 데이터는 추후에: PreparedStatement 
	 * 
	 * PreparedStatement API
	 * - DB가 SQL 문장 받음 -> 문법 검증 -> DB가 인식가능한 언어로 변환(컴파일)
	 * 		-> 실행 -> 실행결과 받음
	 * -	 두번째 요청 시 이미 실행했던 SQL 문장 검증 후 바로 실행
	 * - 보안적으로도 Statement보다 좋음(SQLInjection 방어)
	 * 
	 * - Statement API 매 실행시 SQL 실행 문장 프로세스
	 * 	DB가 SQL 문장 받음 -> 문법 검증 -> DB가 인식가능한 언어로 변환(컴파일)
	 * 		-> 실행 -> 실행결과 받음
	 * 	두번째 요청시에도 동일함
	 */
	
	// DTO를 통째로 받는 것이 확장성에 더 좋습니다.
    public boolean insertDept(DeptDTO dto) throws SQLException {
        String sql = "INSERT INTO dept VALUES (?, ?, ?)";
        
        try (Connection con = DBUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setInt(1, dto.getDeptno());
            pstmt.setString(2, dto.getDname());
            pstmt.setString(3, dto.getLoc());
            
            return pstmt.executeUpdate() == 1;
        }
    }
	/* 다형성
	 * - 상속 관계에서만 적용
	 * - 상위타입 변수 = 자손타입 객체
	 * - 예외 클래스 간에도 다형성 적용 가능
	 * 	java.lang.Object : 모든 class의 최상위 root(python, javascript 동일)
	 * 예외 클래스 상위 클래스: java.lang.Exception 클래스
	 * 예외 처리시 Exception 타입 선언 시 모든 예외 다 수용 가능	
	 * 
	 * 특정 부서 번호로 지역 수정시 발생 가능한 경우의 수
	 * 1. 정상 실행
	 * 		- 존재하는 부서로 수정 성공
	 * 		- 예외 아니지만 실행 불가: 미존재 부서 번호로 지역 수정 시도
	 * 2. 비정상 실행
	 * 		- 예외 발생
	 * 존재하지 않는 부서 수정 시도 시 실행은 되는데 아무 일도 안 일어남
	 */
	
    public boolean updateDept(int deptno, String newLoc) throws SQLException {
        String sql = "UPDATE dept SET loc=? WHERE deptno=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
           pstmt.setString(1, newLoc);
           pstmt.setInt(2, deptno);
           return pstmt.executeUpdate() == 1;
        }
   }
}