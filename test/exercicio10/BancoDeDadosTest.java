package exercicio10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*
;


class BancoDeDadosTest {
	
	
	
//	(“IF55S”, “ES66”, 27, “sucesso”)
	@Test
	void testsucesso() {
		VerificadorDeCodigos verificadorMock = mock(VerificadorDeCodigos.class);
		when(verificadorMock.verificarCodigoDisciplina("IF55S")).thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("ES56")).thenReturn(true);
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String res = bd.cadastrarTurma("IF55S", "ES56", 27);
		assertEquals("sucesso", res);
		
	}


//	(“2F31D”, “ES66”, 27, “codigo da disciplina invalido”)

	@Test
	void testDisciplinaInvalida() {
		VerificadorDeCodigos verificadorMock = mock(VerificadorDeCodigos.class);
		when(verificadorMock.verificarCodigoDisciplina("2F31D")).thenReturn(false);
		when(verificadorMock.verificarCodigoTurma("ES66")).thenReturn(true);
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String res = bd.cadastrarTurma("2F31D", "ES56", 27);
		assertEquals("codigo da disciplina invalido", res);
		
	}
	

//	(“IF55S”, “3C8J”, 27, “codigo da turma invalido”)
	@Test
	void testTurmaInvalida() {
		VerificadorDeCodigos verificadorMock = mock(VerificadorDeCodigos.class);
		when(verificadorMock.verificarCodigoDisciplina("IF55S")).thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("3C8J")).thenReturn(false);
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String res = bd.cadastrarTurma("2F31D", "ES56", 27);
		assertEquals("codigo da turma invalido", res);
		
	}

	
//	(“IF55S”, “ES66”, 2, “numero de alunos invalido”)
	@Test
	void testNumeroInvalidoMenor() {
		VerificadorDeCodigos verificadorMock = mock(VerificadorDeCodigos.class);
		when(verificadorMock.verificarCodigoDisciplina("IF55S")).thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("ES56")).thenReturn(true);
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String res = bd.cadastrarTurma("IF55S", "ES56", 2);
		assertEquals("numero de alunos invalido", res);
		
	}
	
	
	
//	(“IF55S”, “ES66”, 50, “numero de alunos invalido”)
	@Test
	void testNumeroInvalidoMaior() {
		VerificadorDeCodigos verificadorMock = mock(VerificadorDeCodigos.class);
		when(verificadorMock.verificarCodigoDisciplina("IF55S")).thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("ES56")).thenReturn(true);
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String res = bd.cadastrarTurma("IF55S", "ES56", 50);
		assertEquals("numero de alunos invalido", res);
		
	}
	
	
}
