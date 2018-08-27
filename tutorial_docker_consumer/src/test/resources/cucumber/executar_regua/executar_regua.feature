# language: pt
@ExecutarReguaTest
Funcionalidade: Executar Regua

	Contexto:
		Dado estão definidas na régua as posições:
			| posicao | prioridade |
			|   -5    | MEDIA      |
			|   30    | MEDIA      |
			|   60    | MEDIA      |
		
	
	Cenário: 
		Dado o associado de cpf 12345678901 possui as parcelas:
		  | titulo  | parcela | vencimento | pagamento |	
			| B0001   | 1       | -120       | -100      |
			| B0001   | 2       | -90        | -80       |
			| B0001   | 3       | -60        |           |
			| B0001   | 4       | -30        |           | 
		Quando executar a regua
		