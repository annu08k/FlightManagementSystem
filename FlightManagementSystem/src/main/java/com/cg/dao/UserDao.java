package com.cg.dao;

import com.cg.bean.flightUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigInteger;

public interface UserDao extends JpaRepository<flightUser, BigInteger> {


}
