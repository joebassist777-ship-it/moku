# moku

package cheklist;

public class Gest {
	Money m;
	Coffee c;
	public Gest(Money m) {
		this.m = m;
	}//손님이 돈을 꺼낸다.
	void buy(Starbucks s) {
		this.c = s.sell(m);
	}// 커피 구매한다.
	// s.sell(new Money());// 이건 부자
}


==========================

package cheklist;

public class Starbucks  {
		Coffee sell(Money m) {
			//커피를 돈을 받는다.
		if (null ==m) {
			//커피를 받기위한 가격
			return null;
		}//돈없으면 안준다.
			return new Coffee();
		}//커피를 만들어 준다
}


//손님이  스벅에 가서 돈을주고 커피를 산다.


==============================

package cheklist;
public class Money {}

=========================

package cheklist;
public class Coffee {}

==========================


