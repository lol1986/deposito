import static org.junit.Assert.*;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DepositoCombustibleTestFill{
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
	
	public DepositoCombustibleTestFill (double n1, double n2, double n3, double r) {
		num1=n1;
		num2=n2;
		num3=n3;
		res=r;
	}
		
	@Parameters 
	public static Collection<Object[]> llenar(){
		return Arrays.asList(new Object[][] {
		{50,0,10,10},{50,0,50,50},{50,10,20,30},{40,0,39.99,39.99},{40,0,40,40},{40,0,40.01,40.01}});
	}
	
	//En estos test vemos que con el último conjunto de valores se permite llenar por encima de la capacidad máxima del depósito.
	//Sería una mejora a implementar que se valide la capacidad máxima al llenar. 
	@Test
	public void testFill() {
		deposito= new DepositoCombustible(num1,num2);
		deposito.fill(num3);
		resultado=deposito.getDepositoNivel();
		assertEquals(res,resultado,0);
	}

}
