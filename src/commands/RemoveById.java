package commands;

import dao.RouteDAO;
/**
 * Класс команды REMOVE BY ID, предназначенный для удаления элемента по его id
 *
 * @param
 */
public class RemoveById extends ACommands {
    public void execute(RouteDAO routeDAO) {
        if (routeDAO.getAll().size() == 0) {
            System.out.println("коллекция пустая. нечего удалять");
        } else {

            try {
                if (routeDAO.delete(Integer.parseInt(args.get(0))) == 20) {
                    System.out.println("нет элемента с таким id. введите команду заново с правильным id");

                } else {
                    System.out.println("элемент успешно удален");

                }
            } catch (RuntimeException e) {
                System.out.println("некорректный ввод");
            }

        }
    }
}
