package az.iamusayev.spring.listener.entity;

import org.springframework.context.ApplicationEvent;

public class EntityEvent extends ApplicationEvent {
    private final AccessType accessType;

    public EntityEvent(Object entity, AccessType accessType) {
        super(entity);
        this.accessType = accessType;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    @Override
    public String toString() {
        return "EntityEvent{" +
                "accessType=" + accessType +
                '}';
    }
}