package seminar_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Laptop {
    private String brand;
    private String model;
    private int ram;
    private int diskSize;
    private String os;
    private String color;

    public Laptop(String brand, String model, int ram, int diskSize, String os, String color) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.diskSize = diskSize;
        this.os = os;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }
    
    public int getDiskSize() {
        return diskSize;
    }
    
    public String getOs() {
        return os;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }
    

    public void filterLaptops(ArrayList<Laptop> laptops, Map<String, Object> filters) {
        for (Laptop laptop : laptops) {
            boolean passFilter = true;
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String filterKey = entry.getKey();
                Object filterValue = entry.getValue();
                switch (filterKey) {
                    case "ram":
                        int ram = Integer.parseInt(filterValue.toString());
                        if (laptop.getRam() < ram) {
                            passFilter = false;
                        }
                        break;
                    case "diskSize":
                        int diskSize = Integer.parseInt(filterValue.toString());
                        if (laptop.getDiskSize() < diskSize) {
                            passFilter = false;
                        }
                        break;
                    case "os":
                        String os = filterValue.toString();
                        if (!laptop.getOs().equals(os)) {
                            passFilter = false;
                        }
                        break;
                    case "color":
                        String color = filterValue.toString();
                        if (!laptop.getColor().equals(color)) {
                            passFilter = false;
                        }
                        break;
                }
            }
            if (passFilter) {
                System.out.println(laptop.getBrand() + " " + laptop.getModel());
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Lenovo", "IdeaPad 5", 8, 512, "Windows 10", "Серый"));
        laptops.add(new Laptop("ASUS", "ZenBook UX425EA", 16, 512, "Windows 10", "Серебристый"));
        laptops.add(new Laptop("Apple", "MacBook Air", 8, 256, "macOS", "Золотой"));
    
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объём ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
    
        Map<String, Object> filters = new HashMap<>();
    
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                int ram = scanner.nextInt();
                filters.put("ram", ram);
                break;
            case 2:
                System.out.println("Введите минимальное значение объёма ЖД:");
                int diskSize = scanner.nextInt();
                filters.put("diskSize", diskSize);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.next();
                filters.put("os", os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.next();
                filters.put("color", color);
                break;
            default:
                System.out.println("Неправильный выбор");
                return;
        }
    
        Laptop laptop = new Laptop("brand", "model", 0, 0, "os", "color");
        laptop.filterLaptops(laptops, filters);
    }
}    