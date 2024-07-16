package com.project.tmm022_fmb.modules.hpms;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PartMasterRepository extends CrudRepository<PartMaster, Long> {

    @Query("SELECT p FROM PartMaster p")
    List<PartMaster> findPartMasterDetails();

    @Query(value = "SELECT UNIQUE GROUP_ID, GROUP_NAME FROM MES_GROUP_MASTER WHERE GROUP_STATUS = 'O' AND GROUP_SECTION = ?2 ORDER BY 1 ASC", nativeQuery = true)
    List<GroupLov> getGroupLovData(int para, String unitId);

    @Query(value = "SELECT UNIQUE SEGMENT_CODE, SEGMENT_NAME FROM MES_UNIT_MASTER ORDER BY 1 ASC", nativeQuery = true)
    List<UnitLov> getUnitLovData(int para);

    @Query(value = "SELECT UNIQUE LINE_ID, LINE_DESC FROM HPM_LINE_MASTER WHERE UNIT_ID = ?1 AND GROUP_ID = ?2 ORDER BY 1 ASC", nativeQuery = true)
    List<LineLov> getLineLovData(int para);

    @Query(value = "SELECT COUNT(*) FROM (SELECT DISTINCT LINE_ID, LINE_DESC FROM HPM_LINE_MASTER WHERE UNIT_ID = ?1 AND GROUP_ID = ?2 AND LINE_ID = ?3 AND LINE_DESC = ?4)", nativeQuery = true)
    int validateLineId(String unitId, String groupId, String lineId, String lineDesc, int para);
}
