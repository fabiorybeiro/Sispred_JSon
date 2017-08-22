package br.usjt.arqdesis.sispred.model;

public class Empresa {

	private int id;
	private String razaoSocial;
	private String cnpj;
	private String conjunto, horarioAbertura, horarioFechamento, tempMaxAr, ligarAr, desligarAr;

	// CONSTRUTORES
	public Empresa() {
	}

	public Empresa(int id, String razaoSocial, String cnpj, String conjunto, String horarioAbertura,
			String horarioFechamento, String tempMaxAr, String ligarAr, String desligarAr) {
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.conjunto = conjunto;
		this.horarioAbertura = horarioAbertura;
		this.horarioFechamento = horarioFechamento;
		this.tempMaxAr = tempMaxAr;
		this.ligarAr = ligarAr;
		this.desligarAr = desligarAr;

	}

	// METODOS GETs e SETs
	// get ID
	public int getId() {
		return id;
	}

	// set ID
	public void setId(int id) {
		this.id = id;
	}

	// get Razao Social
	public String getRazaoSocial() {
		return razaoSocial;
	}

	// set Razao Social
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	// get CNPJ
	public String getCnpj() {
		return cnpj;
	}

	// set CNPJ
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	// get Numero de conjuntos
	public String getConjunto() {
		return conjunto;
	}

	// set numero de conjuntos
	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}

	public String getHorarioAbertura() {
		return horarioAbertura;
	}

	public void setHorarioAbertura(String horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}

	public String getHorarioFechamento() {
		return horarioFechamento;
	}

	public void setHorarioFechamento(String horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
	}

	public String getTempMaxAr() {
		return tempMaxAr;
	}

	public void setTempMaxAr(String tempMaxAr) {
		this.tempMaxAr = tempMaxAr;
	}

	public String getLigarAr() {
		return ligarAr;
	}

	public void setLigarAr(String ligarAr) {
		this.ligarAr = ligarAr;
	}

	public String getDesligarAr() {
		return desligarAr;
	}

	public void setDesligarAr(String desligarAr) {
		this.desligarAr = desligarAr;
	}

	// metodo que retorna uma string
	@Override
	public String toString() {
		return "Razao Social [" + razaoSocial + "] CNPJ [" + cnpj + "] N de Conjutos" + conjunto + "]"
				+ "Horário de Abertura [" + horarioAbertura + "] Horário de Fechamento [" + horarioFechamento
				+ "] Temperatura Máxima do Ar [" + tempMaxAr + "] Horário para Ligar o Ar [" + ligarAr
				+ "] Horário para Desligar o Ar [" + desligarAr + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (conjunto == null) {
			if (other.conjunto != null)
				return false;
		} else if (!conjunto.equals(other.conjunto))
			return false;
		if (horarioAbertura == null) {
			if (other.horarioAbertura != null)
				return false;
		} else if (!horarioAbertura.equals(other.horarioAbertura))
			return false;
		if (horarioFechamento == null) {
			if (other.horarioFechamento != null)
				return false;
		} else if (!horarioFechamento.equals(other.horarioFechamento))
			return false;
		if (tempMaxAr == null) {
			if (other.tempMaxAr != null)
				return false;
		} else if (!tempMaxAr.equals(other.tempMaxAr))
			return false;
		if (ligarAr == null) {
			if (other.ligarAr != null)
				return false;
		} else if (!ligarAr.equals(other.ligarAr))
			return false;
		if (desligarAr == null) {
			if (other.desligarAr != null)
				return false;
		} else if (!desligarAr.equals(other.desligarAr))
			return false;
		return true;
		
	}
}
