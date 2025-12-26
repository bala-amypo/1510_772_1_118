@Entity
public class DeliveryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long poId;
    private int deliveredQuantity;
    private LocalDate actualDeliveryDate;

    public Long getPoId() { return poId; }
    public void setPoId(Long poId) { this.poId = poId; }

    public int getDeliveredQuantity() { return deliveredQuantity; }
    public void setDeliveredQuantity(int q) { this.deliveredQuantity = q; }

    public LocalDate getActualDeliveryDate() { return actualDeliveryDate; }
    public void setActualDeliveryDate(LocalDate d) { this.actualDeliveryDate = d; }
}
