# language: pt
@ConsultarReguaTest
Funcionalidade: Consultar Regua

	Cenário: NENHUMA metaregua
		Dado que não há metaregua
		Quando for executada task Consultar Regua
		Então será retornada a metaregua vazia    

	Cenário: apenas uma metaregua INATIVA
		Dado que há apenas uma metaregua INATIVA
		Quando for executada task Consultar Regua
		Então será retornada a metaregua vazia

	Cenário: apenas uma metaregua ATIVA
		Dada a metaregua de id X e situação ATIVA
		Quando for executada task Consultar Regua
		Então será retornada a metaregua de id X
		