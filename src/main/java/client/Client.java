package client;

import tankstelle.controller.TankController;
import tankstelle.domain.Tank;
import tankstelle.repository.TankRepository;
import tankstelle.repository.TankRepositoryFile;
import tankstelle.service.TankService;
import tankstelle.service.TankServiceImpl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // Очищаємо файл перед збереженням нових даних
//        FileWriter writer = new FileWriter("tank_data.txt", false); // false - очищає файл
//        writer.write("");
//        writer.close();
        TankRepository repository = new TankRepositoryFile();
        TankService service = new TankServiceImpl(repository);
        TankController controller = new TankController(service);

//        controller.save("Diesel", 3.33);
//        controller.save("AИ-76", 3.50);
//        controller.save("AИ-80", 6.50);
//        controller.save("AИ-92", 3.05);
//        controller.save("AИ-98", 4.10);


        // Отримати всі продукти
        System.out.println("List of all products:");
        List<Tank> products = controller.findAll();
        products.forEach(System.out::println);

        List<Tank> sortedProducts = new ArrayList<>(products);
//
        // Сортувати список продуктів
        sortedProducts.sort(Comparator.comparingDouble(Tank::getPrice));

        // Вивести відсортований список
        System.out.println("\nList of all products (after sorting by price):");
        sortedProducts.forEach(System.out::println);
////
//        System.out.println("Product ID 2:");
//        Tank tank = controller.findByIdTank(2L);
//        System.out.println(tank);
    }
}
//Копія списку: Ми створюємо копію списку за допомогою конструктора
// ArrayList<>(controller.findAll()).
// Це дозволяє нам мати змінний список, з яким можна виконувати операції,
// зокрема сортування.