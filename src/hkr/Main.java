package hkr;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

public class Main {
    ArrayList<Hotel> rooms = new ArrayList<>();
    ArrayList<Employee> employee = new ArrayList<>();
    ArrayList<Admin> admins = new ArrayList<>();
    int empCounter = 0;
    int admCounter = 1;
    int roomCounter = 0;
    int bookingCounter = 0;
    Admin Admin1 = new Admin("Muhammad","Hamza","980515-3377","073-7410229","Hamza",1);
    public static void main(String[] args) {
        Main myApp = new Main();
        myApp.showMenu();
    }
    public void showMenu(){
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.println("=====Welcome to our Hotel=====");
            System.out.println("Enter Your Choice");
            System.out.println("Are You :");
            System.out.println("1. Admin");
            System.out.println("2. Employee");
            System.out.println("3. Customer");
            int inp = input.nextInt();
            switch (inp) {
                case 1:
                    System.out.println("Enter Your Admin Id");
                    int adminId = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter your Password");
                    String pass = input.nextLine();
                    adminVerify(adminId, pass);
                    break;
            }
        }
    }
    public void adminVerify(int adId, String pass){
        if (adId == Admin1.getAdminCounter()) {
            if (pass.equals(Admin1.getAdminPassword())) {
                System.out.format("%s! You have successfully Logged In%n", Admin1.getFirstName());
            }
            else{
                System.out.println("Your Password is Wrong!");
                System.out.println("Please Try Again");
            }
        }
        else{
            System.out.println("Your Admin Id is Wrong!");
            System.out.println("Please Try Again");
        }
        adminMenu();
    }
    public void adminMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("=====Admin=====");
        System.out.println("1. View all available rooms");
        System.out.println("2. View all Employees");
        System.out.println("3. View all Bookings");
        System.out.println("4. View all Admins");
        System.out.println("5. Create a new room");
        System.out.println("6. Create a new Employee");
        System.out.println("7. Create a new Admin");
        System.out.println("8. Remove a room");
        System.out.println("9. Remove a employee");
        System.out.println("10. Remove a admin");
        System.out.println("11. Remove a Booking");
        int inp = input.nextInt();
        switch(inp){
            case 1:
                showRoom();
                break;
            case 2:
                showEmployee();
                break;
            case 3:
                showBookings();
                break;
            case 4:
                showAdmins();
                break;
            case 5:
                createRoom();
                break;
            case 6:
                createEmployee();
                break;
            case 7:
                createAdmin();
                break;
        }
    }
    public void createRoom(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of room");
        int room = input.nextInt();
        System.out.println("Does it have a booking");
        boolean booking = input.nextBoolean();
        roomCounter++;
        if(booking == true){
            bookingCounter++;
        }
        Hotel hotel = new Hotel(room,booking,bookingCounter);
        rooms.add(hotel);
        try {
            FileWriter fw = new FileWriter("Rooms.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(rooms);
            pw.close();
        } catch (IOException e) {
            out.println("Error!");
        }
        adminMenu();
    }
    public void showRoom(){
        System.out.println("The available rooms are:"+roomCounter);
        try{
            FileReader fr = new FileReader("Rooms.txt");
            BufferedReader br = new BufferedReader(fr);

            String room;
            while((room = br.readLine()) != null){
                out.println(room+"\n");
            }
        }catch(IOException e){
            out.println("File Not Found!");
        }
    }
    public void createEmployee(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first name of Employee");
        String fname = input.nextLine();
        System.out.println("Enter the last name of Employee");
        String lname = input.nextLine();
        System.out.println("Enter the Person Number of Employee");
        String pNumber = input.nextLine();
        System.out.println("Enter the Phone Number of Employee");
        String phNumber = input.nextLine();
        System.out.println("Enter the Password of Employee");
        String pass = input.nextLine();
        empCounter++;
        Employee employee1 = new Employee(fname,lname,pNumber,phNumber,pass,empCounter);
        employee.add(employee1);
        try {
            FileWriter fw = new FileWriter("Employee.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(employee);
            pw.close();
        } catch (IOException e) {
            out.println("Error!");
        }
        adminMenu();
    }
    public void showEmployee(){
        try{
            FileReader fr = new FileReader("Employee.txt");
            BufferedReader br = new BufferedReader(fr);

            String emp;
            while((emp = br.readLine()) != null){
                out.println(emp+"\n");
            }
        }catch(IOException e){
            out.println("File Not Found!");
        }
        adminMenu();
    }
    public void createAdmin(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first name of Admin");
        String fname = input.nextLine();
        System.out.println("Enter the last name of Admin");
        String lname = input.nextLine();
        System.out.println("Enter the Person Number of Admin");
        String pNumber = input.nextLine();
        System.out.println("Enter the Phone Number of Admin");
        String phNumber = input.nextLine();
        System.out.println("Enter the Password of Admin");
        String pass = input.nextLine();
        admCounter++;
        Admin admin2 = new Admin(fname,lname,pNumber,phNumber,pass,admCounter);
        admins.add(admin2);
        try {
            FileWriter fw = new FileWriter("Admin.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(admins);
            pw.close();
        } catch (IOException e) {
            out.println("Error!");
        }
        adminMenu();
    }
    public void showAdmins(){
        try{
            FileReader fr = new FileReader("Admin.txt");
            BufferedReader br = new BufferedReader(fr);

            String adm;
            while((adm = br.readLine()) != null){
                out.println(adm+"\n");
            }
        }catch(IOException e){
            out.println("File Not Found!");
        }
        adminMenu();
    }
    public void showBookings(){
        System.out.println("The Bookings are:"+bookingCounter);
        for(int i = 0;i<rooms.size();i++){
            if(rooms.get(i).getBooking()==true){
                System.out.format("Room Number is:%d%n",rooms.get(i).getAvailableRooms());
            }
        }
    }
}
