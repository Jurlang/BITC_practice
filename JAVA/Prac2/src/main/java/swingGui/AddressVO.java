package swingGui;

public class AddressVO {
	private String roadAddress;
	private String jibunAddress;
	private String x;
	private String y;

	public AddressVO() {
	}
	public AddressVO(String roadAddress, String jibunAddress, String x, String y) {
		this.roadAddress = roadAddress;
		this.jibunAddress = jibunAddress;
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "AddressVO{" +"roadAddress='" + roadAddress + '\'' +
				", jibunAddress='" + jibunAddress + '\'' +", x='" + x + '\'' +", y='" + y + '\'' +'}';
	}

	public String getRoadAddress() {
		return roadAddress;
	}

	public String getJibunAddress() {
		return jibunAddress;
	}

	public String getX() {
		return x;
	}

	public String getY() {
		return y;
	}
}
