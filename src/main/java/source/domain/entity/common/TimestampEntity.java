package source.domain.entity.common;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class TimestampEntity {

    @Column(name = "update_date_time")
    public Timestamp updateDateTime;

    @Column(name = "create_date_time", updatable=false)
    public Timestamp createDateTime;

    @Column(name = "delete_date_time", updatable=false)
    public Timestamp deleteDateTime;

    @Column(name = "delete_flag")
    @NotNull
    private boolean deleteFlag;

    @PrePersist
    public void prePersist() {
        Timestamp ts = new Timestamp((new Date()).getTime());
        this.createDateTime = ts;
        this.updateDateTime = ts;
    }

    @PreUpdate
    public void preUpdate() {
        Timestamp ts = new Timestamp((new Date()).getTime());
        this.updateDateTime = ts;

        if (this.deleteFlag) {
            this.deleteDateTime = ts;
        }
    }
}
