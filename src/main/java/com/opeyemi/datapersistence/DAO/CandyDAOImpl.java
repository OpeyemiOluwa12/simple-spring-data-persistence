package com.opeyemi.datapersistence.DAO;

import com.opeyemi.datapersistence.data.CandyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CandyDAOImpl implements CandyDAO {

    private static final String FIND_CANDY_DELIVERY_QUERY = "SELECT c.* FROM candy_delivery AS cd JOIN candy AS c on c.id = cd.candy_id WHERE cd.delivery_id = :deliveryId " ;
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    String GET_CANDY_DATA_QUERY = "Select * from candy";
    String INSERT_DELIVERY_QUERY = "Insert into candy_delivery(candy_id, delivery_id) Values(:candyId, :deliveryId)";

    @Override
    @Transactional
    public List<CandyData> list() {
        return jdbcTemplate.query(GET_CANDY_DATA_QUERY, new BeanPropertyRowMapper<>(CandyData.class));

    }

    @Override
    @Transactional
    public void addToDelivery(Long candyId, Long deliveryid) {

        jdbcTemplate.update(INSERT_DELIVERY_QUERY, new MapSqlParameterSource()
                .addValue("candyId", candyId)
                .addValue("deliveryId", deliveryid));

    }

    @Override
    @Transactional
    public List<CandyData> findByDelivery(Long deliveryId) {
        return jdbcTemplate.query(FIND_CANDY_DELIVERY_QUERY,
                new MapSqlParameterSource("deliveryId", deliveryId),
                new BeanPropertyRowMapper<>(CandyData.class));
    }
}
