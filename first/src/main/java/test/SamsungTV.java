package test;

public class SamsungTV implements TV{

	public void powerOn() {
		System.out.println("삼성tv - 전원 킨다.");
	}

	public void powerOff() {
		System.out.println("삼성tv - 전원 끈다.");
		
	}

	public void soundUp() {
		System.out.println("삼성tv - 소리 올린다.");
		
	}

	public void soundDown() {
		System.out.println("삼성tv - 소리 내린다.");
		
	}
	
}
