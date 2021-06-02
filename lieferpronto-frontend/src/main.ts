import { PlusOutlined } from '@ant-design/icons-vue';
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.dark.less';
import axios from 'axios';
import { createApp } from 'vue';
import VueAxios from 'vue-axios';
import { createRouter, createWebHashHistory } from 'vue-router';
import App from './App.vue';
import restaurant from './pages/restaurant.vue';
import restaurants from './pages/restaurants.vue';

const app = createApp(App);

const routes = [
    { path: '/', component: restaurants },
    { path: '/:id', component: restaurant }
];

const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
});

app.use(Antd);
app.use(router);
app.use(VueAxios, axios);
app.component('PlusOutlined', PlusOutlined);

app.mount('#app');
