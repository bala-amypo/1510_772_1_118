@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private final DeliveryRecordRepository repo;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeliveryRecord save(DeliveryRecord d) {
        return repo.save(d);
    }

    @Override
    public Optional<DeliveryRecord> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<DeliveryRecord> getBySupplier(Long supplierId) {
        return repo.findBySupplierId(supplierId);
    }

    @Override
    public List<DeliveryRecord> getByPurchaseOrder(Long poId) {
        return repo.findByPoId(poId);
    }

    @Override
    public List<DeliveryRecord> getAll() {
        return repo.findAll();
    }
}
