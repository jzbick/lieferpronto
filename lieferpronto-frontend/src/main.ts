import { ArrowLeftOutlined, MinusOutlined, PlusOutlined, ShoppingCartOutlined } from '@ant-design/icons-vue';
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.dark.less';
import axios from 'axios';
import { createApp } from 'vue';
import VueAxios from 'vue-axios';
import { createRouter, createWebHashHistory } from 'vue-router';
import App from './App.vue';
import cart from './pages/cart.vue';
import restaurant from './pages/restaurant.vue';
import restaurants from './pages/restaurants.vue';
import thankYou from './pages/thank-you.vue';
import { key, store } from './store';

const app = createApp(App);

const routes = [
    { path: '/', component: restaurants },
    { path: '/:slug', component: restaurant },
    { path: '/:slug/cart', component: cart },
    { path: '/thank-you', component: thankYou },
];

const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
});

app.use(Antd);
app.use(router);
app.use(VueAxios, axios);
app.use(store, key);
app.component('plus-outlined', PlusOutlined);
app.component('minus-outlined', MinusOutlined);
app.component('arrow-left-outlined', ArrowLeftOutlined);
app.component('shopping-cart-outlined', ShoppingCartOutlined);

app.mount('#app');
