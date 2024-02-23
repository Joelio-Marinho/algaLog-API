package com.algaworks.algalog.algalogapi.Repository;

import com.algaworks.algalog.algalogapi.Model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega,Long> {
}
