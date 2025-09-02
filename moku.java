package Ka; // 패키지 이름 설정
public class Everland {
	// 성인, 청소년, 유아 티켓 가격 설정
	private static final int ADULT_PRICE = 80000; // 성인 티켓 가격
	private static final int YOUTH_PRICE = 50000; // 청소년 티켓 가격
	private static final int BABY_PRICE = 20000; // 유아 티켓 가격

    // 티켓 종류 이름 설정
	private static final String ADULT_TYPE = "성인";
	private static final String YOUTH_TYPE = "청소년";
	private static final String BABY_TYPE = "유아";
	public static void main(String[] args) {
		// 전체 손님 티켓을 저장할 배열 (54300명)
		Ticket[] tArr = new Ticket[54300];
		// 각 티켓 종류별 인덱스 (몇 장 발급했는지 세기용)
		int adultIndex = 0;
		int youthIndex = 0;
		int babyIndex = 0;
        
		// 티켓 종류별로 따로 저장할 배열
		Ticket[] adultArr = new Ticket[54300]; // 성인 티켓 저장
		Ticket[] youthArr = new Ticket[54300]; // 청소년 티켓 저장
		Ticket[] babyArr = new Ticket[54300]; // 유아 티켓 저장

		// 총 매출을 저장할 변수
		double sum = 0;

		// 54300명의 손님을 한 명씩 처리
		for (int i = 0; i < 54300; i++) {
			String type = null; // 티켓 종류
			Ticket ticket = null; // 티켓 객체

			// 앞의 54000명은 성인 또는 청소년
			if (54000 > i) {
				// 3번째 손님마다 청소년 티켓 발급
				if ((i + 1) % 3 == 0) {
					sum += YOUTH_PRICE; // 청소년 티켓 가격을 매출에 더함
					type = YOUTH_TYPE; // 티켓 종류 설정
					ticket = new Ticket(i + 1, type, YOUTH_PRICE); // 티켓 생성
					youthArr[youthIndex++] = ticket; // 청소년 배열에 저장
				} else {
					sum += ADULT_PRICE; // 성인 티켓 가격을 매출에 더함
					type = ADULT_TYPE; // 티켓 종류 설정
					ticket = new Ticket(i + 1, type, ADULT_PRICE); // 티켓 생성
					adultArr[adultIndex++] = ticket; // 성인 배열에 저장
				}
			} else {
				// 마지막 300명은 유아 티켓 발급
				sum += BABY_PRICE; // 유아 티켓 가격을 매출에 더함
				type = BABY_TYPE; // 티켓 종류 설정
				ticket = new Ticket(i + 1, type, BABY_PRICE); // 티켓 생성
				babyArr[babyIndex++] = ticket; // 유아 배열에 저장
			}
			// 전체 티켓 배열에 저장
			tArr[i] = ticket;
			// 손님 입장 정보 출력
			System.out.printf("%d번째 손님 입장(%s,%.0f)", (i + 1), ticket.getType(), sum);
			System.out.println(); // 줄 바꿈
		}
		// 티켓 종류별 발급 수 출력
		System.out.println("성인 티켓 수:" + countNotNullArray(adultArr));
		System.out.println("청소년 티켓 수:" + countNotNullArray(youthArr));
		System.out.println("유아 티켓 수:" + countNotNullArray(babyArr));
	}
	// 배열에서 null이 아닌 티켓 개수를 세는 함수
	private static int countNotNullArray(Ticket[] tArr) {
		int count = 0;
		for (Ticket t : tArr) {
			if (t != null) { // 티켓이 null이 아니면
				count++; // 하나 더 셈
			}
		}
		return count; // 최종 개수 반환
	}
}



+++++++++++++++++++++++++++++++++++++



package Ka; // 같은 패키지

public class Ticket {
	private int no;         // 티켓 번호 (몇 번째 손님인지)
	private String type;    // 티켓 종류 (성인, 청소년, 유아)
	private int price;      // 티켓 가격
	// 티켓 생성자: 번호, 종류, 가격을 받아서 저장
	public Ticket(int no, String type, int price) {
		this.no = no;
		this.type = type;
		this.price = price;}
	// 티켓 번호 반환
	public int getNo() {return no;}
	// 티켓 종류 반환
	public String getType() {return type;}
	// 티켓 가격 반환
	public int getPrice() {return price;}
}









============================================================


package Ka; // 이 코드는 Ka 패키지에 속해 있음

public class Everland {
    // 티켓 가격을 상수로 정의 (변경되지 않는 값)
    private static final int ADULT_PRICE = 80000; // 성인 티켓 가격: 80,000원
    private static final int YOUTH_PRICE = 50000; // 청소년 티켓 가격: 50,000원
    private static final int BABY_PRICE = 20000; // 유아 티켓 가격: 20,000원

    // 티켓 종류를 상수로 정의
    private static final String ADULT_TYPE = "성인"; // 성인 티켓 이름
    private static final String YOUTH_TYPE = "청소년"; // 청소년 티켓 이름
    private static final String BABY_TYPE = "유아"; // 유아 티켓 이름

    public static void main(String[] args) {
        // 총 54,300명의 손님 티켓을 저장할 배열
        Ticket[] tArr = new Ticket[54300];

        // 각 티켓 종류별로 발급된 수를 추적하기 위한 변수
        int adultIndex = 0; // 성인 티켓 발급 수
        int youthIndex = 0; // 청소년 티켓 발급 수
        int babyIndex = 0; // 유아 티켓 발급 수

        // 티켓 종류별로 저장할 배열 (각각 최대 54,300장)
        Ticket[] adultArr = new Ticket[54300]; // 성인 티켓 저장용
        Ticket[] youthArr = new Ticket[54300]; // 청소년 티켓 저장용
        Ticket[] babyArr = new Ticket[54300]; // 유아 티켓 저장용

        // 총 매출을 계산할 변수
        double sum = 0;

        // 54,300명의 손님을 한 명씩 처리
        for (int i = 0; i < 54300; i++) {
            String type; // 티켓 종류를 저장할 변수
            Ticket ticket; // 티켓 객체를 저장할 변수

            // 첫 54,000명은 성인 또는 청소년 티켓 발급
            if (i < 54000) {
                // 3번째 손님마다 청소년 티켓 발급
                if ((i + 1) % 3 == 0) {
                    sum += YOUTH_PRICE; // 매출에 청소년 티켓 가격 추가
                    type = YOUTH_TYPE; // 티켓 종류: 청소년
                    ticket = new Ticket(i + 1, type, YOUTH_PRICE); // 청소년 티켓 생성
                    youthArr[youthIndex++] = ticket; // 청소년 티켓 배열에 저장
                } else {
                    sum += ADULT_PRICE; // 매출에 성인 티켓 가격 추가
                    type = ADULT_TYPE; // 티켓 종류: 성인
                    ticket = new Ticket(i + 1, type, ADULT_PRICE); // 성인 티켓 생성
                    adultArr[adultIndex++] = ticket; // 성인 티켓 배열에 저장
                }
            } else {
                // 마지막 300명은 유아 티켓 발급
                sum += BABY_PRICE; // 매출에 유아 티켓 가격 추가
                type = BABY_TYPE; // 티켓 종류: 유아
                ticket = new Ticket(i + 1, type, BABY_PRICE); // 유아 티켓 생성
                babyArr[babyIndex++] = ticket; // 유아 티켓 배열에 저장
            }

            // 전체 티켓 배열에 티켓 저장
            tArr[i] = ticket;

            // 현재 손님의 입장 정보 출력
            System.out.printf("%d번째 손님 입장(%s, %.0f원)\n", (i + 1), ticket.getType(), sum);
        }

        // 각 티켓 종류별 발급된 티켓 수 출력
        System.out.println("성인 티켓 수: " + countNotNullArray(adultArr));
        System.out.println("청소년 티켓 수: " + countNotNullArray(youthArr));
        System.out.println("유아 티켓 수: " + countNotNullArray(babyArr));
    }

    // 배열에서 null이 아닌 티켓의 개수를 세는 함수
    private static int countNotNullArray(Ticket[] tArr) {
        int count = 0; // 티켓 개수를 저장할 변수
        for (Ticket t : tArr) {
            if (t != null) { // 티켓이 존재하면
                count++; // 개수 1 증가
            }
        }

        return count; // 총 티켓 개수 반환
    }
}


// 구구단 하는데 예 3단은 빼라. 
