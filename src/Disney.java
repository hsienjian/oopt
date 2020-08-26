/**
 * @(#)Disney.java
 *
 *
 * @author 
 * @version 1.00 2020/8/21
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Disney {
    
    static Scanner scan = new Scanner(System.in);
    static Scanner get = new Scanner(System.in);
    private static int suppIdCount=7003;

    
    public static void main (String [] args) {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        
        //Supplier
        Supplier.getSupplier().add(new Supplier(7001, "Khor", "Wen Xin", "987-456 1230", 19, 'F', "khorwx@gmail.com", "Jalan wawasan", "Puchong", "Selangor", 57000, "Malaysia"));
        Supplier.getSupplier().add(new Supplier(7002, "Low", "Jia Hie", "872-856 4815", 19, 'M', "lowjh@gmail.com", "Jalan radin mercu", "Cheras", "Kuala Lumpur", 59200, "Malaysia"));
        
        //Staff
        ArrayList<Staff> staff= new ArrayList<Staff>();
        staff.add(new Staff(5001, "Ng", "Jing Chong", "010-282 6133", 19, 'M', "ngjingchong@gmail.com", "Jalan 14/155c", "Bukit Jalil", "Kuala Lumpur", 57000, "Malaysia", "Jc101255", 010207, "Admin", "has higher accessibility to every thing"));
        staff.add(new Staff(5002, "Puah", "Hsien Jian", "012-345 6789", 21, 'M', "puahhj@gmail.com", "Jalan meru", "Cheras", "Kuala Lumpur", 58200, "Malaysia", "Hj123456", 123456, "Cashier", "Collect money from customer"));
        
        String [] arr1 = {"Scream Park", "X Park", "Wildlife Park"};
        ArrayList<Package> pk = new ArrayList<Package>();
        
        pk.add(new Package(9001,"Helloween", arr1,130.00,200.00,180));
        pk.add(new Package(9002,"CNY", arr1,150.00,220.00,190));
    	
    	int staffId;
    	String password;
    	boolean grant = false;
    	int choice = 0;
    	int quit = 1;
    	do{
	    	System.out.printf("Enter Staff ID > ");
	    	staffId = scan.nextInt();
	    	
                System.out.printf("Enter Password > ");
	    	password = get.nextLine();
	    		
	    	for(Staff s : staff){
	    		if(s.getID() == staffId && s.getPassword().equals(password)){
	    			grant = true;
	    			break;
	    		}else {
	    			grant = false;
	    		}
	    	}
	    	
	    	if(!grant){
	    		System.out.println("Staff not exist !");
	    	}else{
	    		System.out.println("Welcome !");
	    		
	    		do{
		    		System.out.println("1. Staff");
			    	System.out.println("2. Customer");
			    	System.out.println("3. Supplier");
			    	System.out.println("4. Package");
			    	System.out.println("5. Exit");
			    	System.out.print("Pick Functional area to Perform Task (1-5) > ");
			    	choice = scan.nextInt();
			    	
			    	switch(choice){
			    		case 1:
			    			staff();
			    			break;
			    		case 2:
			    			customer();
			    			break;
			    		case 3:
			    			supplier();
			    			break;
			    		case 4:
			    			pk = packages(pk);
			    			break;
			    		case 5:
			    			quit = 0;
			    			break;
			    	}
	    		}while (choice != 5);
	    	}	
    	}while (quit != 0);
    	
    }
    
 
    
    public static void staff(){
    	int choice;
    	do{
	    	System.out.println("1. Add new Staff");
		   	System.out.println("2. Edit Personal Details");
		   	System.out.println("3. Display Staff List");
		   	System.out.println("4. Return");
		   	System.out.print("Pick Your Action (1-4) > ");
		   	choice = scan.nextInt();
		   	
		   	switch(choice){
		   		case 1:
		   			addStaff();
		   			break;
		   		case 2:
		   			editStaffInfo();
		   			break;
		   		case 3:
		   			staffDisplay();
		    		break;
		    	case 4:
		    		break;
		   	}
    	}while (choice != 4);
    }
    public static void customer(){
    	int choice;
    	do{
	    	System.out.println("1. Register new Customer");
		   	System.out.println("2. Edit Personal Details");
		   	System.out.println("3. Purchase Ticket");
		   	System.out.println("4. View Order Record");
		   	System.out.println("5. Return");
		   	System.out.print("Pick Your Action (1-5) > ");
		   	choice = scan.nextInt();
		   	
		   	switch(choice){
		   		case 1:
		   			addCustomer();
		   			break;
		   		case 2:
		   			editCustInfo();
		   			break;
		   		case 3:
		   			buyTicket();
		    		break;
		    	case 4:
		   			displayOrder();
		    		break;
		    	case 5:
		    		break;
		   	}
    	}while (choice != 5);
    }
    public static void supplier(){
    	int choice;
    	do{
	    	System.out.println("1. Add New Suppplier");
	    	System.out.println("2. Add New Product");
		   	System.out.println("3. Edit Personal Details");
		   	System.out.println("4. Edit Product Details");
		   	System.out.println("5. Display Supplier List");
		   	System.out.println("6. Display Product List");
		   	System.out.println("7. Restock Product");
		   	System.out.println("8. Return");
		   	System.out.print("Pick Your Action (1-8) > ");
		   	choice = scan.nextInt();
		   	
		   	switch(choice){
		   		case 1:
		   			addSupplier();
		   			break;
		   		case 2:
		   			addProduct();
		   			break;
		   		case 3:
		   			editSupplierInfo();
		   			break;
		   		case 4:
		   			EditProductInfo();
		    		break;
                                case 5:
		   			System.out.println(Supplier.getSupplier().toString());
		   			break;
		   		case 6:
		   			productDisplay();
		    		break;
                                case 7:
                                    restock();
		    		break;
		    	case 8:
		    		break;
		   	}
    	}while (choice != 8);
    }
    public static ArrayList<Package> packages(ArrayList<Package> pk){
        ArrayList<Package> temp = pk;
    	int choice;
    	do{
	    	System.out.println("1. Add New Package");
		   	System.out.println("2. Edit Package Details");
		   	System.out.println("3. Delete Package");
		   	System.out.println("4. Display Package List");
		   	System.out.println("5. Return");
		   	System.out.print("Pick Your Action (1-5) > ");
		   	choice = scan.nextInt();
		   	
		   	switch(choice){
		   		case 1:
		   			temp = addPackage(temp);
		   			break;
		   		case 2:
		   			temp = editPackage(temp);
		   			break;
		   		case 3:
		   			deletePackage(temp);
		    		break;
                                case 4:
                                        packageDisplay(pk);
		    		break;
                                case 5:
		    		break;
		   	}
    	}while (choice != 5);
        
        return temp;
    }
 
    
    public static ArrayList<Package> addPackage(ArrayList<Package> pk){
        ArrayList<Package> temp = pk;
        char confirm;
        
        String title;
        String []zone = new String[5];
        double normalPrice;
        double premiumPrice;
        int party;
        
        //ArrayList<Package> pk = new ArrayList<Package>();

        System.out.println("Enter the title to check: ");
        title=scan.nextLine();
        
        for(Package p : pk){ 
            if(title != p.getTitle()){ //to check the title exist anot
        
            System.out.println("Package ID : " + p.getId());
            System.out.println("Please add the title: ");
            title = scan.nextLine();
            
            
            System.out.println("Please add the zone: ");
            zone[3] = scan.nextLine();
            
            
            System.out.println("Please add the normalPrice: ");
            normalPrice = scan.nextDouble();
            
            
            System.out.println("Please add the premiumPrice: ");
            premiumPrice = scan.nextDouble();
            
            
            System.out.println("Please add the party price: ");
            party = scan.nextInt();
            
            
            System.out.println("Are you confrim to add? (Y/N) : ");
            confirm = scan.nextLine().toUpperCase().charAt(0);
            
                if(confirm == 'Y'){
                    temp.add(new Package(p.getId(),title,zone,normalPrice,premiumPrice,party));
                    System.out.println("Successful");
                }else{
                    System.out.println("No Package added");
                }

            }else{
                System.out.println("Package exist");
            }  
        } 
        return temp;
    }
    
    public static ArrayList<Package> editPackage(ArrayList<Package> pk){
        ArrayList<Package> temp = pk;
        char confirm;
        String title;
        String []zone = new String[5];
        double normalPrice;
        double premiumPrice;
        int party;
        
        for(Package p : pk){ 
            
            System.out.println("Package ID : " + p.getId());
            System.out.println("Please add the title: " + p.getTitle());
            System.out.println("Please add the zone: " + p.getZone());
            System.out.println("Please add the normalPrice: " + p.getNormalPrice());
            System.out.println("Please add the premiumPrice: " + p.getPremiumPrice());
            System.out.println("Please add the party price: " + p.getParty());
            
            
            System.out.println("T = Title" + "\n" + "Z = Zone" + "\n"
                                + "N = Normal Price" + "\n" + 
                                "P = Premium Price" + "\n" + "A = Party");
            System.out.println("Which information you want to edit? (T/Z/N/P/A)");
            confirm = scan.nextLine().toUpperCase().charAt(0);
        
            if (confirm == 'T'){
                System.out.println("Current title is : " + p.getTitle());
                System.out.println("Please enter the new title : ");
                title = scan.nextLine();
                p.setTitle(title);
                
            }else if (confirm == 'Z'){
                System.out.println("Current zone is " + p.getZone());
                System.out.println("Please enter the new zone:");
                zone[3] = scan.nextLine();
                p.setZone(zone);
            }else if(confirm == 'N'){
                System.out.println("Current normal price is : " + p.getNormalPrice());
                System.out.println("Please enter the new normal price :");
                normalPrice = scan.nextDouble();
                p.setNormalPrice(normalPrice);

            }else if (confirm == 'P'){
                System.out.println("Current premium price is : " + p.getPremiumPrice());
                System.out.println("Please enter the new normal price :");
                premiumPrice = scan.nextDouble();
                p.setPremiumPrice(premiumPrice);
                
            }else if (confirm == 'A'){
                System.out.println("Current party price is : " + p.getParty());
                System.out.println("Please enter the new normal price :");
                party = scan.nextInt();
                p.setParty(party);
                
            }else{
                System.out.println("Invalid character");
                System.out.println("");
                System.out.println("Please key in T/Z/N/P/A");
            }
            
//            System.out.println("Do you confirm want to edit: ");
//            confirm = scan.nextLine().charAt(0);
//            
//            
//                temp.add(new Package(p.getId(),title,zone,normalPrice,premiumPrice,party));
//                System.out.println("Successful edit");
//            
//                System.out.println("Edit unsuccessful");
            
        }
            
        return temp;
    }
    
    public static ArrayList<Package> deletePackage(ArrayList<Package> pk){
        ArrayList<Package> temp = pk;
        int confirm;
        
        for(Package p : pk){
            
            System.out.println("Current Available Package Id: " + p.getId());
            System.out.println("Please enter the package id to delete: " );
            confirm = scan.nextInt();
            
            if(confirm == p.getId()){
                temp.remove(p);
            }
            
            
        }
        return pk;
    }
    
    public static ArrayList<Package> packageDisplay(ArrayList<Package> pk){
        
        System.out.println("Package" + "\n" + pk.toString());
        
        return pk;
    }
    
    public static void addSupplier (){
        ArrayList<Supplier> supplier = Supplier.getSupplier();
        char ask;
        
        System.out.print("Do you want to add supplier (Y/N) > ");
        ask = get.nextLine().charAt(0);

        if(ask == 'Y'){

            System.out.println("-Supplier Personal info-");
            System.out.println("=========================");
            System.out.println("Supplier ID : " + suppIdCount);
            System.out.print("Enter first name : ");
            String suppfName = get.nextLine();
            System.out.print("Enter last name : ");
            String supplName = get.nextLine();
            System.out.print("Enter phone number : ");
            String suppPhNum = get.nextLine();
            System.out.print("Enter age : ");
            int suppAge = scan.nextInt();
            System.out.print("Enter gender : ");
            char suppGender = get.nextLine().charAt(0);
            System.out.print("Enter email : ");
            String suppEmail = get.nextLine();

            System.out.println("-Supplier's Company Address-");
            System.out.println("=========================");  
            System.out.print("Enter street : ");
            String suppStreet = get.nextLine();
            System.out.print("Enter city : ");
            String suppCity = get.nextLine();
            System.out.print("Enter state : ");
            String suppState = get.nextLine();
            System.out.print("Enter posCode : ");
            int suppPosCode = scan.nextInt();
            System.out.print("Enter country : ");
            String suppCountry = get.nextLine();

            System.out.print("Comfirm to add ?(Y/N) >");
            ask = get.nextLine().charAt(0);

            if(ask == 'Y'){
                supplier.add(new Supplier(suppIdCount,suppfName,supplName,suppPhNum,suppAge,suppGender,suppEmail,suppStreet,suppCity,suppState,suppPosCode,suppCountry));
                System.out.println("Supplier added !");
                suppIdCount++;
                Supplier.setSupplier(supplier);
            }else{
                 System.out.println("Failed added !");
                 
            }

        } 
        
    }
    
}