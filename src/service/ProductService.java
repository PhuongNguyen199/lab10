package service;

import model.ItemType;
import model.Product;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ProductService {

    public Product createProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ten");
        String name = sc.nextLine();
        System.out.println("Nhap gia:");
        double price = Double.parseDouble(sc.nextLine());

        System.out.println("Chon loai mat hang: ");
        System.out.println("0 - Do gia dung");
        System.out.println("1 - Thuc pham");
        System.out.println("2 - Thoi trang");
        int choice = Integer.parseInt(sc.nextLine());
        ItemType itemType = ItemType.fashion;
        if (choice == 0) {
            itemType = ItemType.Houseware;
        } else if (choice == 1) {
            itemType = ItemType.food;
        } else if (choice == 2) {
            itemType = ItemType.fashion;
        } else
            System.out.println("khong co loai mat hang nay");

        System.out.println("Nhap so luong ban: ");
        int quantitySold = Integer.parseInt(sc.nextLine());

        Product pr = new Product(id, name, price, itemType, quantitySold);
        return pr;
    }

    public ArrayList<Product> addProduct(int size) {
        ArrayList<Product> products1 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Nhap mat hang thu " + i);
            products1.add(createProduct());
        }
        return products1;
    }

    public void showProduct(ArrayList<Product> products) {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void searchByName(ArrayList<Product> products, String searchName) {
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println(p);
            }
        }
    }

    public void searchProduct(ArrayList<Product> products, String searchItemType) {
        for (Product p : products) {
            if ((p.getItemType().getValue()).equals(searchItemType)) {
                System.out.println(p);
            }
        }
    }

    public Product searchById(ArrayList<Product> products, int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void updateProduct(Product product, String newName, double newPrice) {
        product.setName(newName);
        product.setPrice(newPrice);
        System.out.println(product);
    }

    public void deleteProduct(ArrayList<Product> products, Product product) {
        products.remove(product);
    }

    public void addNewProduct(Product product, ArrayList<Product> products){
        products.add(product);
    }
}
