@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    private final DelayScoreRecordRepository repository;

    public DelayScoreServiceImpl(DelayScoreRecordRepository repository) {
        this.repository = repository;
    }

    public List<DelayScoreRecord> getAll() {
        return repository.findAll();
    }

    public Optional<DelayScoreRecord> getById(Long id) {
        return repository.findById(id);
    }

    public DelayScoreRecord save(DelayScoreRecord record) {
        return repository.save(record);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
