import java.util.Objects;

public class Car extends Transport {
    private double engineVolume;
    private String gearbox;
    private final String bodyType;
    private String registrationPlateNumber;
    private final int seatQuantity;
    private boolean winterTyres;
    private final Key key;

    public Car() {
        super("", "", 0, "", "", 0);
        engineVolume = 1.5;
        gearbox = "Aвтомат";
        bodyType = "Седан";
        registrationPlateNumber = "X000XX000";
        seatQuantity = 5;
        winterTyres = false;
        key = new Key();
    }

    public Car(String brand, String model, int productionYear, String productionCountry,
               String color, int maxSpeed, double engineVolume, String gearbox, String bodyType,
               String registrationPlateNumber, int seatQuantity, boolean winterTyres, Key key) {
        super(brand, model, productionYear, productionCountry, color, maxSpeed);
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
        if (gearbox == null || gearbox.isEmpty()) {
            this.gearbox = "Автомат";
        } else {
            this.gearbox = gearbox;
        }
        if (bodyType == null || bodyType.isEmpty()) {
            this.bodyType = "Седан";
        } else {
            this.bodyType = bodyType;
        }
        if (registrationPlateNumber == null || registrationPlateNumber.isEmpty()) {
            this.registrationPlateNumber = "X000XX000";
        } else {
            this.registrationPlateNumber = registrationPlateNumber;
        }
        if (seatQuantity < 2 || seatQuantity > 9) {
            throw new IndexOutOfBoundsException("Мест должно быть от 2 до 9, включая водителя");
        } else {
            this.seatQuantity = seatQuantity;
        }
        this.winterTyres = winterTyres;
        this.key = new Key(key.remoteStartEngine, key.keylessAccess);
    }
    public double getEngineVolume() {
        return engineVolume;
    }

    public String getGearbox() {
        return gearbox;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegistrationPlateNumber() {
        return registrationPlateNumber;
    }

    public int getSeatQuantity() {
        return seatQuantity;
    }

    public boolean isWinterTyres() {
        return winterTyres;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }
    public void setGearbox(String gearbox) {
        if (gearbox == null || gearbox.isEmpty()) {
            this.gearbox = "Aвтомат";
        } else {
            this.gearbox = gearbox;
        }
        if (gearbox != null && !gearbox.equals("Aвтомат") && !gearbox.equals("Mеханика")) {
            System.out.println("Некорректная коробка");
        }
    }
    public void setRegistrationPlateNumber(String registrationPlateNumber) {
        if (registrationPlateNumber == null || registrationPlateNumber.isEmpty()) {
            this.registrationPlateNumber = "X000XX000";
        } else {
            this.registrationPlateNumber = registrationPlateNumber;
        }
    }
    public void setWinterTyres(boolean winterTyres) {
        this.winterTyres = winterTyres;
    }

    public Key getKey() {
        return key;
    }
    public static class Key {
        private final boolean remoteStartEngine;
        private final boolean keylessAccess;

        public Key(boolean remoteStartEngine, boolean keylessAccess) {
            this.remoteStartEngine = remoteStartEngine;
            this.keylessAccess = keylessAccess;
        }

        public Key() {
            this(false, false);
        }

        public boolean isRemoteStartEngine() {
            return remoteStartEngine;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }

    @Override
    public String toString() {
        return "Марка: " + getBrand() +  "\nМодель: " + getModel() + "\nГод производства: "
                + getproductionYear() + "\nСтрана сборки: " + getproductionCountry() + "\nЦвет кузова: "
                + getcolor() + String.format("\nОбъем двигателя - %.1f l." , engineVolume)
                + "\nКоробка передач: " + gearbox + "\nТип кузова: " + bodyType
                + "\nРегистрационный номер: " + registrationPlateNumber + "\nКоличество мест: "
                + seatQuantity +  (isWinterTyres() ? "\nЗимняя" : "\nЛетняя") + " резина"
                + (getKey().isKeylessAccess() ? "\nдоступ без ключа: " : "\nдоступ с ключа: ")
                + (getKey().isRemoteStartEngine() ? "Удаленный запуск двигателя.\n" : "классический запуск двигателя.\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 && seatQuantity == car.seatQuantity
                && winterTyres == car.winterTyres && Objects.equals(gearbox, car.gearbox)
                && Objects.equals(bodyType, car.bodyType) && Objects.equals(registrationPlateNumber,
                car.registrationPlateNumber) && Objects.equals(key, car.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineVolume, gearbox, bodyType, registrationPlateNumber,
                seatQuantity, winterTyres, key);
    }
    public void changeTyres(int currentMonth) {
        this.winterTyres = currentMonth >= 11 || currentMonth <= 4;
    }

    public boolean isCorrectRegistrationPlateNumber() {
        if (registrationPlateNumber.length() != 9) {
            return false;
        }
        char[] chars = registrationPlateNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) ||
                !Character.isAlphabetic(chars[5])) {
            return false;
        }
        return Character.isDigit(chars[1]) && Character.isDigit(chars[2]) && Character.isDigit(chars[3])
                && Character.isDigit(chars[6]) && Character.isDigit(chars[7])
                && Character.isDigit(chars[8]);
    }
}
