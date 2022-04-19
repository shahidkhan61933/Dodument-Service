package com.ecom.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.document.entity.PanCardFile;
@Repository
public interface PanCardRespository extends JpaRepository<PanCardFile, String> {

}
