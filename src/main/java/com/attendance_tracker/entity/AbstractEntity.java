package com.attendance_tracker.entity;

        import org.hibernate.annotations.GenericGenerator;

        import javax.persistence.*;
        import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEntity {

    // region PROPERTIES
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false, updatable = false, columnDefinition = "CHAR(36)")
    protected String id;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    @Column(name = "deleted", columnDefinition = "boolean default false", nullable = false)
    private boolean deleted;
    // endregion

    // region LISTENERS
    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now();
    }
    // endregion

    //region GETTERS / SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}
