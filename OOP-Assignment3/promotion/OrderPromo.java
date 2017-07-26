package promotion;
import java.util.StringTokenizer;
/**
 * Class is used for OrderPromotions to store their properties
 *  and to check which promotion can be applied to order 
 * @author Prateek Jain
 *
 */
public class OrderPromo {
	
	private String type;			
	private double discount;		
	private double threshHold;		
	
	public OrderPromo(String promoType, double promoDiscount, double threshHold) {
		this.type = promoType;
		this.discount = promoDiscount;
		this.threshHold = threshHold;
	}
	public OrderPromo() {
	}
	
	//getters and setters
	public String getPromoType() {
		return type;
	}
	public void setPromoType(String promoType) {
		this.type = promoType;
	}
	public double getPromoDiscount() {
		return discount;
	}
	public void setPromoDiscount(double promoAmount) {
		this.discount = promoAmount;
	}
	public double getThreshHold() {
		return threshHold;
	}
	public void setThreshHold(double threshHold) {
		this.threshHold = threshHold;
	}
	public Boolean isApplicable(double orderAmount) {
		return orderAmount>getThreshHold()?true:false;
	}
	
	public String generateOrderPromotionString() {
		return ("Order Promotion Applied : "+this.getPromoDiscount()+" % off on "
				+this.getThreshHold()+" and above order\n");
	}
	
	/*generate a new OrderPromo Object in response of a line*/ 
	
	public static OrderPromo generatePromoObject(String line) {
		OrderPromo orderPromo=new OrderPromo();
		StringTokenizer promoToken=new StringTokenizer(line,",");
		if(promoToken.countTokens()==3) {
			orderPromo.setPromoType(promoToken.nextToken());
			orderPromo.setPromoDiscount(Double.parseDouble(promoToken.nextToken()));
			orderPromo.setThreshHold(Double.parseDouble(promoToken.nextToken()));
		}
		return orderPromo;
	}
}