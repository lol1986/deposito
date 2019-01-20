import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DepositoCombustibleTest{
	
	private DepositoCombustible deposito;
	private double res;
	private boolean bol;
	
	@Before
	public void inicioPruebas() {	
	}
	@After
	public void finPruebas() {
		deposito=null;
	}

	//1. Prueba para comprobrar que funciona el m�todo para obtener el nivel actual de dep�sito
	@Test
	public void testGetDepositoNivel() {
		deposito= new DepositoCombustible(40,10.01);
		res= deposito.getDepositoNivel();
		assertEquals(10.01,res,0);
	}
	
	//2. Prueba que compruebe que, utilizando el m�todo correspondiente, se obtiene el valor l�mite de m�xima capacidad del dep�sito
	@Test
	public void testgetDepositoMax() {
		deposito= new DepositoCombustible(50,10);
		res= deposito.getDepositoMax();
		assertEquals(50,res,0);
	}

	//3. Prueba para comprobar que funciona el m�todo para saber si el dep�sito est� vac�o
		//3.1 Lo probamos cuando el dep�sito est� vac�o
	@Test
	public void testestaVacioSi() {
		deposito= new DepositoCombustible(40,0);
		bol= deposito.estaVacio();
		assertEquals(true,bol);
	}
	
		//3.2 Lo probamos cuando no est� vac�o
	@Test
	public void testestaVacioNo() {
		deposito= new DepositoCombustible(40,0.01);
		bol= deposito.estaVacio();
		assertEquals(false,bol);
	}

	@Test
	//4. Prueba para saber si el dep�sito est� lleno a la mitad de su capacidad.
		//4.1 Lo probamos cuando no est� lleno, a la mitad de su capacidad como indica el enunciado
	public void testEstaLlenoNo() {
		deposito= new DepositoCombustible(40,20);
		bol= deposito.estaLleno();
		assertEquals(false,bol);
	}
	
	@Test
		//4.2 Lo probamos cuando si est� lleno
	public void testEstaLlenoSi() {
		deposito= new DepositoCombustible(40,40);
		bol= deposito.estaLleno();
		assertEquals(true,bol);
	}
}
