<template>
  <div class="thank-you-wrapper">
    <a-typography-title>Thank you for ordering at {{ restaurant.name }}</a-typography-title>
    <a-typography>We submitted your order to the restaurant. You will receive a confirmation email soon.</a-typography>
    <a-button @click="handleClick">Find a new restaurant</a-button>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'thank-you',
  computed: {
    restaurant() {
      return this.$store.state.restaurant;
    }
  },
  methods: {
    handleClick() {
      this.$router.replace('/');
    }
  }
});
</script>

<style scoped>
.thank-you-wrapper {
  align-items: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 100%;
}

</style>
