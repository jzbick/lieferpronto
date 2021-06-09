<template>
  <a-typography-title :level="2">Choose a restaurant</a-typography-title>
  <a-divider />
  <a-list :dataSource="restaurants"
          split>
    <template #renderItem="{item}">
      <router-link :to="`/${item.slug}`">
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
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'restaurants',
  computed: {
    restaurants() {
      return this.$store.state.restaurants;
    }
  },
  mounted() {
    this.$store.dispatch('setCart', []);
  }
});
</script>

<style scoped>

</style>
