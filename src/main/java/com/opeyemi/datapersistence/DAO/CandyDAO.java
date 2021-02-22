package com.opeyemi.datapersistence.DAO;

import com.opeyemi.datapersistence.data.CandyData;

import java.util.List;

public interface CandyDAO {

    List<CandyData> list();
    void addToDelivery(Long candyId, Long deliveryid);
    List<CandyData> findByDelivery(Long deliveryId);
}
