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

	//1. Prueba para comprobrar que funciona el método para obtener el nivel actual de depósito
	@Test
	public void testGetDepositoNivel() {
		deposito= new DepositoCombustible(40,10.01);
		res= deposito.getDepositoNivel();
		assertEquals(10.01,res,0);
	}
	
	//2. Prueba que compruebe que, utilizando el método correspondiente, se obtiene el valor límite de máxima capacidad del depósito
	@Test
	public void testgetDepositoMax() {
		deposito= new DepositoCombustible(50,10);
		res= deposito.getDepositoMax();
		assertEquals(50,res,0);
	}

	//3. Prueba para comprobar que funciona el método para saber si el depósito está vacío
		//3.1 Lo probamos cuando el depósito está vacío
	@Test
	public void testestaVacioSi() {
		deposito= new DepositoCombustible(40,0);
		bol= deposito.estaVacio();
		assertEquals(true,bol);
	}
	
		//3.2 Lo probamos cuando no está vacío
	@Test
	public void testestaVacioNo() {
		deposito= new DepositoCombustible(40,0.01);
		bol= deposito.estaVacio();
		assertEquals(false,bol);
	}

	@Test
	//4. Prueba para saber si el depósito está lleno a la mitad de su capacidad.
		//4.1 Lo probamos cuando no está lleno, a la mitad de su capacidad como indica el enunciado
	public void testEstaLlenoNo() {
		deposito= new DepositoCombustible(40,20);
		bol= deposito.estaLleno();
		assertEquals(false,bol);
	}
	
	@Test
		//4.2 Lo probamos cuando si está lleno
	public void testEstaLlenoSi() {
		deposito= new DepositoCombustible(40,40);
		bol= deposito.estaLleno();
		assertEquals(true,bol);
	}
}
