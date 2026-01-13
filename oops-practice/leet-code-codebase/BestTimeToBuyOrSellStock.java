
public class BestTimeToBuyOrSellStock {
	public  static void main(String args[]) {
		
		int stockPrice [] = {1,7,6,4,11,12,1};
		
		int result = maxProfit(stockPrice);
		System.out.println(result);
	}

	    public static int maxProfit(int[] prices) {
	        int max=0;
	        int price=prices[prices.length-1];
	        for(int i=prices.length-2;i>=0;i--){
	            if(prices[i]>price){
	                price=prices[i];
	            }
	            else{
	                if(max<price-prices[i]){
	                    max=price-prices[i];
	                }
	            }
	        }
	        return max;
	    }
	}
