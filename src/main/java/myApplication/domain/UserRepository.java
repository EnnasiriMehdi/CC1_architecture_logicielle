package myApplication.domain;

import java.util.UUID;

public interface UserRepository {

    void save(Tradesman tradesman);

    Tradesman byId(UserId userId);

    default UserId nextId() {
        return UserId.fromUUID(UUID.randomUUID());
    }

}
