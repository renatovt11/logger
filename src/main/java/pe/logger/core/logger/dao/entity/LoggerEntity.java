package pe.logger.core.logger.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "Log_Values")
@Entity
@Data
public class LoggerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logger_sequence")
    @SequenceGenerator(name = "logger_sequence", sequenceName = "logger_sequence", allocationSize = 1)
    private Long id;
    private String message;
    private String type;

}
