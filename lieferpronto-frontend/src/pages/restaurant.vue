<template>
  <div v-if="restaurant">
    <div class="restaurant-header">
      <div>
        <router-link class="link-back"
                     to="/"
                     @click="removeRestaurant"
        >
          <a-button type="link">
            <template #icon>
              <arrow-left-outlined />
            </template>
          </a-button>
        </router-link>
        <a-typography-title :level="2">{{ restaurant.name }}</a-typography-title>
      </div>
      <a-badge :count="count"
               class="badge">
        <router-link :to="`/${restaurant.slug}/cart`">
          <a-button>
            <template #icon>
              <shopping-cart-outlined />
            </template>
          </a-button>
        </router-link>
      </a-badge>
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
                type="primary"
                shape="circle"
                @click="addDishToCart(item)"
            >
              <template #icon>
                <plus-outlined />
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
import { State } from '../store';
import { Dish, Restaurant } from '../types/restaurant';

export default defineComponent({
  name: 'restaurant',
  data() {
    return {
      dishes: [] as Dish[],
      unsubscribe: () => {}
    };
  },
  computed: {
    restaurant(): Restaurant | undefined {
      return this.$store.state.restaurant;
    },
    count() {
      return this.$store.state.cart.length;
    },
  },
  methods: {
    addDishToCart(dish: Dish) {
      this.$store.dispatch('pushToCart', dish);
    },
    async getDishes(state: State) {
      if (!state.restaurant) {
        let restaurant = state.restaurants.find(restaurant => restaurant.slug === this.$route.params.slug);
        await this.$store.dispatch('setRestaurant', restaurant);
      }
      if (state.restaurant) {
        this.dishes = await this.$http.get<Dish[]>(`${import.meta.env.VITE_API_BASE_URL}/restaurants/${state.restaurant?.id}/dishes`).then(res => res.data);
      }
    },
    removeRestaurant() {
      this.unsubscribe();
      this.$store.dispatch('setRestaurant', undefined);
    }
  },
  mounted() {
    this.getDishes(this.$store.state);
    this.unsubscribe = this.$store.subscribe(async (mutation, state) => {
      await this.getDishes(state);
    });
  },

});
</script>

<style lang="less"
       scoped>

.spin-wrapper {
  align-items: center;
  display: flex;
  height: 100%;
  justify-content: center;
  width: 100%;
}

.link-back {
  margin: auto .5rem auto 0;
}

.badge {
  align-self: center;
  justify-self: flex-end;
}

.restaurant-header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;

  div {
    display: flex;
    flex-direction: row;
  }

  h2 {
    margin: 0;
  }
}

</style>
