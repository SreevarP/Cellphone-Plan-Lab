package first;
import java.util.Scanner;

public class CellPhoneLab {
	final public static double ebase = 60;
	final public static double erate = 5;
	final public static double mrate = 4;
	final public static double mbase = 70;
	final public static double mprate = 7;
	final public static double teacherd = 0.1;
	final public static double efee = 0.08;
	final public static double familydeal = 100;
	final public static double mpbase = 75; 

	static double Essentials(int x, boolean isT){
		if (isT){
			double calc = ebase + (ebase - erate * x);
			return (calc + efee * calc) - teacherd * (calc + efee * calc);
		}
		else{
			double calc = ebase + (ebase - erate * x);
			return calc + efee * calc;	
		}
	}

	static double Magenta(int x, boolean isT){
		if (isT){
			double calc = mbase + (mbase - mrate * x);
			return calc - teacherd * calc;
		}
		else{
			double calc = mbase + (mbase - mrate * x);
			return calc;
		}
		
	}
	
	static double MagentaP(int x, boolean isT){
		if (isT){
			double calc = mpbase + (mpbase - mprate * x);
		    return calc - teacherd * calc;
		}
		else{
			double calc = mpbase + (mpbase - mprate * x);
		    return calc;
		}
		
	}

	public static void main(String[] args) {
		boolean isOn = true;
		while(isOn){
			System.out.println("Which Plan are you choosing");
			System.out.println("How many lines do you need.");
			System.out.println("Are you a teacher?");
			System.out.println("how much is your current plan");
		
			Scanner inputP = new Scanner(System.in);
			Scanner inputM = new Scanner(System.in);
			Scanner inputT = new Scanner(System.in);
			Scanner inputC = new Scanner(System.in);
		
			int plan = inputP.nextInt();
			int lines = inputM.nextInt();
			boolean isTeacher = inputT.nextBoolean();
			int last = inputC.nextInt();
			boolean isdeal = false;
		
			if (lines == 4) {
				System.out.println("We have a deal for a family of four: 100$ plus fees");
				Scanner deal = new Scanner(System.in);
				if(deal.nextBoolean()){
					isdeal = true;
					if(plan == 0){
						double price = familydeal + efee * familydeal;
						System.out.println(price);
					}; 
					if(plan == 1){
						double price = familydeal;
						System.out.println(price);
					}
					else{
						double price = familydeal;
						System.out.println(price);
					}
				}
			}

			if (lines != 4 || !isdeal){
				if(plan == 0){
					double price = Essentials(lines, isTeacher);
					double comp = last - price;
					System.out.printf("For %d lines, your total is $ %.2f per month.%n", lines, price);
					if (comp < 0){
						System.out.printf("Switiching to Tmobile will lose you $ %.2f per month.%n", Math.abs(comp));
					}
					if (comp > 0){
						System.out.printf("Switch to Tmobile will save you $ %.2f per month.%n", Math.abs(comp));
					}
					if (comp == 0){
						System.out.printf("Switching to Tmobile will not save or lose you money.%n");
					}

				}
				if(plan == 1){
					double price = Magenta(lines, isTeacher);
					double comp = last - price;
					System.out.printf("For %d lines, your total is $ %.2f per month.%n", lines, price);

					if (comp < 0){
						System.out.printf("Switiching to Tmobile will lose you $ %.2f per month.%n", Math.abs(comp));
					}
					if (comp > 0){
						System.out.printf("Switch to Tmobile will save you $ %.2f per month.%n", Math.abs(comp));
					}
					if (comp == 0){
						System.out.printf("Switching to Tmobile will not save or lose you money.%n");
					}
				}
				if(plan == 2){
					double price = MagentaP(lines, isTeacher);
					double comp = last - price;
					System.out.printf("For %d lines, your total is $ %.2f per month.%n", lines, price);
					if (comp < 0){
						System.out.printf("Switiching to Tmobile will lose you $ %.2f per month,%n", Math.abs(comp));
					}
					if (comp > 0){
						System.out.printf("Switch to Tmobile will save you $ %.2f per month,%n", Math.abs(comp));
					}
					if(comp == 0) {
						System.out.printf("Switching to Tmobile will not save or lose you money.%n");
					}
				}
			}

			System.out.println("Do you want to find another deal?");
			Scanner answer = new Scanner(System.in);
			if (!answer.nextBoolean()){
				isOn = false;
			}
		}
		
		
		
		
		

	}

}
