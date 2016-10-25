
class BeersRUs {
	public static void main(String[] args){
		
	int beerNum = 99;
	String word = "bottles";
		
		while(beerNum > 0){
			word = "bottle";
		}
		
		System.out.print(beerNum + " " + word + " of beers on the wall");
		System.out.print(beerNum + " " + word + " of beer.");
		System.out.print("Take one down.");
		System.out.print("Pass it around.");
		beerNum = beerNum - 1;
	
		if(beerNum > 0){
			System.out.println(beerNum + " " + "bottles" + " of beer on the wall");
		}else{
			System.out.println("No more bottles of beer on the wall");
		}
	}
}

