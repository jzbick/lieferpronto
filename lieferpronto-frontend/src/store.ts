import { InjectionKey } from 'vue';
import { createStore, Store } from 'vuex';
import { Dish, Restaurant } from './types/restaurant';

export interface State {
    restaurants: Restaurant[]
    restaurant?: Restaurant
    cart: Dish[]
}

export const key: InjectionKey<Store<State>> = Symbol();

export const store = createStore<State>({
    state(): State {
        return {
            restaurants: [],
            restaurant: undefined,
            cart: []
        };
    },
    mutations: {
        setRestaurants(state, restaurants: Restaurant[]) {
            state.restaurants = restaurants;
        },
        setRestaurant(state, restaurant: Restaurant) {
            state.restaurant = restaurant;
        },
        setCart(state, cart: Dish[]) {
            state.cart = cart;
        },
        pushToCart(state, dish: Dish) {
            state.cart.push(dish);
        },
        removeFromCart(state, dish: Dish) {
            state.cart = state.cart.filter(e => e !== dish);
        }
    },
    actions: {
        setRestaurants(context, restaurants: Restaurant[]) {
            context.commit('setRestaurants', restaurants);
        },
        setRestaurant(context, restaurant: Restaurant) {
            context.commit('setRestaurant', restaurant);
        },
        setCart(context, cart: Dish[]) {
            context.commit('setCart', cart);
        },
        pushToCart(context, dish: Dish) {
            context.commit('pushToCart', dish);
        },
        removeFromCart(context, dish: Dish) {
            context.commit('removeFromCart', dish);
        }
    }
});
