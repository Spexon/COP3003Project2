/**
 * @Author Vladimir Hardy
 */
package sample;


public class DisplayTable {

    private String productName;
    private String manufact;
    private String type;
    private int id;

    /**
     * @param id       ID number from the database
     * @param manufact Manufacturer from the database
     * @param name     Product name from the database
     * @param type     Product type from the database
     * @brief gathers information sent from the controller to be returned later
     */
    public DisplayTable(int id, String manufact, String name, String type) {

        this.productName = name;
        this.manufact = manufact;
        this.type = type;
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public String getManufact() {
        return manufact;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
