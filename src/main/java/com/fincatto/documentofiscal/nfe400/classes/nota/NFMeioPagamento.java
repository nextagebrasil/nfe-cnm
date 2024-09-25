package com.fincatto.documentofiscal.nfe400.classes.nota;

public enum NFMeioPagamento {

	DINHEIRO("01", "Dinheiro"),
	CHEQUE("02", "Cheque"),
	CARTAO_CREDITO("03", "Cart\u00e3o de cr\u00e9dito"),
	CARTAO_DEBITO("04", "Cart\u00e3o de d\u00e9bito"),
	CARTAO_LOJA("05", "Cart\u00e3o da loja"),
	VALE_ALIMENTACAO("10", "Vale alimenta\u00e7\u00e3o"),
	VALE_REFEICAO("11", "Vale refei\u00e7\u00e3o"),
	VALE_PRESENTE("12", "Vale presente"),
	VALE_COMBUSTIVEL("13", "Vale combust\u00edvel"),
	DUPLICATA_MERCANTIL("14", "Duplicata mercantil"),
	BOLETO_BANCARIO("15", "Boleto bancario"),
	DEPOSITO_BANCARIO("16", "Deposito bancario"),
	PIX_DINAMICO("17", "Pagamento Instant\u00e2neo (PIX) - Din\u00e2mico"),
	TRANSFERENCIA_BANCARIA("18", "Transferencia bancaria"),
	FIDELIDADE_CASHBACK("19", "Programa de fidelidade (Cashback)"),
	PIX_ESTATICO("20", "Pagamento Instant\u00e2neo (PIX) - Est\u00e1tico"),
	CREDITO_EM_LOJA("21", "Cr\u00e9dito em Loja"),
	PAGAMENTO_ELETRONICO_NAO_INFORMADO("22", "Pagamento Eletr\u00f4nico n\u00e3o Informado"),
	SEM_PAGAMENTO("90", "Sem pagamento"),
	OUTRO("99", "Outro");

	private final String codigo;
	private final String descricao;

	NFMeioPagamento(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public static NFMeioPagamento valueOfCodigo(final String codigo) {
		for (final NFMeioPagamento formaPagamentoMoeda : NFMeioPagamento.values()) {
			if (formaPagamentoMoeda.getCodigo().equals(codigo)) {
				return formaPagamentoMoeda;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return this.codigo + " - " + this.descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
