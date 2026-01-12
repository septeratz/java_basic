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

package step01.basic;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest1 {
	/* 24시간 365일 내내 실행되는 서버 내부의 서비스 로직
	 * 고려사항: 가급적 공통 실행 로직은 1번으로 끝내는 것을 절대 권장
	 * 개발자 및 유지 보수 관점
	 * - 중복 코드 최소화
	 * - 변수가 있을 수 있는 변수, 즉 DB IP,PW 등은 가변적이고 실제 자바 소스가 아니기 때문에
	 *		수정시 소스 자체 수정 없이 설정 파일로 분리 필요
	 * 
	 */
	// oracle db의 dept 모든 데이터 검색 & 출력
	static void oracleDB() {
		// 명시적으로 설정한 class의 byte code를 메모리 로딩
		// 경우의 수 : 정상, 비정상(오타 및 미존재..)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver 로딩 성공");

			/*
			 * Connection이라는 미완성 메소드가 보유된 interface를 Oracle 벤더사에서 개발자 편의를 위해 하위 클래스 개발 및 모든
			 * 메소드 재정의 실제 생성되는 객체는 Connection 을 구현한 하위 클래스의 객체
			 */
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
			System.out.println(con); // oracle.jdbc.driver.T4CConnection@1d371b2d

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from dept");
			while (rs.next()) {
				System.out.println(rs.getInt("deptno") + " " + rs.getString("dname") + " " + rs.getString("loc"));
			}
			// 자원 반환 순서 중요
			rs.close();
			stmt.close();
			con.close();

		} catch (ClassNotFoundException e) { // 문제 발생시 실행되는 블록
			e.printStackTrace();// 문제 내용 출력
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("정상 실행 유지");
	}

	// mysql db의 dept 모든 데이터 검색 & 출력
	static void mysqlDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("mysql driver 로딩 성공");

			// com.mysql.cj.jdbc.ConnectionImpl@1ab06251
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fisa", "user01", "user01");
			System.out.println(con);

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from dept");
			while (rs.next()) {
				System.out.println(rs.getInt("deptno") + " " + rs.getString("dname") + " " + rs.getString("loc"));
			}

			// 자원 반환 순서 중요
			rs.close();
			stmt.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("정상 실행 유지");
	}

	static void oracleDB2() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from dept");
			
			while (rs.next()) {
				System.out.println(rs.getInt("deptno") + " " + rs.getString("dname") + " " + rs.getString("loc"));
			}	

		} catch (ClassNotFoundException e) { // 문제 발생시 실행되는 블록
			e.printStackTrace();// 문제 내용 출력
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{//예외 발생과 무관하게 100% 실행 보장
			try {
				if(rs != null) {
					rs.close();
					rs = null;
				}
				if(stmt != null) {
					stmt.close();
					stmt = null;
				}
				if(con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("정상 실행 유지");
	}

	// mysql db의 dept 모든 데이터 검색 & 출력
	static void mysqlDB2() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("mysql driver 로딩 성공");

			// com.mysql.cj.jdbc.ConnectionImpl@6c284af
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fisa", "user01", "user01");
			System.out.println(con);

			stmt = con.createStatement();

			rs = stmt.executeQuery("select * from dept");
			while (rs.next()) {
				System.out.println(rs.getInt("deptno") + " " + rs.getString("dname") + " " + rs.getString("loc"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 반환 순서 중요
			try {
				if(rs != null) {
					rs.close();
					rs = null;
				}
				if(stmt != null) {
					stmt.close();
					stmt = null;
				}
				if(con != null) {
					con.close();
					con = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		System.out.println("정상 실행 유지");
	}


	public static void main(String[] args) {
		mysqlDB2();
		
		
		
		
		
//		oracleDB();
//		System.out.println("******");
//		mysqlDB();

//		
//		int [] i = {1, 2, 3};
//		System.out.println("test");
//		try {
//			System.out.println(i[10]);
//			System.out.println("!!!!!!!");
//			System.out.println("!!!" + "1" + "e");
//			System.out.println("!!!!!!!");
//			System.out.println("!!!!!!!");
//		}catch(ArrayIndexOutOfBoundsException e) {
//			//e.printStackTrace();
//		}
//		
//		System.out.println("???");

	}

}