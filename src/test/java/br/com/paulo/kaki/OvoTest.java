package br.com.paulo.kaki;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class OvoTest {
	@Test
	public void fritarTest() {

		Ovo ovo = new Ovo(false, 10);
		ovo.quebrar();
		assertEquals(EnumStatusOvo.CRU, ovo.pegarStatus());
		for(Integer i = 0; i < 10; i++) {
			ovo.fritar();
		}
		assertEquals(EnumStatusOvo.DELÍCIA, ovo.pegarStatus());
	}

	@Test
	public void fritarNaoQuebradoTest() {
		Ovo ovo = new Ovo(false, 10);
		
		Exception exception = assertThrows(RuntimeException.class, () -> {
			ovo.fritar();
		});
		
		assertEquals("Ovo não está quebrado", exception.getMessage());
	}
	
	@Test
	public void qubrarOvoTest() {
		Ovo ovo = new Ovo(false, 10);
		ovo.quebrar();
		assertEquals(true, ovo.estaQuebrado());
	}
	
	@Test
	public void ovoEstragadoTest() {
		Ovo ovo = new Ovo(true, 10);
		assertEquals(true, ovo.estaEstragado());
	}
}
