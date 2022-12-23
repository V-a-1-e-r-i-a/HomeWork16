import java.time.LocalDate;
public class Main {
    private static final int CURRENT_MONTH = LocalDate.now().getMonthValue();
    public static void main(String[] args) {
        Car ladaGranta =new Car("Lada", "Granta", 2015, "Россия",
                "Желтый", 180, 1.7, "Mеханика", "Седан",
                "Н988Н193", 5, true, new Car.Key());
        Car audiA8 = new Car("Audi", "A8 50L TDI quattro", 2020,
                "Германия", "Черный", 250, 3.0, "Aвтомат",
                "Седан", "Н989Н193", 4,
                true, new Car.Key(true, true));
        Car bmwZ8 = new Car("BMW", "Z8", 2021, "Германия",
                "Черный", 240, 3.0, "Mеханика", "Кабриолет",
                "Н990Н193", 2, false, new Car.Key());
        Car kiaSportage = new Car("Kia", "Sportage 4th generation", 2018,
                "Южная Корея", "Красный", 225, 2.4,
                "Aвтомат", "Кроссовер", "Н991Н193", 5,
                true, new Car.Key(true, true));
        Car hyundaiAvante = new Car("Hyundai", "Avante", 2016,
                "Южная Корея", "Оранжевый", 196,  1.6,
                "Aвтомат", "Седан", "Н993Н193", 5,
                true, new Car.Key());

        System.out.println(ladaGranta);
        System.out.println(audiA8);
        System.out.println(bmwZ8);
        bmwZ8.changeTyres(CURRENT_MONTH);
        System.out.println(bmwZ8);
        System.out.println(kiaSportage);
        System.out.println(hyundaiAvante);
        System.out.println();

        Bus man = new Bus("Man", "Lion's Coach", 2016, "Германия",
                "Белый", 138);
        Bus mercerdes = new Bus("Mercedes-Benz", "Travego RHD 15 RHD", 2018,
                "Германия", "Синий", 150);
        Bus scania = new Bus("Scania", "Touring 6X2", 2021, "Швеция",
                "Красный", 142);

        System.out.println(man);
        System.out.println(mercerdes);
        System.out.println(scania);
    }
}