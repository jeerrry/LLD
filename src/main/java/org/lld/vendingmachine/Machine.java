package org.lld.vendingmachine;

public class Machine {
    private static Machine instance;
    private Inventory inventory;
    private final MachineState idleState;
    private final MachineState readyState;
    private final MachineState dispenseState;
    private final MachineState returnChangeState;
    private MachineState currentState;
    private Product selectedProduct;
    private double totalPayment;

    private Machine() {
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        selectedProduct = null;
        totalPayment = 0;
    }

    public static synchronized Machine getInstance() {
        if(instance == null) {
            instance = new Machine();
        }

        return instance;
    }

    public boolean isAvailable(Product product) {
        return inventory.isAvailable(product);
    }

    public void dispenseProduct(Product product) {
        inventory.updateQuantity(product, -1);
    }

    public void selectProduct(Product product) {
        selectedProduct = product;
    }

    public MachineState getIdleState() {
        return idleState;
    }

    public MachineState getReadyState() {
        return readyState;
    }

    public MachineState getDispenseState() {
        return dispenseState;
    }

    public MachineState getReturnChangeState() {
        return returnChangeState;
    }

    public MachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(MachineState currentState) {
        this.currentState = currentState;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setSelectedProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }

    void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    void addNote(Note note) {
        totalPayment += note.getValue();
    }

    void resetPayment() {
        totalPayment = 0;
    }
}
