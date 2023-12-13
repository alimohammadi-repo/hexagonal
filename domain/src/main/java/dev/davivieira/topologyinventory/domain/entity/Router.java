package dev.davivieira.topologyinventory.domain.entity;

import dev.davivieira.topologyinventory.domain.vo.*;
import lombok.Getter;

import java.util.function.Predicate;

@Getter
public abstract sealed class Router extends Equipment
        permits CoreRouter, EdgeRouter {

    protected final RouterType routerType;
    public static Predicate<Router>
    getRouterTypePredicate(RouterType routerType){
        return r -> r.getRouterType().equals(routerType);
    }

    public static Predicate<Equipment>
    getModelPredicate(Model model){
        return r -> r.getModel().equals(model);
    }

    public static Predicate<Equipment>getCountryPredicate(Location location){
        return p ->
                p.location.country().equals(location.country());
    }


    public Router(Id id, Vendor vendor, Model model, IP ip, Location location, RouterType routerType) {
        super(id, vendor, model, ip, location);
        this.routerType = routerType;
    }
}
