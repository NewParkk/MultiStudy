package step01;


//Class가 아닌 enum 타입
public enum Color {
	RED("c01");
	/* public static final RED = new RED;
	 * 
	 */
	
	private String colorCode;
	Color(String colorCode) {
		this.colorCode = colorCode;
	}
	public String getColorcode() {
		return colorCode;
	}
	
}
