package com.Mamoun.HRFDE.repository;

import com.Mamoun.HRFDE.model.CallLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CallLogRepository extends JpaRepository<CallLog, UUID> {
}
