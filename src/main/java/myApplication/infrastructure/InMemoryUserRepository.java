package myApplication.infrastructure;

import myApplication.domain.Tradesman;
import myApplication.domain.UserId;
import myApplication.domain.UserRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUserRepository implements UserRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<UserId, Tradesman> data = new ConcurrentHashMap<>();

    @Override
    public void save(Tradesman tradesman) {
        data.put(tradesman.getId(), tradesman);
    }

    @Override
    public Tradesman byId(UserId userId) {
        final Tradesman tradesman = data.get(userId);
        if (tradesman == null) {
            throw new RuntimeException("No user for " + userId.getValue());
        }
        return tradesman;
    }

    @Override
    public UserId nextId() {
        return UserId.of(String.valueOf(counter.incrementAndGet()));
    }
}
