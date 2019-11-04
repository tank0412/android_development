
abstract class MoneyConverter {

    private double money;

    public abstract void convertToRubli();

    public double getMoney() {
        return this.money;
    }
    MoneyConverter(double money) {
        this.money = money;
    }
}

class RubleToEuro extends MoneyConverter {

    RubleToEuro(double money) {
        super(money);
    }

    public void convertToRubli() {
        double convert = getMoney() / 70;
        System.out.println("Euro to ruble:" + convert);
    }
}

class RubleToDollar extends MoneyConverter {

    RubleToDollar(double money) {
        super(money);
    }

    public void convertToRubli() {
        double convert = getMoney() / 60;
        System.out.println("Dollar to ruble:" + convert);
    }
}

class RubleToUan extends MoneyConverter {

    RubleToUan(double money) {
        super(money);
    }

    public void convertToRubli() {
        double convert = getMoney() * 0.11;
        System.out.println("Uan to ruble:" + convert);
    }
}

public class TaskTen {
    public void doJob() {
        RubleToEuro rubleToEuro = new RubleToEuro(100);
        rubleToEuro.convertToRubli();
        RubleToDollar rubleToDollar = new RubleToDollar(100);
        rubleToDollar.convertToRubli();
        RubleToUan rubleToUan = new RubleToUan(100);
        rubleToUan.convertToRubli();
    }
}
