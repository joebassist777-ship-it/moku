package lol;

public class Champion {

	// 챔피언 이름과 역할을 저장하는 필드 (protected: 자식 클래스에서 접근 가능)
	protected String name; // 이름
	protected String role; // 역할

	// 생성자: 챔피언 객체가 생성될 때 이름과 역할을 초기화
	public Champion(String name, String role) {
		this.name = name;
		this.role = role;
	}

	public void skillQ() {
		System.out.println("기본 Q 스킬");
	}

	public void skillW() {
		System.out.println("기본 W 스킬");
	}

	public void skillP() {
		System.out.println("기본 패시브 스킬");
	}

	// 챔피언 정보 출력 메서드: 이름과 역할을 콘솔에 출력
	public void info() {
		System.out.println("챔피언: " + name + " / 역할: " + role);
	}
}


==========================================

  package lol;

//프로그램 실행하는 클래스
public class Main {
	public static void main(String[] args) {
		// Champion 타입 배열에 여러 챔피언을 담음
		// 다형성: 부모 타입으로 자식 객체를 다룰 수 있음
		Champion[] champs = { new Ashe(), new Garen(), new Ahri(), new Sinzid() };

		// 배열에 있는 챔피언들 차례대로 불러서 정보와 스킬 실행
		for (Champion champ : champs) {
			champ.info(); // 챔피언 기본 정보 출력
			champ.skillQ(); // Q 스킬 실행
			champ.skillW(); // W 스킬 실행
			champ.skillP(); // 페시브 스킬

			System.out.println("----------------");
		}
	}
}

=========================================

  package lol;

//탱커 챔피언 - 가렌
class Garen extends Champion {
	public Garen() {
		super("가렌", "탱커/전사");
	}

	@Override
	public void skillQ() {
		System.out.println("가렌 Q - 결정타!");
	}

	@Override
	public void skillW() {
		System.out.println("가렌 W - 용기!");
	}

	@Override
	public void skillP() {
		System.out.println("가렌 패시브 - 데마시아 용기 :체력 회복");
	}
}

==============================================

  package lol;

class Sinzid extends Champion {
	public Sinzid() {
		super("신지드", "딜러/전사");
	}

	@Override
	public void skillQ() {
		System.out.println("신지드 Q - 독뿌리기");
	}

	@Override
	public void skillW() {
		System.out.println("신지드 W - 접착제 뿌리기");
	}

	@Override
	public void skillP() {
		System.out.println("신지드 패시브 - 방패막기: 마나가 높아 질수록 체력도 높아진다.");
	}
}
