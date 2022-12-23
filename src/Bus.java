public class Bus extends Transport{
    public Bus() {
        super("", "", 0, "", "", 0);
    }
    public Bus(String brand, String model, int productionYear, String productionCountry, String bodyColor,
               int maximumSpeed) {
        super(brand, model, productionYear, productionCountry, bodyColor, maximumSpeed);
    }

    @Override
    public String toString() {
        return "Марка: " + getBrand() + "\nМодель: " + getModel() + "\nгод выпуска: " +
                getproductionYear() + "\nПроизводитель: " + getproductionCountry() + "\nЦвет кузова: "
                + getcolor() + "\nМаксимальная скорость: " + getMaxSpeed() + "км/ч\n";
    }

}
