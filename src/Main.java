import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<String> cards = List.of(
//                "4400123456789999",
//                "4000123456123129",
//                "4000123434543555",
//                "3560123451231234",
//                "3399123456123129"
//        );
//
//         List<String> result=cards.stream()
//                .map(str -> {
//                    if (str.startsWith("3")) {
//                        return ("Mastercard: " + str.substring(0, 4) + "********" + str.substring(str.length() - 4));
//                    } else {
//                        return ("VISA: " + str.substring(0, 4) + "********" + str.substring(str.length() - 4));
//                    }
//                }
//                ).toList();
//
//        System.out.println(result);

        List<Product> products = List.of(
                new Product("Яблоко", 450, ProductType.FRUIT),
                new Product("Банан", 700, ProductType.FRUIT),
                new Product("Морковь", 300, ProductType.VEGETABLE),
                new Product("Помидор", 600, ProductType.VEGETABLE),
                new Product("Апельсин", 800, ProductType.FRUIT),
                new Product("Огурец", 400, ProductType.VEGETABLE),
                new Product("Виноград", 1200, ProductType.FRUIT),
                new Product("Картофель", 200, ProductType.VEGETABLE),
                new Product("Говядина", 4500, ProductType.MEAT),
                new Product("Курица", 2000, ProductType.MEAT),
                new Product("Свинина", 3000, ProductType.MEAT),
                new Product("Молоко", 500, ProductType.DAIRY),
                new Product("Сыр", 1500, ProductType.DAIRY),
                new Product("Йогурт", 800, ProductType.DAIRY)
        );


        System.out.println("Task1");
        List<Product> productList = products.stream()
                .filter(product -> product.productType == ProductType.FRUIT)
                .toList();
        System.out.println(productList);
        System.out.println("____________________________");
        System.out.println();


        System.out.println("Task2");
        List<Product> productList2 = products.stream()
                .filter(product -> product.productType == ProductType.VEGETABLE && product.price >= 500)
                .toList();
        System.out.println(productList2);
        System.out.println("____________________________");
        System.out.println();


        System.out.println("Task3");
        long productList3 = products.stream()
                .filter(product -> product.productType == ProductType.MEAT)
                .count();
        System.out.println(productList3);
        System.out.println("____________________________");
        System.out.println();


        System.out.println("Task4");
        long productList4 = products.stream()
                .filter(product -> (product.productType == ProductType.DAIRY))
                .mapToInt(Product::getPrice)
                .sum();
        System.out.println("Сумма всех молочных продуктов: " + productList4);
        System.out.println("____________________________");
        System.out.println();


        //нихера не понял скатал с инета
        System.out.println("Task5");
        List<Product> productList5 = products.stream()
                .sorted(Comparator.comparingInt(Product::getPrice).reversed())
                .limit(3)
                .toList();

        System.out.println("Топ-3 самых дорогих продуктов:");
        for (Product product : productList5) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
        System.out.println("____________________________");
        System.out.println();


        System.out.println("Task6");
        List<Product> productList6 = products.stream()
                .filter(product -> product.name.startsWith("К"))
                .toList();
        System.out.println(productList6);
        System.out.println("____________________________");
        System.out.println();

        System.out.println("Task7");
        List<String> productList7 = products.stream()
                .map(product -> product.getName().toUpperCase())
                .toList();
        System.out.println(productList7);
        System.out.println("____________________________");
        System.out.println();


        //скатал
        System.out.println("Task8");
        double averagePrice = products.stream()
                .mapToInt(Product::getPrice)
                .average()
                .orElse(0.0);

        //скатал
        List<Product> productList8 = products.stream()
                .filter(product -> product.getPrice() > averagePrice)
                .toList();
        System.out.println(productList8);
        System.out.println("____________________________");
        System.out.println();

        System.out.println("Task9");
        List<String> productList9 = products.stream()
                .map(Product::getName)
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        System.out.println(productList9);
        System.out.println("____________________________");
        System.out.println();


//Скатал
        System.out.println("Task10");
        List<Product> sortedProducts = products.stream()
                .sorted(Comparator.comparingInt(p -> p.getProductType().ordinal()))
                .toList();

        for (Product product : sortedProducts) {
            System.out.println(product.getName() + " - " + product.getProductType());
        }
    }
}
