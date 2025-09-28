public class SmartKitchen {
    private Refrigerator iceBox;
    private DishWasher dishWasher;
    private CoffeeMaker coffeeMaker;

    public SmartKitchen() {
        iceBox = new Refrigerator();
        dishWasher = new DishWasher();
        coffeeMaker = new CoffeeMaker();
    }

    public Refrigerator getIceBox() {
        return iceBox;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public CoffeeMaker getCoffeeMaker() {
        return coffeeMaker;
    }

    public void addWater(){
        getCoffeeMaker().setHasWorkToDo(true);
    }
    public void pourMilk(){
        getIceBox().setHasWorkToDo(true);
    }
    public void loadDishwasher(){
        getDishWasher().setHasWorkToDo(true);
    }
    public void setKitchenState(boolean coffeeMakerState, boolean iceBoxState, boolean dishWasherState){
        getCoffeeMaker().setHasWorkToDo(coffeeMakerState);
        getIceBox().setHasWorkToDo(iceBoxState);
        getDishWasher().setHasWorkToDo(dishWasherState);
    }
    public void doKitchenWork(){
        coffeeMaker.brewCoffe();
        iceBox.orderFood();
        dishWasher.doDishes();
    }
}

class CoffeeMaker{
    private boolean hasWorkToDo;

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void brewCoffe(){
        if (hasWorkToDo){
            System.out.println("Brewing coffee...");
            hasWorkToDo = false;
        }
    }
}

class Refrigerator{
    private boolean hasWorkToDo;

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void orderFood(){
        if (hasWorkToDo){
            System.out.println("Ordering food...");
            hasWorkToDo = false;
        }
    }
}

class DishWasher{
    private boolean hasWorkToDo;

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void doDishes(){
        if (hasWorkToDo){
            System.out.println("Doing dishes...");
            hasWorkToDo = false;
        }
    }
}


