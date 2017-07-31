package orderEntry;
import java.util.ArrayList;
import java.util.List;

import product.Product;
import promotion.ProductPromo;
/**
 * Class is designed to set and get order Details
 * 
 * @author Prateek Jain
 *
 */
public class OrderEntry {
	private String productId;
	private int quantity;
	private double costOfOrder;
	private ProductPromo appliedPromotion = new ProductPromo();
	private List<ProductPromo> applicablePromotions = new ArrayList<ProductPromo>();
	private double discountAmount;
	
	/**
	 * Initializing variables
	 * 
	 * @param productId
	 * @param quantity
	 */
	public OrderEntry(String productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public OrderEntry() {
		productId = "";
	}

	public double getCostOfOrder() {
		return costOfOrder;
	}

	public void setCostOfOrder(double costOfOrder) {
		this.costOfOrder = costOfOrder;
	}

	public ProductPromo getAppliedPromotion() {
		return appliedPromotion;
	}

	public void setAppliedPromotion(ProductPromo appliedPromotion) {
		this.appliedPromotion = appliedPromotion;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Evaluates the discount amount on a product, among the applicable promotions
	 * 
	 * @param product
	 */
	public void evaluateProductDiscount(Product product) {
		for (ProductPromo promotion : applicablePromotions) {
			/*
			 * if promoType is of fixed promotion and its discount value is
			 * greater than previous discount then set variables 
			 * else if promoType is of percentage type and its discount value is greater
			 * than previous discount then set variables
			 */
			if ("ProductFixedAmountPromotion".equals(promotion.getPromoType())
					&& (promotion.getPromoDiscount() > discountAmount)) {
				discountAmount = promotion.getPromoDiscount();
				appliedPromotion = promotion;
			} else if ("ProductFixedPercentPromotion".equals(promotion.getPromoType())
					&& ((promotion.getPromoDiscount()) * product.getProductRate() / 100.0 > discountAmount)) {
				discountAmount = (promotion.getPromoDiscount()) * product.getProductRate() / 100.0;
				appliedPromotion = promotion;
			}
		}
	}

	/**
	 * Evaluate the applicable promotions on a product entry
	 * 
	 * @param productPromoList
	 */
	public void evaluateApplicablePromotions(List<ProductPromo> productPromoList) {
		//Iterate on promotions list and find which promotion is applicable
		for (ProductPromo promotion : productPromoList) {
			//checking promotion is applicable or not
			if (promotion.isApplicable(productId)) {
				applicablePromotions.add(promotion);
			}
		}
	}

	public List<ProductPromo> getApplicablePromotions() {
		return applicablePromotions;
	}

	public void setApplicablePromotions(List<ProductPromo> applicablePromotions) {
		this.applicablePromotions = applicablePromotions;
	}

}