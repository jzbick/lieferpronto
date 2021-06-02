<template>
  <div v-if="restaurant !== null">
    <a-typography-title :level="2">{{ restaurant.name }}</a-typography-title>
    <a-divider />
    <a-list :dataSource="restaurant.dishes"
            split>
      <template #renderItem="{item}">
        <a-list-item>
          <a-list-item-meta
              description="Some delicous food"
          >
            <template #title>
              <a-typography-title :level="4">{{ item.name }}</a-typography-title>
            </template>
          </a-list-item-meta>
          <template #actions>
            <a-button
                type="primary"
                @click="console.log('click')"
            >
              <template #icon>
                <PlusOutlined />
              </template>
            </a-button>
          </template>
        </a-list-item>
      </template>
    </a-list>
  </div>
  <div v-else
       class="spin-wrapper">
    <a-spin></a-spin>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { Restaurant } from '../types/restaurant';

export default defineComponent({
  name: 'restaurant',
  data() {
    return {
      restaurant: null as Restaurant
    };
  },
  async beforeCreate() {
    this.restaurant = await this.$http.get(`${import.meta.env.VITE_API_BASE_URL}/restaurants/${this.$route.params.id}`).then(result => result.data);
  }
});
</script>

<style scoped>

.spin-wrapper {
  align-items: center;
  display: flex;
  height: 100%;
  justify-content: center;
  width: 100%;
}

</style>
