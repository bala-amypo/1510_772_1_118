@Entity

public class SupplierProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String supplierCode;
    private boolean active = true;

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public String getSupplierCode() { return supplierCode; }
    public void setSupplierCode(String code) { this.supplierCode = code; }
}
