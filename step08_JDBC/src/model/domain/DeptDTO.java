/* Dept table과 매핑되는 데이터용 클래스
 * 주의사항: 구조가 동일하거나 흡사. 단, 개발시에는 목적 및 보안에 맞게 분리 필수
 * 	이유: Entity class table 구조를 직접 제어. 변수명 수정 시 table 컬럼 자동 수정
 * 	View - Controller - Model 각 레이어별 전송 데이터 클래스: DTO Class
 * 	Model에서 DB와만 밀착되어야 하는 클래스: Entity Class
 * 
 * 개발시에는 구조는 동일하나 목저이 다르기 때문에
 * client insert 값 입력 -> controller에서 DTO 구조로 받고 
 * 	-> model에서 DTO값을 Entity 값으로 복제(library 활용, 또는 직접 코딩)
 * 	-> Entity로 DB insert
 */

package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DeptDTO {
	private int deptno;
	private String dname;
	private String loc;

}
