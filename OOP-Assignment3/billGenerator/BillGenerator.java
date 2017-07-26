package billGenerator;

import java.util.List;
import java.util.Map;
import util.WriteFile;
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
			if (!orderEntry[orderLoop].getAppliedPromotion().generatePromotionString(productMap).equals("")) {
				billString += "Promotion : "
						+ orderEntry[orderLoop].getAppliedPromotion().generatePromotionString(productMap) + "\n";
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
			if (promotion.isApplicable(finalBillingAmount)) {
				discount = promotion.getPromoDiscount();
				if (promotion.getPromoType().equals("OrderFixedPercentPromotion")) {
					discount = discount * finalBillingAmount / 100.0;
				}
			}
			if (discount > finalOrderDiscount) {
				finalOrderDiscount = discount;
				appliedOrderPromotion = promotion;
			}
		}

		billString += appliedOrderPromotion != null ? appliedOrderPromotion.generateOrderPromotionString() : "";
		billString += "Final Amount Payable : Rs." + (finalBillingAmount - finalOrderDiscount);

		// Function writes the String to file
		WriteFile.write(billString, "src/storefiles/CurrentBill.txt");
		return billString;
	}
}