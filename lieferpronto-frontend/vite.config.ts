import vue from '@vitejs/plugin-vue';
import { defineConfig } from 'vite';

// https://vitejs.dev/config/
export default defineConfig({
    css: {
        preprocessorOptions: {
            less: {
                modifyVars: {
                    'primary-color': '#1DA57A',
                    'link-color': '#1DA57A',
                    'border-radius-base': '2px',
                    'body-background': '#121212',
                    'component-background': '#121212'
                },
                javascriptEnabled: true,
            },
        }
    },
    plugins: [vue()]
});
