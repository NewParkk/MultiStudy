package step01;

public enum AreaCode {
	A01("서울특별시", "02"),
	A02("부산광역시", "051");
	
	private String areaName;
	private String areaCode;
	
	AreaCode(String areaName, String areaCode) {
		this.areaName = areaName;
		this.areaCode = areaCode;
	}
}