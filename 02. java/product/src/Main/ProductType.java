package Main;

public enum ProductType {
    CLOTHING(1),
    APPLIANCE(2),
    FOOD(3);

    private int code;

    private ProductType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ProductType getByCode(int code) {
        for (ProductType type : ProductType.values()) {
            if (type.code == code) {
                return type;
            }
        }
        return null;
    }
}