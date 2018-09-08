package com.softwarelabs.pontointeligente.repositories;


import java.awt.print.Pageable;
import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.softwarelabs.pontointeligente.entity.Lancamento;

@Transactional(readOnly=true)
@NamedQueries({@NamedQuery(name = "LancamentoRepository.findByFuncionarioId",
                           query = "SELECT lanc FROM lancamento lanc WHERE lanc.funcionario.id = : funcionarioId")})

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
	
	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

	Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
}
