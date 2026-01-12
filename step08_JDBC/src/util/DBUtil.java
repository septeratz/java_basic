/* 순수 DB연동 클래스 구조 - Data Access Object(DAO)
 * 공통적으로 사용하는 클래스
 * 권장사항:
 * 	table당 DAO클래스는 1:1 대응 권장
 * 	join 작업이 빈번한 구조의 경우 추가 DAO 개발 필요
 * 
 * ELK & file beat
 * 	- 로그 데이터 자동 read -> filtering -> 잭제 -> 시각화
 * 	- 로그 데이터 파이프라인 처리
 * 	- AI에게 임시 로그 데이터 구성 요청 후 활용
 * 	- 발표(github readme 필수 작업, 팀원들 함께, commit 메시지 조율)
 * 	- 스스로 자생력
 */

// trace < debug < info < warn < error < fatal

/* DB 설정 정보 별도의 파일로 분리
 * 1단계: *.properties 파일 생성(src 내부 저장)
 * 2단계: 소스 상에서 해당 파일을 자원으로 등록(file 입력)
 * 3단계: 
 */

package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBUtil {
	
	/* 멤버 변수 선언 사유
	 * - dbinfo 변수가 참조하는 실체화된 객체는 static() 로딩시 필요
	 * - getConnection() 메소드 내에서도 필요
	 * - 외부에서 호출해서 편집 불허
		dbinfo.load(new FileInputStream("dbinfo.properties"));
	 * 		1회성 실행 권장, static{}
	 */
	
	private static Properties dbinfo = new Properties();
	
	
	// driver - 1회성
	// driver 로딩 실패: client에서 언급할 이유 없다
	
	static {
		try {
			// dbinfo.properties 파일로부터 2byte단위로 read 기능의 객체 생성
			// key로 value값 착출기능의 객체 생성: java.util.Properties
			// key로 value값 착출 메소드 호출
			dbinfo.load(new FileInputStream("dbinfo.properties"));
			Class.forName(dbinfo.getProperty("jdbc.driver"));
			log.info("driver 로딩");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 관리자에게 문제의 모든 정보 출력
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // 관리자에게 문제의 모든 정보 출력
		} catch (IOException e) {
			e.printStackTrace(); // 관리자에게 문제의 모든 정보 출력
		}
	}
	
	// Connection 객체 생성해서 반환
	/* Client 요청별 개별 Connection 생성해서 반환
	 * 단, db 접속 관련 정보는 공통 또는 properties로 분리 권장
	 * Connection 객체 생성 및 반환 로직은 DAO들의 공통
	 * 
	 * 예외 발생시 client가 알아야 하는가?
	 * 서버단 문제라면 유연하게 "잠시후 재실행" 유도
	 * 접속에 대한 예외는 반드시 client 처리 기능의 메소드들이 공유 
	 * 
	 * 웹 로직
	 * client -> view(HTML, JSP) -> controller -> Model(biz, core(핵심)) -> DB
	 *  접속 예외 발생시
	 *  DB  -> Model(예외 생성, controller에 처리 위임. throws)
	 *  		-> Controller (예외처리 View 지정, try-catch)
	 *  		-> View (예외처리View, 재실행 시도 유도) ...
	 *  
	 * 개발 -> test -> 서버에 배포를 위한 jar화(build) -> 서버에 배포
	 * 갱신시 
	 * 	소스 편집 -> 컴파일 -> test -> 서버에 배포를 위한...
	 * 	설정만 편집 -> test -> 서버에 배포를 위한...
	 */
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbinfo.getProperty("jdbc.url"),
				dbinfo.getProperty("jdbc.id"),
				dbinfo.getProperty("jdbc.pw"));
	}
	
	// 자원반환 - close 
	// Spring Boot는 자동 생성된 추상화 코드들이 다 해줌
	// Spring Framework는 코드로 제어
	// JDBC는 개발자 필수
	// JPA는 개발자 필수
	// python에서 DB연동시 close 필수
	
	// DML - insert/update/delete
	/* 필요 자바 객체
	 *  Connection / Statement
	 */
	// 자원 반환: 에외 발성 가능성, 즉 예외 생성시 client에게 자원반환 실패 언급 필요 없음
	public static void close(Connection con, Statement stmt) {
		try {
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
	// DQL - select
	/* 필요 자바 객체
	 *  Connection / Statement / ResultSet
	 */
	public static void close(Connection con, Statement stmt, ResultSet rs) {
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
}
