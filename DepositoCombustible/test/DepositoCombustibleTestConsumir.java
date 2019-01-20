import static org.junit.Assert.*;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DepositoCombustibleTestConsumir{
	private DepositoCombustible deposito;
	private double num1;
	private double num2;
	private double num3;
	private double resultado;
	private double res;
	
	@Before
	public void inicioPruebas() {	
	}
	@After
	public void finPruebas() {
		deposito=null;
	}
	
	public DepositoCombustibleTestConsumir (double n1, double n2, double n3, double r) {
		num1=n1;
		num2=n2;
		num3=n3;
		res=r;
	}
		
	@Parameters 
	public static Collection<Object[]> llenar(){
		return Arrays.asList(new Object[][] {
		{50,50,50,0},{50,50,0.01,49.99},{50,50,-0.01,50.01},{50,0,0.01,0}});
	}
	
	//Con el penúltimo conjunto de valores vemos que se permiten consumir cantidades de combustible negativas.
	//Con el último conjunto de valores vemos que se permite consumir más combustible del que existe en el depósito.
	//Habría que implementar mejoras para corregir estos problemas del código.
	@Test
	public void testConsumir() {
		deposito= new DepositoCombustible(num1,num2);
		deposito.consumir(num3);;
		resultado=deposito.getDepositoNivel();
		assertEquals(res,resultado,0);
	}
}
