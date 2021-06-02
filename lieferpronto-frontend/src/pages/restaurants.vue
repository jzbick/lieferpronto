<template>
  <a-typography-title :level="2">Choose a restaurant</a-typography-title>
  <a-divider />
  <a-list :dataSource="restaurants"
          split>
    <template #renderItem="{item}">
      <router-link :to="`/${item.id}`">
        <a-list-item>
          <a-list-item-meta
              :description="item.description"
          >
            <template #title>
              <a-typography-title :level="4">{{ item.name }}</a-typography-title>
            </template>
          </a-list-item-meta>
        </a-list-item>
      </router-link>
    </template>
  </a-list>
</template>

<script lang="ts">
import { AxiosResponse } from 'axios';
import { defineComponent } from 'vue';
import { Restaurant } from '../types/restaurant';

export default defineComponent({
  name: 'restaurants',
  data() {
    return {
      restaurants: [] as Restaurant[]
    };
  },
  async beforeCreate() {
    const response = await this.$http.get(`${import.meta.env.VITE_API_BASE_URL}/restaurants`) as AxiosResponse<Restaurant[]>;
    this.restaurants = response.data;
  }
});
</script>

<style scoped>

</style>
