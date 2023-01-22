package com.stringcodeltd.studentapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="attendance_details")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long attendanceId;
    @Column
    @JsonIgnore
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date attendanceDate;
    @Column
    @NotNull()
    private boolean isMarked;

}
