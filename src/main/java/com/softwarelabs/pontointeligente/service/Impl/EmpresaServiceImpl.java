package com.softwarelabs.pontointeligente.service.Impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwarelabs.pontointeligente.entity.Empresa;
import com.softwarelabs.pontointeligente.repositories.EmpresaRepository;
import com.softwarelabs.pontointeligente.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
		
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj) {
		log.info("Buscando uma empresa para o CNPJ {}", cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa persitir(Empresa empresa) {
		log.info("Persistindo empresa: {}", empresa);
		return this.empresaRepository.save(empresa);
	}
	

}
