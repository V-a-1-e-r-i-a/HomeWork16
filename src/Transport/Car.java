package Transport;
import java.util.Objects;

public class Car extends Transport {
    private double engineVolume;
    private String gear;
    private final String bodyType;
    private String regNumber;
    private final int capacity;
    private boolean summerTyres;
    private Key key;

    public static class Key {
        private final boolean remoteRun;
        private final boolean withoutAccess;

        public Key(boolean remoteRun, boolean withoutAccess) {
            this.remoteRun = remoteRun;
            this.withoutAccess = withoutAccess;
        }

        public boolean isRemoteRun() {
            return remoteRun;
        }

        public boolean isWithoutAccess() {
            return withoutAccess;
        }

        @Override
        public String toString() {
            return (remoteRun ? "удалённый запуск двигателя," : "без удалённого запуска двигателя,") + " " +
                    (withoutAccess ? "бесключевой доступ" : "бесключевой доступ отсутствует");
        }
    }

    public Car(String brand,
               String model,
               double engineVolume,
               String color,
               int maxSpeed,
               int year,
               String country,
               String gear,
               String bodyType,
               String regNumber,
               int capacity,
               boolean summerTyres,
               Key key) {
        super(brand, model, year, color, country, maxSpeed);
        setEngineVolume(engineVolume);
        setGear(gear);
        if (bodyType == null || bodyType.isEmpty()) {
            bodyType = "Автомат";
        }
        this.bodyType = bodyType;
        setRegNumber(regNumber);
        if (capacity <= 0) {
            capacity = 5;
        }
        this.capacity = capacity;
        this.summerTyres = summerTyres;
        setKey(key);
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            engineVolume = 1.5;
        }
        this.engineVolume = engineVolume;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        if (gear == null || gear.isEmpty()) {
            gear = "Автомат";
        }
        this.gear = gear;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        if (regNumber == null || regNumber.isEmpty()) {
            this.regNumber = "X000XX000";
        }
        this.regNumber = regNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isSummerTyres() {
        return summerTyres;
    }

    public void setSummerTyres(boolean summerTyres) {
        this.summerTyres = summerTyres;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        if (key == null) {
            key = new Key(false, false);
        }
        this.key = key;
    }

    public void chageTyres(int month) {
        if (month >= 11 && month <= 12 || (month >= 1 && month <= 3)) {
            summerTyres = false;
        }
        if (month >= 4 && month <= 10) {
            summerTyres = true;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                " \nОбъем двигателя - " + engineVolume +
                " \nКоробка передач: " + gear +
                " \nТип кузова: " + bodyType +
                " \nРегистрационный номер: " + regNumber +
                " \nКоличество мест: " + capacity +
                (summerTyres ? "\nЗимняя" : "\nЛетняя") + " резина" + ", " +
                key;
    }
}
