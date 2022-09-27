package exercicio14;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import exercicio10.BancoDeDados;
import exercicio10.VerificadorDeCodigos;


class BancoDeDadosTest {
	
	
//	(“71AFA3”, “ES4”, 21, “Turma cadastrada com sucesso”)
	@Test
	void testTurmaCadastradaComSucesso() {
		VerificadorDeCodigos verificadorMock = mock(VerificadorDeCodigos.class);
		when(verificadorMock.verificarCodigoDisciplina("71AFA3")).thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("ES4")).thenReturn(true);
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String cadAlu = bd.cadastrarTurma("71AFA3", "ES4", 21);
		assertEquals("Turma cadastrada com sucesso", cadAlu);
		
	}
	
	
//	(“AB1234”, “ES4”, 21, “Codigo de disciplina nao é valido”)
	@Test
	void testCodigoDisciplinaNaoValido() {
		VerificadorDeCodigos verificadorMock = mock(VerificadorDeCodigos.class);
		when(verificadorMock.verificarCodigoDisciplina("AB1234")).thenReturn(false);
		when(verificadorMock.verificarCodigoTurma("ES4")).thenReturn(true);
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String cadAlu = bd.cadastrarTurma("AB1234", "ES4", 21);
		assertEquals("Codigo de disciplina nao é valido", cadAlu);
		
	}
	
//	(“71AFA3”, “J57”, 21, “Codigo de turma fora do padrao”)
	@Test
	void testCodigoTurmaInvalido() {
		VerificadorDeCodigos verificadorMock = mock(VerificadorDeCodigos.class);
		when(verificadorMock.verificarCodigoDisciplina("71AFA3")).thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("J57")).thenReturn(true);
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String cadAlu = bd.cadastrarTurma("71AFA3", "J57", 21);
		assertEquals("Codigo de turma fora do padrao", cadAlu);
		
	}
	
//	(“71AFA3”, “ES4”, 3, “Numero de alunos invalido”)
	@Test
	void testNumeroAlunoInvalidoMenor() {
		VerificadorDeCodigos verificadorMock = mock(VerificadorDeCodigos.class);
		when(verificadorMock.verificarCodigoDisciplina("71AFA3")).thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("ES4")).thenReturn(true);
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String cadAlu = bd.cadastrarTurma("71AFA3", "ES4", 3);
		assertEquals("Numero de alunos invalido", cadAlu);
		
	}	
	
	
//	(“71AFA3”, “ES4”, 36, “Numero de alunos invalido”)
	@Test
	void testNumeroAlunoInvalidoMaior() {
		VerificadorDeCodigos verificadorMock = mock(VerificadorDeCodigos.class);
		when(verificadorMock.verificarCodigoDisciplina("71AFA3")).thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("ES4")).thenReturn(true);
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String cadAlu = bd.cadastrarTurma("71AFA3", "ES4", 36);
		assertEquals("Numero de alunos invalido", cadAlu);
		
	}	
	
	

}
