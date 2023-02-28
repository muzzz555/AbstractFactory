// Ex 1
interface HotDrink {
    void consume(); //drink
}

class Tea implements HotDrink {

    @Override
    public void consume() {
        System.out.println("Drink Tea");
    }
}

class LemonTea extends Tea {

}


class Coffee implements HotDrink {

    @Override
    public void consume() {
      System.out.println("Drink Coffee");
    }
}

class MilkTea extends Tea {

  public int milkAmount;

  @Override
  public void consume() {
    System.out.println("Drink Milk Tea");
  }
}

class MilkCoffee extends Coffee {

  public int milkAmount;

  @Override
  public void consume() {
    System.out.println("Drink Milk Coffee");
  }
}

interface HotDrinkFactory {
  Coffee prepareCoffee();
  Tea prepareTea();
}

class BlackDrinkFactory implements HotDrinkFactory {

  @Override
  public Coffee prepareCoffee() {
    return new Coffee();
  }

  @Override
  public Tea prepareTea() {
    return new Tea();
  }
}

class MilkDrinkFactory implements HotDrinkFactory {

  @Override
  public Coffee prepareCoffee() {
    MilkCoffee coffee = new MilkCoffee();
    coffee.milkAmount = 100;
    // more action
    //
    //
    return coffee;
  }

  @Override
  public Tea prepareTea() {
    MilkTea tea = new MilkTea();
    tea.milkAmount = 200;
    return null;
  }
}

class LemonDrinkFactory implements HotDrinkFactory {

  @Override
  public Coffee prepareCoffee() {
    return null;
  }

  @Override
  public Tea prepareTea() {
    return null;
  }
  
}

public class AbstractFactory {
    public static void main(String[] args) {
        HotDrinkFactory blackFactory = new BlackDrinkFactory();
        Tea tea = blackFactory.prepareTea();

        Coffee coffee = blackFactory.prepareCoffee();
        
    }
}