package com.example.doctor.repository;

import com.example.doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DoctorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   
    private RowMapper<Doctor> rowMapper = new RowMapper<Doctor>() {
        @Override
        public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Doctor(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("specialization")
            );
        }
    };

    public int save(Doctor doctor) {
        String sql = "INSERT INTO doctors(name, specialization) VALUES (?, ?)";
        return jdbcTemplate.update(sql, doctor.getName(), doctor.getSpecialization());
    }

    public List<Doctor> findAll() {
        return jdbcTemplate.query("SELECT * FROM doctors", rowMapper);
    }

    public Doctor findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM doctors WHERE id = ?", rowMapper, id);
    }
}
