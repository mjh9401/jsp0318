package java0307;

//문제 : 아래와 같이 출력되도록 해주세요.
//조건 : 소스코드 중복이 없어야 합니다.
//조건 : 복잡한 상속을 써도 됩니다.
public class Exam0316_2 {
	public static void main(String[] args) {
		System.out.println("== 청둥오리 ==");
		청둥오리 a청둥오리 = new 청둥오리();
		a청둥오리.날다(); // 오리가 날개로 날아갑니다.
		a청둥오리.수영하다(); // 오리가 물갈퀴로 수영합니다.
		
		System.out.println("== 흰오리 ==");
		흰오리 a흰오리 = new 흰오리();
		a흰오리.날다(); // 오리가 날개로 날아갑니다.
		a흰오리.수영하다(); // 오리가 물갈퀴로 수영합니다.
		
		System.out.println("== 고무오리 ==");
		고무오리 a고무오리 = new 고무오리();
		a고무오리.날다(); // 저는 못 날아요 ㅠㅠ
		a고무오리.수영하다(); // 오리가 물에 둥둥 떠다닙니다.
		
		System.out.println("== 고무2오리 ==");
		고무2오리 a고무2오리 = new 고무2오리();
		a고무2오리.날다(); // 저는 못 날아요 ㅠㅠ
		a고무2오리.수영하다(); // 오리가 물에 둥둥 떠다닙니다.
		
		System.out.println("== 로봇오리 ==");
		로봇오리 a로봇오리 = new 로봇오리();
		a로봇오리.날다(); // 오리가 날개로 날아갑니다.
		a로봇오리.수영하다(); // 오리가 물에 둥둥 떠다닙니다.

	}
}
class 오리 {
	void 날다() {
		System.out.println("오리가 날개로 날아갑니다.");
	}
	
	void 수영하다() {
		System.out.println("오리가 물갈퀴로 수영합니다.");
	}
}
class 흰오리 extends 오리 { }
class 청둥오리 extends 오리 { }
class 고무오리 extends 오리 {
	void 날다() {
		System.out.println("저는 못 날아요. ㅜㅠ");
	}
	
	void 수영하다() {
		System.out.println("오리가 물에 둥둥 떠다닙니다.");
	}
}
class 고무2오리 extends 고무오리 { }
class 로봇오리 extends 오리{
	void 수영하다() {
		System.out.println("오리가 물에 둥둥 떠다닙니다.");
	}
}