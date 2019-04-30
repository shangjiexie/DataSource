<template>
  <div>
    <el-container>
      <el-aside>
        <li style="height:50px">
          <el-button round v-on:click="ManagerGoods">商品管理</el-button>
        </li>
        <li style="height:50px">
          <el-button round v-on:click="ManagerUser">用户管理</el-button>
        </li>
        <li style="height:50px">
          <el-button round v-on:click="Goods">订单管理</el-button>
        </li>
        <li style="height:50px">
          <el-button round v-on:click="SupermarketData">数据统计</el-button>
        </li>
      </el-aside>
      <el-main>
        <router-view v-bind:resource_sort="this.res_type"></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "Register",
  data() {
    return {
      res_type: "10003"
    };
  },
  methods: {
    ManagerGoods() {
      this.res_type = "3";
      this.$router.replace({ name: "ManagerGoods" });
    },
    ManagerUser() {
      this.res_type = "2";
      this.$router.replace({ name: "ManagerUser" });
    },
    Goods() {
      this.$router.replace({ name: "Goods" });
    },
    SupermarketData() {
      this.res_type = "1";
      this.$router.replace({ name: "SupermarketData" });
    }
  }
};
</script>

<style scoped>
</style>