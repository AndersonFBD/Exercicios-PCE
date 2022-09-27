package exercicio8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


class VerificadorDeSenhasTest {
	
	VerificadorDeSenhas ver;
	
	@BeforeEach
	void before(){
		Dicionario dicionarioMock = mock(Dicionario.class);
		ArrayList<String> dicstr = new ArrayList<String>();
		
		dicstr.add("senha");
		dicstr.add("admin");
		
		when(dicionarioMock.getListaDeSenhasInvalidas())
		.thenReturn(dicstr);
		
		ver = new VerificadorDeSenhas(dicionarioMock);
		
	}
	
//	(“olaola”, true)
	@Test
	void testSenhaValida() {
		
		assertTrue(ver.validarNovaSenha("olaola"));
		
	}
	
//	(“1234”, false)
	@Test
	void testSenhaMenorque5Caracteres() {
		
		assertFalse(ver.validarNovaSenha("1234"));
		
	}
	
//	(“11122233345”, false)
	@Test
	void testSenhaMaiorQue10Caracteres() {
		
		assertFalse(ver.validarNovaSenha("11122233345"));
		
	}
	
//	(“&12ab”, false)
	@Test
	void testCaracterInvalidoInicio() {
		
		assertFalse(ver.validarNovaSenha("&12ab"));
		
	}
	
//	(“1$f3a”, false)
	@Test
	void testCombinacaoInvalida() {
		
		assertFalse(ver.validarNovaSenha("1$f3a"));
		
	}
	
//	(“senha”, false)
	@Test
	void testTemNoDicionario() {
		
		assertFalse(ver.validarNovaSenha("senha"));
		
	}
}
