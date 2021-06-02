<template>
  <a-layout class="layout">
    <Header />
    <a-card style="width: 100%; height: 100%">
      <router-view></router-view>
    </a-card>
  </a-layout>
</template>

<script lang="ts">
import Header from './header.vue';

export default {
  name: 'layout',
  components: { Header }
};
</script>

<style lang="less"
       scoped>

.layout {
  height: 90vh;
  max-width: 90vw;
}

</style>
