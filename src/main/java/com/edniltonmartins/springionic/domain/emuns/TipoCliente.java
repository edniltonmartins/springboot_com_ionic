package com.edniltonmartins.springionic.domain.emuns;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private Integer id;
	private String nome;
	
	private TipoCliente(int id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}
	
	public static TipoCliente getTipoCliente(Integer id) {
		if (id==null) {
			return null;
		}
		
		for(TipoCliente tipoCliente: TipoCliente.values()) {
			if (tipoCliente.id.equals(id)) {
				return tipoCliente;
			}
		}
		
		throw new IllegalArgumentException("Parâmetro passado inválido ou ID não existe");
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
