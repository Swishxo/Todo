import java.util.HashMap;
import java.util.Scanner;

public class Todo {
    static HashMap<Integer, String> todo = new HashMap<>();

    public static void main(String[] args){
        menu(todo);
    }

    public static void menu(HashMap<Integer, String> todo){
        Scanner scan = new Scanner(System.in);
        if(todo.isEmpty()){
            createList(todo);
            menu(todo);
        }else{
            System.out.println("Menu sys: \n1=View Items \n2=Delete Items \n3=Add items");
            int choice = scan.nextInt();
            switch(choice){
                case 1:
                    viewItems(todo);
                    menu(todo);
                    break;
                case 2:
                    deleteItems(todo);
                    menu(todo);
                    break;
                case 3:
                    addItems(todo);

                default:
                    System.out.println("You didnt select the correct output");
                    menu(todo);
            }
        }
    }
    //create function to add item
    public static void addItems(HashMap<Integer, String> todo) {
        Scanner scan = new Scanner(System.in);
        viewItems(todo);
        System.out.println("ADD a new item to your list: ");
        String entry = scan.nextLine();
        int count = todo.size();
        todo.merge(count + 1, entry, String::concat);

        menu(todo);
    }

    public static void createList(HashMap<Integer, String> todo){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter (DONE) to end program");

        int count = 1;
        String add;

        do{
            add = scan.next();
            if(add.equals("Done")){
                break;
            } else {
                todo.put(count, add);
                System.out.println("Item added");
                viewItems(todo);
                count++;
            }
        }while(!add.equals("Done"));

    }

    public static void deleteItems(HashMap<Integer, String> item){
        //display items
        viewItems(item);
        Scanner scan = new Scanner(System.in);

        System.out.println("Delete # to remove item");
        int num = scan.nextInt();
        if(item.containsKey(num)){
            System.out.println("item removed: " + item.remove(num));
            viewItems(item);
        }
        else{
            System.out.println("Number provided isn't available");
            menu(item);
        }
    }

    public static void viewItems(HashMap<Integer, String> view){
        for (Integer k: view.keySet()) {
            System.out.println(k + ": " + view.get(k));
        }
    }
}
