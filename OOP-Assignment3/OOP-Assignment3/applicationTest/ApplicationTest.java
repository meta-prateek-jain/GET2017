package applicationTest;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import product.Product;
import dao.ProductDaoImpliment;
import promotion.OrderPromo;
import promotion.ProductPromo;
import util.FileHandling;
/**
 * A test class for operations of shopping terminal
 * @author Prateek Jain
 *
 */
public class ApplicationTest {
	/**
	 * Test case to check generateOrderPromoObject() method
	 */
	@Test
	public void generateOrderPromoObjectTest() {
		String line="OrderFixedAmountPromotion,200,4000";
		OrderPromo promoExpected=new OrderPromo("OrderFixedAmountPromotion",200,4000);
		OrderPromo promoActual=OrderPromo.generatePromoObject(line);
		assertEquals(promoExpected.getPromoDiscount(),promoActual.getPromoDiscount(),0.001);
		assertEquals(promoExpected.getPromoType(),promoActual.getPromoType());
		assertEquals(promoExpected.getThreshHold(),promoActual.getThreshHold(),0.001);
	}
	
	/**
	 * Test case to check generateProductObject() method
	 */
	@Test
	public void generateProductObjectTest() {
		String line="1005,Reebok Zigtech Shoes,2899";
		Product productExpected=new Product("1005","Reebok Zigtech Shoes",2899);
		Product productActual=ProductDaoImpliment.generateProductObject(line);
		assertEquals(productExpected.getProductId(),productActual.getProductId());
		assertEquals(productExpected.getProductName(),productExpected.getProductName());
		assertEquals(productExpected.getProductRate(),productActual.getProductRate(),0.001);
	}
	
	/**
	 * Test case to check generateProductPromoObject() method
	 */
	@Test
	public void generatePromoObjectTest() {
		String line="ProductFixedPercentPromotion,15,1005;1014;1020";
		ProductPromo productPromoExpected=new ProductPromo("ProductFixedPercentPromotion",new String[]{"1005","1014","1020"},15);
		ProductPromo productPromoActual=ProductPromo.generatePromoObject(line);
		assertEquals(productPromoExpected.getPromoType(),productPromoActual.getPromoType());
		assertEquals(productPromoExpected.getPromoDiscount(),productPromoExpected.getPromoDiscount(),0.001);
		assertArrayEquals(productPromoExpected.getApplicableProducts(),productPromoActual.getApplicableProducts());
	}
	/**
	 * Test case to check file reading
	 * @throws IOException 
	 */
	@Test (expected = IOException.class)
	public void testFileReading() throws IOException {
		String line="src/product.csv";
		new FileHandling().readLineByLine(line);
		
	}
}