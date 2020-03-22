package com.ApiProInfra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ApiProInfra.dto.ChamadoDTO;
import com.ApiProInfra.models.Chamado;
import com.ApiProInfra.service.ChamadoService;


@RestController
@RequestMapping(value="/api/chamados")
public class ChamadoController {
	
	@Autowired
	private ChamadoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Chamado> find(@PathVariable Integer id) {
		Chamado obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<ChamadoDTO>> findPage(
			@RequestParam(value="nome", defaultValue="") String nome, 
			@RequestParam(value="categorias", defaultValue="") String categorias, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
//		String nomeDecoded = URL.decodeParam(nome);
	
		String nomeDecoded = null;
		List<Integer> ids = new ArrayList();

		Page<Chamado> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<ChamadoDTO> listDto = list.map(obj -> new ChamadoDTO());  
		return ResponseEntity.ok().body(listDto);
	}

}