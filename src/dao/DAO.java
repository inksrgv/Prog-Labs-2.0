package dao;

import utils.Route;
import utils.RouteInfo;

import java.util.Deque;
import java.util.Map;

public interface DAO {
    void create(Route route);
    void update(int id, RouteInfo routeInfo);
    int delete(int id);
    Route get(int id);
    Deque<Route> getAll();
    int clear();
    Map<String, String> getDescription();
}
