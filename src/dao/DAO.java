package dao;

import utils.Route;

import java.util.Deque;
import java.util.Map;

/**
 * Интерфейс для работы с коллекцией
 */
public interface DAO {
    void create(Route route);
    void update(int id, RouteInfo routeInfo);
    int delete(Route id);
    Route get(int id);
    Deque<Route> getAll();
    int clear();
    Map<String, String> getDescription();
}
