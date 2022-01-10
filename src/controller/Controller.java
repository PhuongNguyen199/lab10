package controller;

import model.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    ProductService ps = new ProductService();
    Scanner sc = new Scanner(System.in);
    ArrayList<Product> products = ps.addProduct(2);

    public void menu() {
        System.out.println("--------------------");
        System.out.println("1: Xem toan bo san pham");
        System.out.println("2. Tim san pham theo ten");
        System.out.println("3. Liet ke san pham theo mat hang");
        System.out.println("4. Tim theo id");
        System.out.println("5. Them 1 san pham");
        System.out.println("6: Thoat");
    }

    public void submenu() {
        System.out.println("-----------------------------------------");
        System.out.println("1 - Sua ten va gia san pham");
        System.out.println("2 - Xoa san pham");
        System.out.println("3 - Quay lai");
    }

    public void mainMenu() {
        boolean isContinue = true;
        while (isContinue) {
            menu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Danh sach san pham: ");
                    ps.showProduct(products);
                    break;
                case 2:
                    System.out.println("Nhap ten can tim: ");
                    String seachName = sc.nextLine();
                    ps.searchByName(products, seachName);
                    break;
                case 3:
                    System.out.println("Nhap loai mat hang can tim: ");
                    System.out.println("do gia dung \nthuc pham \nthoi trang");
                    String searchItemType = sc.nextLine();
                    ps.searchProduct(products, searchItemType);
                    break;
                case 4:
                    searchById();
                    break;
                case 5:
                    System.out.println("Them san pham moi:");
                    Product newProduct = ps.createProduct();
                    ps.addNewProduct(newProduct, products);
                    System.out.println("Danh sach san pham sau khi them:");
                    ps.showProduct(products);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Khong co lua chon nay");
            }
        }
    }

    public void searchById() {
        System.out.println("Nhap id san pham muon tim: ");
        int id = Integer.parseInt(sc.nextLine());
        Product product = ps.searchById(products, id);
        System.out.println(product);
        submenu();
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                System.out.println("Nhap ten moi:");
                String newTitle = sc.nextLine();
                System.out.println("Nhap gia moi");
                double newPrice = Double.parseDouble(sc.nextLine());
                ps.updateProduct(product, newTitle, newPrice);
                break;
            case 2:
                ps.deleteProduct(products, product);
                System.out.println("Danh sach sau khi xoa: ");
                ps.showProduct(products);
                break;
            case 3:
                menu();
                break;
        }
    }
}
