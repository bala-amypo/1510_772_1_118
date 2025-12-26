@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    private final SupplierRiskAlertRepository repo;

    public SupplierRiskAlertServiceImpl(SupplierRiskAlertRepository repo) {
        this.repo = repo;
    }

    @Override
    public SupplierRiskAlert save(SupplierRiskAlert alert) {
        alert.setResolved(false);
        return repo.save(alert);
    }

    @Override
    public Optional<SupplierRiskAlert> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<SupplierRiskAlert> getAll() {
        return repo.findAll();
    }

    @Override
    public List<SupplierRiskAlert> getBySupplier(Long supplierId) {
        return repo.findBySupplierId(supplierId);
    }

    @Override
    public SupplierRiskAlert resolveAlert(Long id) {
        SupplierRiskAlert alert = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
        alert.setResolved(true);
        return repo.save(alert);
    }

    @Override
    public void createAlertForSupplier(Long supplierId, String level, String message) {
        SupplierRiskAlert alert = new SupplierRiskAlert();
        alert.setSupplierId(supplierId);
        alert.setAlertLevel(level);
        alert.setMessage(message);
        alert.setResolved(false);
        repo.save(alert);
    }
}
