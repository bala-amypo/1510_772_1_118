@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderRecordService {

    ...

    @Override
    public PurchaseOrderRecord save(PurchaseOrderRecord po) {
        SupplierProfile supplier = supplierRepository.findById(po.getSupplierId())
                .orElseThrow(() -> new BadRequestException("Invalid supplierId"));

        if (!supplier.getActive()) {
            throw new BadRequestException("Supplier must be active");
        }
        return poRepository.save(po);
    }

    @Override
    public Optional<PurchaseOrderRecord> getById(Long id) {
        return poRepository.findById(id);
    }

    @Override
    public List<PurchaseOrderRecord> getBySupplier(Long supplierId) {
        return poRepository.findBySupplierId(supplierId);
    }

    @Override
    public List<PurchaseOrderRecord> getAll() {
        return poRepository.findAll();
    }
}
