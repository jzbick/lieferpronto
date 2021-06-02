<template>
  <layout>
  </layout>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import Layout from './components/layout.vue';

export default defineComponent({
  name: 'App',
  components: {
    Layout
  },
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
