<template>
  <div>
    <h1>{{ msg }}</h1>
    <div style="float:left;width:20%">
      <el-row class="tac" style>
        <el-col :span="12">
          <el-menu default-active="1" class="el-menu-vertical-demo" active-text-color="#ffd04b">
            <el-menu-item index="1">
              <i class="el-icon-menu"></i>
              <span slot="title">
                <router-link :to="{name:'readToConsignmentPage'}">代发货</router-link>
              </span>
            </el-menu-item>
            <el-menu-item index="2">
              <i class="el-icon-menu"></i>
              <span slot="title">
                <router-link :to="{name:'readToReceivedPage'}">待收货</router-link>
              </span>
            </el-menu-item>
            <el-menu-item index="3">
              <i class="el-icon-menu"></i>
              <span slot="title">
                <router-link :to="{name:'readToEvaluatePage'}">待评价</router-link>
              </span>
            </el-menu-item>
            <el-menu-item index="4">
              <i class="el-icon-menu"></i>
              <span slot="title">
                <router-link :to="{name:'ordersPage'}">历史订单</router-link>
              </span>
            </el-menu-item>
            <el-menu-item index="5">
              <i class="el-icon-menu"></i>
              <span slot="title">
                <router-link :to="{name:'infoPage'}">个人信息</router-link>
              </span>
            </el-menu-item>
          </el-menu>
        </el-col>
      </el-row>
    </div>
    <div style="float:left">
      <router-view></router-view>
    </div>
    <!-- <button @click="goToUpPage">返回上一页</button>
    <button @click="goToIndexPage">返回主页</button>-->
  </div>
</template>

<script>
export default {
  name: "MyCenter",
  data() {
    return {
      msg: "Welcome to 个人中心"
    };
  },
  methods: {
    goToUpPage: function() {
      this.$router.go(-1);
    },
    goToIndexPage: function() {
      this.$router.replace({ name: "indexPage" });
    }
  },
  mounted: function() {}
};
</script>

<style scoped>
</style>