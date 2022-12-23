import java.util.Objects;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final int productionYear;
    private final String productionCountry;
    private String color;
    private int maxSpeed;

    public Transport(String brand, String model, int productionYear,
                     String productionCountry, String color, int maxSpeed) {
        if (brand == null || brand.isEmpty()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null || model.isEmpty()) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (productionYear <= 0) {
            this.productionYear = 2000;
        } else {
            this.productionYear = productionYear;
        }
        if (productionCountry == null || productionCountry.isEmpty()) {
            this.productionCountry = "default";
        } else {
            this.productionCountry = productionCountry;
        }
        if (color == null || color.isEmpty()) {
            this.color = "Белый";
        } else {
            this.color = color;
        }
        if (maxSpeed <= 0) {
            this.maxSpeed = 120;
        } else {
            this.maxSpeed = maxSpeed;
        }
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getproductionYear() {
        return productionYear;
    }
    public String getproductionCountry() {
        return productionCountry;
    }
    public String getcolor() {
        return color;
    }
    public void setBodyColor(String bodyColor) {
        if (bodyColor == null || bodyColor.isEmpty()) {
            this.color = "Белый";
        } else {
            this.color = bodyColor;
        }
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed < 120) {
            this.maxSpeed = 120;
        } else {
            this.maxSpeed = maxSpeed;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return productionYear == transport.productionYear && maxSpeed == transport.maxSpeed
                && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model)
                && Objects.equals(productionCountry, transport.productionCountry)
                && Objects.equals(color, transport.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, productionYear, productionCountry, color, maxSpeed);
    }
}