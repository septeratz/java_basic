/* 학습 내용
 * 1단계: jar 실행 파일로 압축: build
 * 	fisa.jar 파일명
 * 2단계: 윈도우에서 실행 test
 * -> lombok.jar 설치 명령어: >java -jar lombok.jar
 * 	> java -jar fisa.jar
 * 3단계: linux로 이관(deploy, 배포) 및 실행
 * 	> java -jar fisa.jar
 * 
 * github에 소스 공통 업로드 -> jenkins 또는 gitactions 등으로 build/deploy
 * 실시간 소스 업데이터
 * 	*.java -> *.class(컴파일) -> *.jar(빌드) -> 서버에 배포(deploy)
 * 실시간 자동 감지: jenkins, git actions, k8s...
 * linux의 shell script 명령어 이해도가 높아야 함
 * linux sw 설치
 * 	- java 실행 설치
 * 	- mysql 직접 설치
 * 	- docker 설치 후 mysql 설치
 * 
 * window < ubuntu < jre
 * window < ubuntu < mysql
 * window < ubuntu < docker < jre(옵션)
 * window < ubuntu < docker < mysql
 */
package step01;

public class Test {

	public static void main(String[] args) {
		System.out.println(1);

	}

}
