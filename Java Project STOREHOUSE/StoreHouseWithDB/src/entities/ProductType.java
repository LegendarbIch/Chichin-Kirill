package entities;

public class ProductType {


    public ProductType(int productTypeId, String productTypeName) {
        ProductTypeId = productTypeId;
        ProductTypeName = productTypeName;
    }

    private int ProductTypeId;
    private String ProductTypeName;

    public int getProductTypeId() {
        return ProductTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        ProductTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return ProductTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        ProductTypeName = productTypeName;
    }
}
