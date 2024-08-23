package com.MuhammadDev.jpa.repositorise;

import com.MuhammadDev.jpa.models.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<Text,Integer> {
}
