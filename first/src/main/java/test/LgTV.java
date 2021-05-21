package test;

public class LgTV implements TV {
	public void powerOn() {
		System.out.println("엘지tv - 전원 켠다.");
	}
	public void powerOff() {
		System.out.println("엘지tv - 전원 끈다.");
	}
	public void soundUp() {
		System.out.println("엘지tv - 소리 줄인다.");
	}
	public void soundDown() {
		System.out.println("엘지tv - 소리 내린다."); 
	}
}
