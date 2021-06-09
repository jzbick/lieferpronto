<template>
  <div class="cart-header">
    <router-link class="link-back"
                 to="./"
    >
      <a-button type="link">
        <template #icon>
          <arrow-left-outlined />
        </template>
      </a-button>
    </router-link>
    <a-typography-title :level="2">Cart</a-typography-title>
  </div>
  <a-divider />
  <a-list :dataSource="dishes"
          :loading="!dishes"
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
              shape="circle"
              type="primary"
              @click="removeDishFromCart(item)"
          >
            <template #icon>
              <minus-outlined />
            </template>
          </a-button>
        </template>
      </a-list-item>
    </template>
  </a-list>
  <a-divider />
  <div v-if="dishes.length > 0"
       class="cart-button-wrapper">
    <a-select
        v-model:value="paymentMethod"
        class="payment-method-select">
      <a-select-option :value="paymentMethodEnum.DIRECTDEBIT">{{ paymentMethodEnum.DIRECTDEBIT }}</a-select-option>
      <a-select-option :value="paymentMethodEnum.CREDITCARD">{{ paymentMethodEnum.CREDITCARD }}</a-select-option>
      <a-select-option :value="paymentMethodEnum.PAYPAL">{{ paymentMethodEnum.PAYPAL }}</a-select-option>
      <a-select-option :value="paymentMethodEnum.CASHPAYMENT">{{ paymentMethodEnum.CASHPAYMENT }}</a-select-option>
    </a-select>
    <a-button type="primary"
              @click="order">Order
    </a-button>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { Dish, Order, OrderStatus, PaymentMethod } from '../types/restaurant';

export default defineComponent({
  name: 'cart',
  data() {
    return {
      paymentMethod: PaymentMethod.CASHPAYMENT,
      paymentMethodEnum: PaymentMethod
    };
  },
  computed: {
    dishes() {
      return this.$store.state.cart;
    },
  },
  methods: {
    removeDishFromCart(item: Dish) {
      this.$store.dispatch('removeFromCart', item);
    },
    order() {
      this.$http.post(`${import.meta.env.VITE_API_BASE_URL}/orders`, {
        status: OrderStatus.ORDERED,
        orderDate: new Date(),
        paymentMethod: this.paymentMethod,
        dishes: this.dishes,
        restaurant: this.$store.state.restaurant,
      } as Order).then(() => {
        this.$router.replace('/thank-you');
      });
    }
  }
});
</script>

<style lang="less"
       scoped>
.link-back {
  margin: auto .5rem auto 0;
}

.cart-header {
  display: flex;
  flex-direction: row;

  h2 {
    margin: 0;
  }
}

.ant-select {
  width: 15rem;
}

.cart-button-wrapper {
  width: 100%;
  display: flex;
  justify-content: space-between;
}
</style>
