package billGenerator;

import java.util.List;
import java.util.Map;

import util.FileHandling;
import orderEntry.OrderEntry;
import product.Product;
import promotion.OrderPromo;
import promotion.ProductPromo;

/**
 * Class is generating the final bill of order
 * 
 * @author Prateek Jain
 *
 */
public class BillGenerator {

	public static String billString;

	public static String getBill(OrderEntry[] orderEntry, Map<String, Product> productMap,
			List<OrderPromo> orderPromoList, List<ProductPromo> productPromoList) {

		billString = "\n";
		billString += "###############################################\n";
		billString += "YOUR ORDER  : \n";
		billString += "###############################################\n";
		billString += "\n";
		billString += "PURCHASED PRODUCTS :  \n";

		double finalBillingAmount = 0;

		// loop through each orderEntry
		for (int orderLoop = 0; orderLoop < orderEntry.length; orderLoop++) {

			// getting the product object
			Product currentProduct = productMap.get(orderEntry[orderLoop].getProductId());

			// Adding Details of Product to billString
			billString += "Product : " + currentProduct.getProductId() + " - " + currentProduct.getProductName() + "\n";

			// setting Cost of order
			orderEntry[orderLoop].setCostOfOrder(orderEntry[orderLoop].getQuantity() * currentProduct.getProductRate());
			billString += "Cost    : Rs." + orderEntry[orderLoop].getCostOfOrder() + "("
					+ orderEntry[orderLoop].getQuantity() + " x " + currentProduct.getProductRate() + ")" + "\n\n";
			orderEntry[orderLoop].evaluateApplicablePromotions(productPromoList);
			orderEntry[orderLoop].evaluateProductDiscount(currentProduct);

			// Get Subtotal Cost of orders
			finalBillingAmount += orderEntry[orderLoop].getCostOfOrder();
		}
		billString += "Subtotal : Rs. " + finalBillingAmount;
		billString += "\n\n";
		double productPromotionDiscount = 0;

		// In this loop object of ProductPromotion for each orderEntry is set if applicable
		for (int orderLoop = 0; orderLoop < orderEntry.length; orderLoop++) {
			Product currentProduct = productMap.get(orderEntry[orderLoop].getProductId());
			if (!orderEntry[orderLoop].getAppliedPromotion().generatePromotionString(productMap, currentProduct).equals("")) {
				billString += "Promotion : "
						+ orderEntry[orderLoop].getAppliedPromotion().generatePromotionString(productMap, currentProduct) + "\n";
				billString += "Discount  : "
						+ orderEntry[orderLoop].getDiscountAmount() * orderEntry[orderLoop].getQuantity();
				billString += "\n";
				productPromotionDiscount += (orderEntry[orderLoop].getDiscountAmount()
						* orderEntry[orderLoop].getQuantity());
			}
		}
		billString += "\n";
		billString += "Product Promotions Discount : Rs." + productPromotionDiscount + "\n";
		finalBillingAmount -= productPromotionDiscount;
		double finalOrderDiscount = 0;
		OrderPromo appliedOrderPromotion = null;

		// In this loop applicable order promotion is applied and get
		for (OrderPromo promotion : orderPromoList) {
			double discount = 0;
			//checking if any order promotion can be applied or not
			if (promotion.isApplicable(finalBillingAmount)) {
				discount = promotion.getPromoDiscount();
				//if promotion is of type percentage then calculate discount 
				if (promotion.getPromoType().equals("OrderFixedPercentPromotion")) {
					discount = discount * finalBillingAmount / 100.0;
				}
			}
			//storing the final discount 
			if (discount > finalOrderDiscount) {
				finalOrderDiscount = discount;
				appliedOrderPromotion = promotion;
			}
		}
		double finalBill;
		if((finalBillingAmount - finalOrderDiscount)<0){
			finalBill = 0;
		}else{
			finalBill = (finalBillingAmount - finalOrderDiscount);
		}
		
		billString += appliedOrderPromotion != null ? appliedOrderPromotion.generateOrderPromotionString() : "";
		billString += "Final Amount Payable : Rs." + finalBill;
		billString.replace("\n", "\r\n");
		// Function writes the String to file
		FileHandling.write(billString, "src/storefiles/CurrentBill.txt");
		return billString;
	}
}