package Prac_Extends_Interface;
/*
Interface - Meter
	Method - start	택시 운행 시작한다는 메세지
			 stop	달린 거리에 해당하는 값을 매개변수로 받아 요금 반환
			 		요금 = 기본요금 + 거리 * 2
 */
public class EI_06 {
	public static void main(String[] args) {
		Taxi taxi = new Taxi();

		taxi.start();
		taxi.stop(3500);
	}
}
interface Meter{
	int BASE_FARE = 3000;
	void start();
	void stop(int distance);
}

class Taxi implements Meter{
	@Override
	public void start() {
		System.out.println("운행을 시작합니다.");
	}

	@Override
	public void stop(int distance) {
		System.out.println("운행을 종료합니다. 요금은 " + (BASE_FARE + (distance * 2)) + "원 입니다.");
	}
}