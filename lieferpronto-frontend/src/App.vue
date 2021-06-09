<template>
  <layout>
  </layout>
</template>

<script lang="ts">
import { AxiosResponse } from 'axios';
import { defineComponent } from 'vue';
import Layout from './components/layout.vue';
import { Restaurant } from './types/restaurant';

export default defineComponent({
  name: 'App',
  components: {
    Layout
  },
  async mounted() {
    const response = await this.$http.get(`${import.meta.env.VITE_API_BASE_URL}/restaurants`) as AxiosResponse<Restaurant[]>;
    await this.$store.dispatch('setRestaurants', response.data);
  }
});
</script>

<style lang="less">
body {
  margin: 0;
}

#app {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.title {
  text-align: center;
}
</style>
