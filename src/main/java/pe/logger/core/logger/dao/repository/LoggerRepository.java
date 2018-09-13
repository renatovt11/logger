package pe.logger.core.logger.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.logger.core.logger.dao.entity.LoggerEntity;

@Repository
public interface LoggerRepository extends JpaRepository<LoggerEntity, Long> {
}
