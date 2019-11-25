package com.ApiProInfra.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ServicoCategoria {
	
	public class Servico {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		private String descServico;

		public String getDescServico() {
			return descServico;
		}

		public void setDescServico(String descServico) {
			this.descServico = descServico;
		}
		
	}


}
